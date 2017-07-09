/**
 *
 */
package com.foxconn.rfid.theowner.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.foxconn.rfid.theowner.adapter.SettingAdapter;
import com.foxconn.rfid.theowner.base.App;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.base.BaseApplication;
import com.foxconn.rfid.theowner.base.PreferenceData;
import com.foxconn.rfid.theowner.socket.SocketAppPacket;
import com.foxconn.rfid.theowner.socket.SocketClient;
import com.foxconn.rfid.theowner.util.ToolsUtils;
import com.foxconn.rfid.theowner.util.file.FileUtils;
import com.foxconn.rfid.theowner.util.logort.ToastUtils;
import com.foxconn.rfid.theowner.view.widgets.Header;
import com.yzh.rfid.app.request.CheckUpdateRequest;
import com.yzh.rfid.app.request.LogoutRequest;
import com.yzh.rfid.app.request.PlatformTypes;
import com.yzh.rfid.app.response.CheckUpdateResponse;
import com.yzh.rfid.app.response.CommonResponse;
import com.yzh.rfidbike_sustain.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author WT00111
 */
public class SettingActivity extends BaseActivity implements Header.headerListener {

    @BindView(R.id.lv_setting)
    ListView mLvSetting;
    @BindView(R.id.header)
    Header mHeader;

