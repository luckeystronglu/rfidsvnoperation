package com.foxconn.rfid.theowner.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.foxconn.rfid.theowner.adapter.DeviceAdapter;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.base.BaseApplication;
import com.foxconn.rfid.theowner.socket.SocketAppPacket;
import com.foxconn.rfid.theowner.socket.SocketClient;
import com.foxconn.rfid.theowner.view.widgets.Header;
import com.google.protobuf.InvalidProtocolBufferException;
import com.yzh.rfid.app.request.GetDevicesByCompanyDeviceIdRequest;
import com.yzh.rfid.app.response.Device;
import com.yzh.rfid.app.response.GetDevicesResponse;
import com.yzh.rfidbike_sustain.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.androidcommon.adapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class DeviceListActivity extends BaseActivity implements Header.headerListener,
        BGARefreshLayout.BGARefreshLayoutDelegate {

    @BindView(R.id.rv_baseStation)
    RecyclerView mRvDevice;
    @BindView(R.id.refresh_layout)
    BGARefreshLayout mRefreshLayout;
    @BindView(R.id.header)
    Header mHeader;
    private List<Device.DeviceMessage> mDeviceList;
    private DeviceAdapter mDeviceAdapter;
    private String mSession;
    private long mCompanyId;
    private Context mContext = this;
    private boolean mPullToFresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        ButterKnife.bind(this);
        mHeader.setListener(this);
        final Intent intent = getIntent();
        mSession = intent.getStringExtra("session");
        mCompanyId = intent.getLongExtra("companyId", 0);

        mRvDevice.setLayoutManager(new LinearLayoutManager(this));
        mDeviceAdapter = new DeviceAdapter(mRvDevice);
        mRvDevice.setAdapter(mDeviceAdapter);
        doSocket();
        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(mContext, true));
        mRefreshLayout.setDelegate(this);
        mDeviceAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
            @Override
            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
//                Device.DeviceMessage message = mDeviceAdapter.getItem(position);
                Device.DeviceMessage message = mDeviceList.get(position);

                Intent intent = new Intent(mContext, ReadCardMessageActivity.class);
                intent.putExtra("DeviceMessage", message);
                startActivity(intent);
//                ActivityManager.getInstance().finishActivities(SubCompanyListActivity.class);
//                finish();

            }
        });
    }

    @Override
    protected void doSocket() {
        super.doSocket();

        if (mPullToFresh && dlgWaiting.isShowing()) {
            dlgWaiting.dismiss();
        }

        final GetDevicesByCompanyDeviceIdRequest.GetDevicesByCompanyDeviceIdRequestMessage
                .Builder requestMessage =
                GetDevicesByCompanyDeviceIdRequest
                        .GetDevicesByCompanyDeviceIdRequestMessage.newBuilder();
        requestMessage.setSession(mSession);
        requestMessage.setCompanyId(mCompanyId);
        new Thread() {
            public void run() {
                SocketClient client;
                client = SocketClient.getInstance();
                BaseApplication.getInstance().curContext=DeviceListActivity.this.getLocalClassName();
                client.send(SocketAppPacket.GET_DEVICE_LIST_DEPEND_DEVICE_ID,
                        requestMessage.build()
                                .toByteArray());
            }

        }.start();

    }

    @Override
    public void onEventMainThread(SocketAppPacket eventPackage) {
        try {
            super.onEventMainThread(eventPackage);
            if (eventPackage.getCommandId() == SocketAppPacket.GET_DEVICE_LIST_DEPEND_DEVICE_ID
                    && BaseApplication.getInstance().curContext.equals(DeviceListActivity.this.getLocalClassName())) {
                GetDevicesResponse.GetDevicesResponseMessage responseMessage =
                        GetDevicesResponse
                                .GetDevicesResponseMessage.parseFrom(eventPackage
                                .getCommandData());
                mRefreshLayout.endRefreshing();
                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);
                if (responseMessage.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(mContext, responseMessage.getErrorMsg()
                            .getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (responseMessage.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {
                    mDeviceList = responseMessage.getDeviceList();
                    mDeviceAdapter.setData(mDeviceList);
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
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mPullToFresh = true;
        doSocket();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
