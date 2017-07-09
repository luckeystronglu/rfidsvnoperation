package com.foxconn.rfid.theowner.activity;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.foxconn.rfid.theowner.adapter.AdapterReadCardMsg;
import com.foxconn.rfid.theowner.base.App;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.base.PreferenceData;
import com.foxconn.rfid.theowner.model.EventBusMsgPush;
import com.foxconn.rfid.theowner.socket.SocketAppPacket;
import com.foxconn.rfid.theowner.socket.SocketClient;
import com.foxconn.rfid.theowner.util.DialogUtils;
import com.foxconn.rfid.theowner.util.logort.ToastUtils;
import com.foxconn.rfid.theowner.view.widgets.Header;
import com.google.protobuf.InvalidProtocolBufferException;
import com.yzh.rfid.app.request.KeepDeviceReadRecordRequest;
import com.yzh.rfid.app.request.TurnOnOffDeviceReadRecordRequest;
import com.yzh.rfid.app.response.CommonResponse;
import com.yzh.rfid.app.response.Device;
import com.yzh.rfidbike_sustain.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by appadmin on 2016/12/30.
 */

public class ReadCardMessageActivity extends BaseActivity implements View.OnClickListener, Header.headerListener, AdapterReadCardMsg.OnDeleteClickListener {

    private Header header;
    private ListView listView;
    private AdapterReadCardMsg adapter;
    private RelativeLayout rl_config, rl_mapshow;

    private LinearLayout ll_bs_device;
    private List<EventBusMsgPush> list;
    private Device.DeviceMessage deviceMessage;

    //    private TextView delete_all_tv;
//    private AlertDialog deleteAlertDialog, deleteAlertDialog2;
    private TextView tv_start;
    private AlertDialog deleteAlertDialog;
    private TextView tv_cancel, tv_sure;
    private ImageView iv_cancel;
    private boolean onOff = false;

    private static final int UPDATE_TAG = 0x8971;
    private static final int GAP_TIME = 60 * 1000;
    private static final int MSG_ANIM_FINISH = 3256;
    private boolean isStart = true;
    private boolean isMonitor = false;
    private Handler updateHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case UPDATE_TAG:
                        if (isMonitor) {
                            monitoringSocket();
//                        ToastUtils.showTextToast(ReadCardMessageActivity.this, getResources().getString(R.string
//                                .monitoring));
                        }
                        break;
                    case MSG_ANIM_FINISH:
//                        if (dlgWaiting.isShowing()) {
//                            dlgWaiting.dismiss();
//                        }
                        ToastUtils.showTextToast(context,"测试结束");
                        isStart = true;
                        tv_start.setText("开始");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readcard_msg);

        initView();
        initDialog1();
//        initDialog2();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开启监控基站读卡推送
        onOff = true;
        doSocket();
    }

    private void initView() {
        Intent intent = getIntent();
        deviceMessage = (Device.DeviceMessage) intent.getSerializableExtra("DeviceMessage");

        ll_bs_device = findViewByIds(R.id.ll_bs_device);
        ll_bs_device.setVisibility(View.GONE);
        list = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            ReadCardMsgEntity entity = new ReadCardMsgEntity("读卡消息" + i, System.currentTimeMillis() + 300 * 1000 * i, "恭喜发财，红包拿来"+20*i);
//            list.add(entity);
//        }

        header = findViewByIds(R.id.readcard_header);
        header.setTitle(deviceMessage.getDeviceIdDecimal());
        header.setListener(this);

        listView = findViewByIds(R.id.lv_readcard_msg);
        adapter = new AdapterReadCardMsg(this);
        adapter.setOnDeleteClickListener(this);
        adapter.setDatas(list);
        listView.setAdapter(adapter);

        tv_start = findViewByIds(R.id.tv_start);
        dlgWaiting = DialogUtils.createDialog(context,DialogUtils.ANIM);
        tv_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart) {
                    isStart = false;
                    if (list.size() > 0) {
                        list.clear();
                        adapter.notifyDataSetChanged();
                        listView.setVisibility(View.GONE);
                        ll_bs_device.setVisibility(View.VISIBLE);
                    }
                    tv_start.setText("结束");
//                    ToastUtils.showTextToast(context,"测试开始");
//                    updateHandler.sendEmptyMessageDelayed(MSG_ANIM_FINISH,5000);
                    //                    dlgWaiting.show();
                }else {
                    isStart = true;
                    tv_start.setText("开始");
//                    updateHandler.sendEmptyMessage(MSG_ANIM_FINISH);
                }
            }
        });