    private static final int MSG_cannt_get_data = 1000;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case MSG_cannt_get_data:
                        if (dlgWaiting.isShowing()) {
                            dlgWaiting.dismiss();
                            Toast.makeText(SettingActivity.this, R.string.network_error, Toast
                                    .LENGTH_SHORT).show();
                        }
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//		super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        initView();
        mHeader.setListener(this);
    }

    protected void initView() {
        mLvSetting.setAdapter(new SettingAdapter(this));
        mLvSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(SettingActivity.this, PersonalInfoActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(SettingActivity.this, UpdatePasswordActivity
                                .class));
                        break;
                    case 2:
                        startActivity(new Intent(SettingActivity.this, MessageCenterSecondActivity
                                .class));
                        break;
                    case 3:
                        doVersionUpdate(); //版本更新
//                        startActivity(new Intent(SettingActivity.this, VersionUpdateActivity
//                                .class));
                        break;
                    case 4:
                        doLoginOutSocket();

                        break;
                }
            }
        });
    }

    //退出登陆
    private void doLoginOutSocket() {
        doSocket();
        final LogoutRequest.LogoutRequestMessage.Builder logoutbuilder = LogoutRequest.LogoutRequestMessage.newBuilder();

        logoutbuilder.setUserId(PreferenceData.loadLoginAccount(context));

        new Thread() {
            public void run() {
                SocketClient client;
                client = SocketClient.getInstance();
                client.send(SocketAppPacket.COMMAND_ID_LOGIINOUT, logoutbuilder.build().toByteArray());
            }

        }.start();

    }

    //升级版本
    private void doVersionUpdate() {
        doSocket();
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                SocketClient client = SocketClient.getInstance();
                CheckUpdateRequest.CheckUpdateRequestMessage.Builder requestMessage =
                        CheckUpdateRequest.CheckUpdateRequestMessage.newBuilder();
                requestMessage.setAppVersion(ToolsUtils
                        .getAppVersionName(SettingActivity.this
                                .getApplicationContext()));
                requestMessage.setPlatformType(PlatformTypes.PlatformType.AndroidPhone);
                client.send(SocketAppPacket.COMMAND_ID_GET_APP_VERSION, requestMessage
                        .build().toByteArray());
            }
        }).start();
    }

    @Override
    public void onEventMainThread(SocketAppPacket eventPackage) {
        try {
            mHandler.removeMessages(MSG_cannt_get_data);
            if (dlgWaiting.isShowing()) {
                dlgWaiting.dismiss();
            }
            if (eventPackage.getCommandId() == SocketAppPacket.COMMAND_ID_GET_APP_VERSION) {
                if (BaseApplication.getInstance().isChangeLanguage) {
                    return;
                }
                final CheckUpdateResponse.CheckUpdateResponseMessage responseMessage;

                responseMessage = CheckUpdateResponse.CheckUpdateResponseMessage.parseFrom
                        (eventPackage.getCommandData());

                if (responseMessage.getErrorMsg().getErrorCode() == 0) {
                    if (responseMessage.getVersion().length() > 0) {
                        LayoutInflater inflater = this.getLayoutInflater();
                        View layout = inflater.inflate(R.layout.dlg_version_update, null);
                        final Dialog dlgVersionUpdate = new AlertDialog.Builder(this).setView
                                (layout).create();
                        dlgVersionUpdate.show();

                        TextView tv_cancel = (TextView) dlgVersionUpdate.findViewById(R.id
                                .tv_cancel);
                        TextView tv_sure = (TextView) dlgVersionUpdate.findViewById(R.id.tv_sure);
                        TextView tv_content = (TextView) dlgVersionUpdate.findViewById(R.id
                                .tv_content);
                        tv_content.setText(this.getResources().getString(R.string.last_version) +
                                responseMessage.getVersion() + "\n" + responseMessage
                                .getUpdateLog());
                        tv_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dlgVersionUpdate.dismiss();
                            }
                        });
                        tv_sure.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dlgVersionUpdate.dismiss();
                                downloadFile(
                                        responseMessage.getUpdateURL(),
                                        getString(R.string.app_name),
                                        getString(R.string.home_dlg_download_title));
                            }
                        });
                    } else {
                        ToastUtils.showTextToast(context, SettingActivity.this.getResources
                                ().getString(R.string.lastest_version), 2000);
                    }
                }
            }
            if (eventPackage.getCommandId() == SocketAppPacket.COMMAND_ID_LOGIINOUT) {
                CommonResponse.CommonResponseMessage commonResponseMessage = CommonResponse.CommonResponseMessage.parseFrom(eventPackage.getCommandData());
                if (commonResponseMessage.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(SettingActivity.this, commonResponseMessage.getErrorMsg()
                            .getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (commonResponseMessage.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }else {
                    //退出登陆success
//                    Toast.makeText(SettingActivity.this, "退出登陆success", Toast
//                            .LENGTH_SHORT).show();
//                    PushManager.stopWork(SettingActivity.this);
                    PreferenceData.saveLoginAccount(SettingActivity.this, -1);
                    Intent in = new Intent(SettingActivity.this, LoginActivity.class);
                    in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent
                            .FLAG_ACTIVITY_NEW_TASK);
                    startActivity(in);
                }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * APK文件下载
     *
     * @param url
     * @param fileName
     */
    private void downloadFile(String url, String fileName, String title) {
        // 创建ProgressDialog对象
        final ProgressDialog dlg = new ProgressDialog(this);
        // 设置进度条风格，风格为圆形，旋转的
        dlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // 设置ProgressDialog 标题
        // dlg.setTitle(R.string.home_dlg_download_title);
        dlg.setTitle(title);
        dlg.setIcon(R.drawable.logo);
        dlg.setMax(100);
        // 设置ProgressDialog 的进度条是否不明确 false 就是不设置为不明确
        dlg.setIndeterminate(false);
        // 设置ProgressDialog 是否可以按退回键取消
        dlg.setCancelable(false);
        dlg.setCanceledOnTouchOutside(false);

        File target = null;
        if (FileUtils.isSDCardMounted()) {
            target = Environment
                    .getExternalStoragePublicDirectory(App.IMAGE_CACHE_PATH
                            + fileName + ".apk");
            // target = new File (App.IMAGE_CACHE_PATH + fileName + ".apk");
        }
        AQuery homeAq = new AQuery(this);
        homeAq.progress(dlg).download(url, target, new AjaxCallback<File>() {
            public void callback(String url, File file, AjaxStatus status) {
                if (status.getCode() == 200 && file != null) {
                    logMessage("Http-->File:" + file.length() + ":" + file);
                    Uri uri = Uri.fromFile(file);
                    Intent intent = new Intent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setDataAndType(uri,
                            "application/vnd.android.package-archive");
                    startActivity(intent);
                } else {
                    logMessage("Http-->Failed");
                    Toast.makeText(SettingActivity.this,
                            R.string.home_dlg_download_update_fail,
                            Toast.LENGTH_SHORT).show();
                }
                dlg.cancel();
            }
        });
        // 让ProgressDialog显示
        dlg.show();

    }

    @Override
    public void onClickLeftIcon() {
        super.onBackPressed();
    }

    @Override
    public void onClickRightIcon() {

    }
}
