package com.yzh.rfidbike_sustain;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.foxconn.rfid.theowner.activity.AbnormalBSActivity;
import com.foxconn.rfid.theowner.activity.DeviceSetupActivity;
import com.foxconn.rfid.theowner.activity.MessageCenterSecondActivity;
import com.foxconn.rfid.theowner.activity.SearchDeviceActivity;
import com.foxconn.rfid.theowner.activity.SettingActivity;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.base.BaseApplication;
import com.foxconn.rfid.theowner.fragment.CompanyListFragment;
import com.foxconn.rfid.theowner.view.widgets.Header;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements Header.headerListener {

    @BindView(R.id.header)
    Header mHeader;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    private CompanyListFragment mCompanyListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mHeader.setListener(this);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (mCompanyListFragment == null) {
            mCompanyListFragment = new CompanyListFragment();
        }
        transaction.replace(R.id.ll_container, mCompanyListFragment);
        transaction.commit();

        onPushMessageHandle();

    }

    private void onPushMessageHandle() {
        if (BaseApplication.getInstance().needGoToMessageCenter) {
            Intent intentNew = new Intent();
            intentNew.setClass(context.getApplicationContext(), MessageCenterSecondActivity.class);
            intentNew.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.getApplicationContext().startActivity(intentNew);
        }
    }

    @OnClick({R.id.ll_baseStationList, R.id.ll_installBaseStation, R.id.ll_abnormal_baseStation})
    public void onClick(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.ll_baseStationList:
                if (mCompanyListFragment != null) {
                    transaction.show(mCompanyListFragment);
                } else {
                    mCompanyListFragment = new CompanyListFragment();
                    transaction.add(R.id.ll_container, mCompanyListFragment);
                }

                break;

            //异常基站
            case R.id.ll_abnormal_baseStation:
                startActivity(new Intent(MainActivity.this, AbnormalBSActivity.class));
                break;

            //安装基站
            case R.id.ll_installBaseStation:
                startActivity(new Intent(MainActivity.this, DeviceSetupActivity.class));

//                if (mInstallBaseStationFragment != null) {
//                    transaction.show(mInstallBaseStationFragment);
//                } else {
//                    mInstallBaseStationFragment = new InstallBaseStationFragment();
//                    transaction.add(R.id.ll_container, mInstallBaseStationFragment);
//                }
//                if (mCompanyListFragment != null) {
//                    transaction.hide(mCompanyListFragment);
//                }

                break;
        }
        transaction.commit();
    }

    @Override
    public void onClickLeftIcon() {
        startActivity(new Intent(this, SettingActivity.class));
    }

    @Override
    public void onClickRightIcon() {
        startActivity(new Intent(this, SearchDeviceActivity.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        onPushMessageHandle();
    }

    private long presstime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
/**
 * web.canGoBack()判断webview是否有可以返回的页面
 */
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - presstime < 2000) {
                this.finish();
            } else {
                Toast.makeText(getApplicationContext(), "再按一次退出本应用", Toast.LENGTH_SHORT).show();
                presstime = System.currentTimeMillis();
            }

        }
        return true;
    }
}
