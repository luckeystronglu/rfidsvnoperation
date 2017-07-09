package com.foxconn.rfid.theowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.foxconn.rfid.theowner.base.App;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.base.BaseApplication;
import com.foxconn.rfid.theowner.base.PreferenceData;
import com.foxconn.rfid.theowner.model.CompanyUser;
import com.foxconn.rfid.theowner.model.DeviceNameAndId;
import com.foxconn.rfid.theowner.socket.SocketAppPacket;
import com.foxconn.rfid.theowner.socket.SocketClient;
import com.foxconn.rfid.theowner.view.widgets.Header;
import com.google.protobuf.InvalidProtocolBufferException;
import com.yzh.rfid.app.request.GetCompanyListRequest;
import com.yzh.rfid.app.request.GetDeviceCountRequest;
import com.yzh.rfid.app.request.GetDevicesByCompanyIdRequest;
import com.yzh.rfid.app.response.Company;
import com.yzh.rfid.app.response.Device;
import com.yzh.rfid.app.response.GetCompanyListResponse;
import com.yzh.rfid.app.response.GetDeviceCountResponse;
import com.yzh.rfid.app.response.GetDevicesResponse;
import com.yzh.rfidbike_sustain.R;

import net.tsz.afinal.FinalDb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appadmin on 2017/4/25.
 */

public class AbnormalBSActivity extends BaseActivity implements View.OnClickListener {
    private Header abnormal_header;
//    private ListView lv_abnormal_bs;
//    private AbnormalAdapter adapter;
    private List<Company.CompanyMessage> mCompanyMsgList;
    private LinearLayout ll_offline_num,ll_lowbattery_num,ll_hightemp_num;
    private TextView tv_offline_num,tv_lowbattery_num,tv_hightemp_num;
    FinalDb mDb = FinalDb.create(context, App.DB_NAME, true,App.DB_VERSION,this );

    ArrayList<Device.DeviceMessage> offLineList = new ArrayList<>();
    ArrayList<Device.DeviceMessage> lowBatteryList = new ArrayList<>();
    ArrayList<Device.DeviceMessage> hightempList = new ArrayList<>();