//        delete_all_tv = (TextView) findViewById(R.id.delete_all_tv);
//        delete_all_tv.setVisibility(View.VISIBLE);
//        delete_all_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //设置dialog的样式属性
//                Window dialogView = deleteAlertDialog2.getWindow();
//                int width = getResources().getDisplayMetrics().widthPixels;
//                WindowManager.LayoutParams lp = dialogView.getAttributes();
//                dialogView.setBackgroundDrawable(new BitmapDrawable());
//                lp.width = width - 160;
//                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//                //        lp.height = height / 3;
//                lp.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER;
//                //lp.x = 100;
////        lp.y = -300;
//                dialogView.setAttributes(lp);
//
//
//                //点击显示AlertDialog
//                deleteAlertDialog2.show();
//
//                iv_cancel = (ImageView) dialogView.findViewById(R.id.delete);
//                tv_cancel = (TextView) dialogView.findViewById(R.id.tv_cancel);
//                tv_sure = (TextView) dialogView.findViewById(R.id.tv_sure);
//                iv_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        deleteAlertDialog2.cancel();
//                    }
//                });
//                tv_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        deleteAlertDialog2.cancel();
//                    }
//                });
//                tv_sure.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        deleteAlertDialog2.cancel();
//
//                        list.clear();
//                        adapter.notifyDataSetChanged();
//                        listView.setVisibility(View.GONE);
//                        ll_bs_device.setVisibility(View.VISIBLE);
//                        delete_all_tv.setVisibility(View.GONE);
//                    }
//                });
//
//            }
//        });


        rl_config = findViewByIds(R.id.rl_config);
        rl_mapshow = findViewByIds(R.id.rl_mapshow);
        rl_config.setFocusable(true);
        rl_mapshow.setFocusable(true);
        rl_config.setOnClickListener(this);
        rl_mapshow.setOnClickListener(this);
//        initDatas();
    }

//    private void initDatas() {
//
//        if (list.size() == 0) {
//            listView.setVisibility(View.GONE);
//            ll_bs_device.setVisibility(View.VISIBLE);
//            delete_all_tv.setVisibility(View.GONE);
//        }else {
//            listView.setVisibility(View.VISIBLE);
//            ll_bs_device.setVisibility(View.GONE);
//            delete_all_tv.setVisibility(View.VISIBLE);
//
//           // adapter.setOnDeleteClickListener(this);
//        }
//    }

    private void initDialog1() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_layout_delete_one, null);
        deleteAlertDialog = new AlertDialog.Builder(this).setView(layout).create();
    }

