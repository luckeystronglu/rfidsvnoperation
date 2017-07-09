package com.foxconn.rfid.theowner.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.foxconn.rfid.theowner.adapter.CompanyAdapter;
import com.foxconn.rfid.theowner.base.App;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.model.CompanyUser;
import com.foxconn.rfid.theowner.socket.SocketAppPacket;
import com.foxconn.rfid.theowner.socket.SocketClient;
import com.foxconn.rfid.theowner.util.ActivityManager;
import com.foxconn.rfid.theowner.view.widgets.Header;
import com.google.protobuf.InvalidProtocolBufferException;
import com.yzh.rfid.app.request.GetCompanyListRequest;
import com.yzh.rfid.app.response.Company;
import com.yzh.rfid.app.response.GetCompanyListResponse;
import com.yzh.rfidbike_sustain.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import de.greenrobot.event.EventBus;

public class SubCompanyListActivity extends BaseActivity implements Header.headerListener,
        BGARefreshLayout.BGARefreshLayoutDelegate {

    @BindView(R.id.rv_subCompany)
    RecyclerView mRvCompany;
    @BindView(R.id.refresh_layout)
    BGARefreshLayout mRefreshLayout;
    @BindView(R.id.header)
    Header mHeader;
    private List<Company.CompanyMessage> mCompanyList;
    private CompanyAdapter mCompanyAdapter;
    private String mSession;
    private long mCompanyId;
    private int mUserId;
    private Context mContext = this;
    private boolean mPullToFresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_company);
        ButterKnife.bind(this);
        ActivityManager.getInstance().addActivity(this);
        mHeader.setListener(this);
        Intent intent = getIntent();
        mSession = intent.getStringExtra("session");
        mCompanyId = intent.getLongExtra("companyId", 0);
        mUserId = intent.getIntExtra("userId", 0);

        mRvCompany.setLayoutManager(new LinearLayoutManager(this));
        mCompanyAdapter = new CompanyAdapter(mRvCompany);
        mRvCompany.setAdapter(mCompanyAdapter);
        doSocket();

        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(mContext, true));
        mRefreshLayout.setDelegate(this);
        mCompanyAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                if (mCompanyAdapter.getItem(position).getHasChild().equals("0")) {
                    Intent intent = new Intent();
                    CompanyUser companyUser = CompanyUser.getCurUser(mContext);

                    intent.putExtra("session", companyUser.getSession());
                    intent.putExtra("companyId", mCompanyAdapter.getItem(position).getId());
                    intent.setClass(mContext, DeviceListActivity.class);
                    startActivity(intent);
                }
                if (mCompanyAdapter.getItem(position).getHasChild().equals("1")) {
                    Intent intent = new Intent();
                    CompanyUser companyUser = CompanyUser.getCurUser(mContext);

                    intent.putExtra("userId", companyUser.getUserId());
                    intent.putExtra("session", companyUser.getSession());
                    intent.putExtra("companyId", mCompanyAdapter.getItem(position).getId());
                    intent.setClass(mContext, SubCompanyListActivity.class);
                    startActivity(intent);
                }
            }

        });
    }

    @Override
    protected void doSocket() {
        super.doSocket();
        if (mPullToFresh && dlgWaiting.isShowing()) {
            dlgWaiting.dismiss();
        }

        final GetCompanyListRequest.GetCompanyListRequestMessage.Builder requestMessage =
                GetCompanyListRequest
                        .GetCompanyListRequestMessage.newBuilder();
        requestMessage.setSession(mSession);
        requestMessage.setCompanyId(mCompanyId);
        requestMessage.setUserId(mUserId);
        new Thread() {
            public void run() {
                SocketClient client;
                client = SocketClient.getInstance();
                client.send(SocketAppPacket.GET_COMPANY_LIST, requestMessage.build()
                        .toByteArray());
            }

        }.start();

    }

    @Override
    public void onEventMainThread(SocketAppPacket eventPackage) {
        try {
            super.onEventMainThread(eventPackage);
            if (eventPackage.getCommandId() == SocketAppPacket.GET_COMPANY_LIST) {
                GetCompanyListResponse.GetCompanyListResponseMessage responseMessage =
                        GetCompanyListResponse
                                .GetCompanyListResponseMessage.parseFrom(eventPackage
                                .getCommandData());
                mRefreshLayout.endRefreshing();
                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);
                if (responseMessage.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(SubCompanyListActivity.this, responseMessage.getErrorMsg()
                            .getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (responseMessage.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {
                    mCompanyList = responseMessage.getCompanyMessageList();
                    mCompanyAdapter.setData(mCompanyList);
                }
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        mPullToFresh = false;

    }

    @Override
    protected void getDataErr() {
        super.getDataErr();
        mRefreshLayout.endRefreshing();
    }

    @Override
    public void onClickLeftIcon() {
        super.onBackPressed();
    }

    @Override
    public void onClickRightIcon() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);

    }

    @Override
    protected void onDestroy() {
        logMessage("--->onDestroy()...");
        super.onDestroy();
        mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);
        App.activityList.remove(this);
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mPullToFresh = true;
        doSocket();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