    private long offline_num;
    private long lowbattery_num;
    private long hightemp_num;
    private List<Device.DeviceMessage> deviceList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abnormal_activity);
        initView();
        initEvent();
    }


    private void initView() {
        offline_num = 0;
        lowbattery_num = 0;
        hightemp_num = 0;

        abnormal_header = findViewByIds(R.id.abnormal_bs_header);
        ll_offline_num = findViewByIds(R.id.ll_offline_num);
        ll_lowbattery_num = findViewByIds(R.id.ll_lowbattery_num);
        ll_hightemp_num = findViewByIds(R.id.ll_hightemp_num);
        ll_offline_num.setOnClickListener(this);
        ll_lowbattery_num.setOnClickListener(this);
        ll_hightemp_num.setOnClickListener(this);

        tv_offline_num = findViewByIds(R.id.tv_offline_num);
        tv_lowbattery_num = findViewByIds(R.id.tv_lowbattery_num);
        tv_hightemp_num = findViewByIds(R.id.tv_hightemp_num);
//        lv_abnormal_bs = findViewByIds(lv_abnormal_bs);
//        adapter = new AbnormalAdapter(this);
//        lv_abnormal_bs.setAdapter(adapter);
        BaseApplication.getInstance().companyListStr = "AbnormalBSActivity";
        getCompanyListSocket();

    }


    private void initEvent() {
        abnormal_header.setListener(new Header.headerListener() {
            @Override
            public void onClickLeftIcon() {
                finish();
            }

            @Override
            public void onClickRightIcon() {

            }
        });


//        lv_abnormal_bs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }

    private void getCompanyListSocket() {
        super.doSocket();
        final GetCompanyListRequest.GetCompanyListRequestMessage.Builder requestMessage =
                GetCompanyListRequest.GetCompanyListRequestMessage.newBuilder();
        CompanyUser companyUser = CompanyUser.getCurUser(this);
//        requestMessage.setSession(companyUser.getSession());
        requestMessage.setSession(PreferenceData.loadSession(this));
        requestMessage.setCompanyId(0);
        requestMessage.setUserId(companyUser.getUserId());
        new Thread() {
            public void run() {
                SocketClient client;
                client = SocketClient.getInstance();
                client.send(SocketAppPacket.GET_COMPANY_LIST, requestMessage.build().toByteArray());
            }

        }.start();
    }


    @Override
    public void onEventMainThread(SocketAppPacket eventPackage) {
        try {
            super.onEventMainThread(eventPackage);
            if (eventPackage.getCommandId() == SocketAppPacket.GET_COMPANY_LIST && BaseApplication.getInstance().companyListStr.equals("AbnormalBSActivity")) {
                GetCompanyListResponse.GetCompanyListResponseMessage responseMessage =
                        GetCompanyListResponse.GetCompanyListResponseMessage.parseFrom(eventPackage.getCommandData());
                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);
                if (responseMessage.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(this, responseMessage.getErrorMsg()
                            .getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (responseMessage.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(AbnormalBSActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {
                    //请求成功

                    mCompanyMsgList = responseMessage.getCompanyMessageList();
                    for (int i = 0; i < mCompanyMsgList.size(); i++) {
                        if (mCompanyMsgList.size() == 0) {
                            return;
                        }
                        if (mCompanyMsgList.get(i).getHasChild().equals("1")) {

                            //有下级子公司
                            super.doSocket();
                            final GetCompanyListRequest.GetCompanyListRequestMessage.Builder requestMessage =
                                    GetCompanyListRequest.GetCompanyListRequestMessage.newBuilder();
                            CompanyUser companyUser = CompanyUser.getCurUser(this);
                            requestMessage.setSession(PreferenceData.loadSession(this));
//                            requestMessage.setSession(companyUser.getSession());
                            requestMessage.setCompanyId(mCompanyMsgList.get(i).getId());
                            requestMessage.setUserId(companyUser.getUserId());
                            new Thread() {
                                public void run() {
                                    SocketClient client;
                                    client = SocketClient.getInstance();
                                    client.send(SocketAppPacket.GET_COMPANY_LIST, requestMessage.build().toByteArray());
                                }

                            }.start();
                        }else if (mCompanyMsgList.get(i).getHasChild().equals("0")){
                            //没有下级子公司,即公司最后一层
                            List<DeviceNameAndId> abList = mDb.findAllByWhere(DeviceNameAndId.class,
                                    "deviceID=" + String.valueOf(mCompanyMsgList.get(i).getId()));
                            if (abList.size() == 0) {
                                DeviceNameAndId de = new DeviceNameAndId();
                                de.setDeviceID(mCompanyMsgList.get(i).getId());
                                de.setDeviceName(mCompanyMsgList.get(i).getName());
                                mDb.save(de);
                            }


//                            String name = mCompanyMsgList.get(i).getName();
//                            long id = mCompanyMsgList.get(i).getId();
                            super.doSocket();
                            final GetDeviceCountRequest.GetDeviceCountRequestMessage.Builder deviceCountBuilder
                                    = GetDeviceCountRequest.GetDeviceCountRequestMessage.newBuilder();
                            deviceCountBuilder.setCompanyId(mCompanyMsgList.get(i).getId());
                            new Thread() {
                                public void run() {
                                    SocketClient client;
                                    client = SocketClient.getInstance();
                                    client.send(SocketAppPacket.GET_DEVICE_ABNORMAL_COUNT, deviceCountBuilder.build().toByteArray());
                                }
                            }.start();


                            final GetDevicesByCompanyIdRequest.GetDevicesByCompanyIdRequestMessage.Builder deviceListBuilder
                                    = GetDevicesByCompanyIdRequest.GetDevicesByCompanyIdRequestMessage.newBuilder();
                            deviceListBuilder.setCompanyId(mCompanyMsgList.get(i).getId());
//                            CompanyUser companyUser = CompanyUser.getCurUser(this);
//                            deviceListBuilder.setSession(companyUser.getSession());
                            new Thread() {
                                public void run() {
                                    SocketClient client;
                                    client = SocketClient.getInstance();
                                    client.send(SocketAppPacket.GET_DEVICE_LIST_BY_COMPANYID, deviceListBuilder.build().toByteArray());
                                }
                            }.start();

                        }
                    }
//                    if (mCompanyMsgList != null) {
//                        mCompanyMsgList.clear();
////                        mCompanyMsgList = new ArrayList<>();
//                    }

                }
            }
            else if (eventPackage.getCommandId() == SocketAppPacket.GET_DEVICE_ABNORMAL_COUNT) {
                final GetDeviceCountResponse.GetDeviceCountResponseMessage getDeviceCountResponse
                        = GetDeviceCountResponse.GetDeviceCountResponseMessage.parseFrom(eventPackage.getCommandData());

                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);
                if (getDeviceCountResponse.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(this, getDeviceCountResponse.getErrorMsg()
                            .getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (getDeviceCountResponse.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(AbnormalBSActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {
                    hightemp_num += getDeviceCountResponse.getHighTempCount();
                    lowbattery_num += getDeviceCountResponse.getLowBatteryCount();
                    offline_num += getDeviceCountResponse.getOffLineCount();
                    long offLineCount = getDeviceCountResponse.getOffLineCount();
                    tv_offline_num.setText(offline_num + "");
                    tv_lowbattery_num.setText(lowbattery_num + "");
                    tv_hightemp_num.setText(hightemp_num + "");

                }
            }

            else if (eventPackage.getCommandId() == SocketAppPacket.GET_DEVICE_LIST_BY_COMPANYID) {
                final GetDevicesResponse.GetDevicesResponseMessage getDevicesResponse
                        = GetDevicesResponse.GetDevicesResponseMessage.parseFrom(eventPackage.getCommandData());

                if (dlgWaiting.isShowing()) {
                    dlgWaiting.dismiss();
                }
                mDlgWaitingHandler.removeMessages(MSG_cannt_get_data);
                if (getDevicesResponse.getErrorMsg().getErrorCode() != 0) {
                    Toast.makeText(this, getDevicesResponse.getErrorMsg()
                            .getErrorMsg(), Toast.LENGTH_LONG).show();
                    if (getDevicesResponse.getErrorMsg().getErrorCode() == 20003) {
                        Intent intent = new Intent();
                        intent.setClass(AbnormalBSActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                                .FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else {

                    deviceList = getDevicesResponse.getDeviceList();
                    if (deviceList.size() == 0) {
                        return;
                    }
                    for (int i = 0; i < deviceList.size(); i++) {
                        if (!deviceList.get(i).getIsOnline()) {
                            offLineList.add(deviceList.get(i));
                        }

                        if (deviceList.get(i).getIsLowBattery()) {
                            lowBatteryList.add(deviceList.get(i));
                        }

                        if (deviceList.get(i).getIsHighTemperature()) {
                            hightempList.add(deviceList.get(i));
                        }
                    }
//                    if (deviceList.size() > 0) {
//                        deviceList.clear();
//                        deviceList = new ArrayList<>();
//                    }

                }
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AbnormalBSActivity.this,AbnormalDetailActivity.class);
        switch (v.getId()) {
            case R.id.ll_offline_num:
                if (offLineList.size() == 0) {
                    return;
                }
//                Bundle bundle = new Bundle();
//                AbNormalDevice abNormalDevice=new AbNormalDevice();
//                abNormalDevice.setListAbnormalDevice(offLineList);
//                bundle.putSerializable("deviceLists",abNormalDevice);
//
//                bundle.putInt("num",1);
//                intent.putExtras(bundle);
                intent.putExtra("deviceLists",offLineList);
                intent.putExtra("num",1);
                break;

            case R.id.ll_lowbattery_num:
                if (lowBatteryList.size() == 0) {
                    return;
                }
//                Bundle bundle2 = new Bundle();
//                AbNormalDevice abNormalDevice2 = new AbNormalDevice();
//                abNormalDevice2.setListAbnormalDevice(lowBatteryList);
//                bundle2.putSerializable("deviceLists",abNormalDevice2);
//
//                bundle2.putInt("num",2);
//                intent.putExtras(bundle2);
//
                intent.putExtra("deviceLists",lowBatteryList);
                intent.putExtra("num",2);
                break;

            case R.id.ll_hightemp_num:
                if (hightempList.size() == 0) {
                    return;
                }
//                Bundle bundle3 = new Bundle();
//                AbNormalDevice abNormalDevice3 = new AbNormalDevice();
//                abNormalDevice3.setListAbnormalDevice(hightempList);
//                bundle3.putSerializable("deviceLists",abNormalDevice3);
//
//                bundle3.putInt("num",3);
//                intent.putExtras(bundle3);

                intent.putExtra("deviceLists",hightempList);
                intent.putExtra("num",3);
                break;
        }

        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (offLineList.size() > 0) {
            offLineList.clear();
        }
        if (lowBatteryList.size() > 0) {
            lowBatteryList.clear();
        }
        if (hightempList.size() > 0) {
            hightempList.clear();
        }

    }
}