//    private void initDialog2() {
//        LayoutInflater inflater = getLayoutInflater();
//        View layout = inflater.inflate(R.layout.dialog_layout_delete_all, null);
//        deleteAlertDialog2 = new AlertDialog.Builder(this).setView(layout).create();
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_config:
                Intent rl1_intent = new Intent(ReadCardMessageActivity.this, ParameterConfigurationActivity.class);
                rl1_intent.putExtra("session", PreferenceData.loadSession(ReadCardMessageActivity.this));
                rl1_intent.putExtra("DeviceId", deviceMessage.getDeviceIdDecimal());
                rl1_intent.putExtra("companyId", deviceMessage.getCompanyId());
                startActivity(rl1_intent);
                break;
            case R.id.rl_mapshow:
                Intent rl2_intent = new Intent(ReadCardMessageActivity.this, BaseStationMapActivity.class);
                rl2_intent.putExtra("lat", deviceMessage.getLatitude());
                rl2_intent.putExtra("lng", deviceMessage.getLongitude());
                rl2_intent.putExtra("addr", deviceMessage.getDeviceAddress());
                startActivity(rl2_intent);
                break;
        }
    }

    @Override
    public void onClickListen(View view, final int position) {
        //设置dialog的样式属性
        Window dialogView = deleteAlertDialog.getWindow();
        int width = getResources().getDisplayMetrics().widthPixels;
        WindowManager.LayoutParams lp = dialogView.getAttributes();
        dialogView.setBackgroundDrawable(new BitmapDrawable());
        lp.width = width - 160;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        //        lp.height = height / 3;
        lp.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER;
        //lp.x = 100;
//        lp.y = -300;
        dialogView.setAttributes(lp);


        //点击显示AlertDialog
        deleteAlertDialog.show();

        iv_cancel = (ImageView) dialogView.findViewById(R.id.delete);
        tv_cancel = (TextView) dialogView.findViewById(R.id.tv_cancel);
        tv_sure = (TextView) dialogView.findViewById(R.id.tv_sure);
        iv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAlertDialog.cancel();
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAlertDialog.cancel();
            }
        });
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAlertDialog.cancel();
                list.remove(position);
                adapter.notifyDataSetChanged();
                if (list.size() == 0) {
//                    delete_all_tv.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                    ll_bs_device.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    protected void doSocket() {
        super.doSocket();
        final TurnOnOffDeviceReadRecordRequest.TurnOnOffDeviceReadRecordRequestMessage.Builder openbuilder = TurnOnOffDeviceReadRecordRequest.TurnOnOffDeviceReadRecordRequestMessage.newBuilder();
        openbuilder.setSession(PreferenceData.loadSession(context));
        openbuilder.setDeviceIdDecimal(Long.parseLong(deviceMessage.getDeviceIdDecimal()));
        openbuilder.setOnOff(onOff);

        new Thread() {
            public void run() {
                SocketClient client;
                client = SocketClient.getInstance();
                client.send(SocketAppPacket.COMMAND_ID_TURN_ONOFF_READRECORD, openbuilder.build().toByteArray());
            }
        }.start();
    }

    @Override
    public void onEventMainThread(SocketAppPacket eventPackage) {
        try {
            super.onEventMainThread(eventPackage);
            //删除数据
            if (eventPackage.getCommandId() == SocketAppPacket.COMMAND_ID_TURN_ONOFF_READRECORD) {
                CommonResponse.CommonResponseMessage commonResponseMessage = CommonResponse.CommonResponseMessage.parseFrom(eventPackage.getCommandData());
                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);

                if (commonResponseMessage.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(ReadCardMessageActivity.this, commonResponseMessage.getErrorMsg().getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (commonResponseMessage.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(ReadCardMessageActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {
                    if (onOff) {
                        //  ToastUtils.showTextToast(context, getResources().getString(R.string.open_monitor));
                        //开启监控后每隔60秒发送一次基站读卡推送
                        monitoringSocket();

                    } else {
                        //  ToastUtils.showTextToast(context, getResources().getString(R.string.close_monitor));
                    }

                }

            }
            if (eventPackage.getCommandId() == SocketAppPacket.COMMAND_ID_KEEP_DEVICE_READRECORD) {
                CommonResponse.CommonResponseMessage commonResponseMessage = CommonResponse.CommonResponseMessage.parseFrom(eventPackage.getCommandData());
                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);

                if (commonResponseMessage.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(ReadCardMessageActivity.this, commonResponseMessage.getErrorMsg().getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (commonResponseMessage.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(ReadCardMessageActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {
                    //请求成功
                    isMonitor = true;
                    if (isMonitor) {
                        updateHandler.sendEmptyMessageDelayed(UPDATE_TAG, GAP_TIME);
                    }
                }
            }

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }


    private void monitoringSocket() {
        dlgWaiting.show();
        mDlgWaitingHandler.sendEmptyMessageDelayed(MSG_cannt_get_data, App.WAITTING_SECOND);
        final KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.Builder monitorintBuilder = KeepDeviceReadRecordRequest.KeepDeviceReadRecordRequestMessage.newBuilder();
        monitorintBuilder.setSession(PreferenceData.loadSession(context));
        monitorintBuilder.setDeviceIdDecimal(Long.parseLong(deviceMessage.getDeviceIdDecimal()));
        new Thread() {
            public void run() {
                SocketClient client;
                client = SocketClient.getInstance();
                client.send(SocketAppPacket.COMMAND_ID_KEEP_DEVICE_READRECORD, monitorintBuilder.build().toByteArray());
            }
        }.start();

    }

    public void onEventMainThread(final EventBusMsgPush eventPackage) {
        if (isActivityTop()) {

            if (eventPackage.getMsgType() == 3) {
                if (!isStart) {
                    list.add(0, eventPackage);
                    //list.add(eventPackage);
                    adapter.notifyDataSetChanged();
//                delete_all_tv.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.VISIBLE);
                    ll_bs_device.setVisibility(View.GONE);
                }

            }
        }
    }

    protected boolean isActivityTop() {
        ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        String name = manager.getRunningTasks(1).get(0).topActivity.getClassName();
        return name.equals(this.getClass().getName());
    }

    @Override
    public void onClickLeftIcon() {
        onOff = false;
        doSocket();

        finish();
    }

    @Override
    public void onClickRightIcon() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        isMonitor = false;
        onOff = false;
        doSocket();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.clear();

    }
}
