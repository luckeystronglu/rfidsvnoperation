package com.foxconn.rfid.theowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.foxconn.rfid.theowner.adapter.AbnormalAdapter;
import com.foxconn.rfid.theowner.base.BaseActivity;
import com.foxconn.rfid.theowner.view.widgets.Header;
import com.yzh.rfid.app.response.Device;
import com.yzh.rfidbike_sustain.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appadmin on 2017/4/27.
 */

public class AbnormalDetailActivity extends BaseActivity {
    private Header abnormal_detail_header;
    private ListView lv_abnormal_detail;
    private AbnormalAdapter adapter;
    private View listHeadView;
    List<Device.DeviceMessage> devList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abnormal_detail_activity);
        initView();
        initEvent();
    }


    private void initView() {
//        Bundle bundl = getIntent().getExtras();
//        devList = ((AbNormalDevice) bundl.getSerializable("deviceLists")).getListAbnormalDevice();
//        int num = bundl.getInt("num");

        Intent inten = getIntent();
        devList = (List<Device.DeviceMessage>) inten.getSerializableExtra("deviceLists");
        int num = inten.getIntExtra("num", -1);

        abnormal_detail_header = findViewByIds(R.id.abnormal_detail_header);
        switch (num) {
            case 1:
                abnormal_detail_header.setTitle("离线基站明细");
                break;

            case 2:
                abnormal_detail_header.setTitle("低电基站明细");
                break;

            case 3:
                abnormal_detail_header.setTitle("高温基站明细");
                break;

            default:
                break;
        }

        lv_abnormal_detail = findViewByIds(R.id.lv_abnormal_detail);
        listHeadView =  getLayoutInflater().inflate(R.layout.item_abnormal_header, null);
        lv_abnormal_detail.addHeaderView(listHeadView);

        adapter = new AbnormalAdapter(this);
        lv_abnormal_detail.setAdapter(adapter);

        adapter.setDatas(devList);
        if (devList.size() > 0) {
            listHeadView.setVisibility(View.VISIBLE);
        }else {
            listHeadView.setVisibility(View.GONE);
        }



    }



    private void initEvent() {
        abnormal_detail_header.setListener(new Header.headerListener() {
            @Override
            public void onClickLeftIcon() {
                finish();
            }

            @Override
            public void onClickRightIcon() {

            }
        });

        lv_abnormal_detail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Device.DeviceMessage message = devList.get(position - 1);
                    Intent intent = new Intent(AbnormalDetailActivity.this,ReadCardMessageActivity.class);
                    intent.putExtra("DeviceMessage", message);
                    startActivity(intent);
                }


                //                intent.setClass(AbnormalDetailActivity.this, ReadCardMessageActivity.class);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (devList != null) {
            devList.clear();
        }
    }
}
