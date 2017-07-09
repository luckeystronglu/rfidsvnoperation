package com.foxconn.rfid.theowner.adapter;

import android.content.Context;

import com.foxconn.rfid.theowner.base.AbsBaseAdapter;
import com.foxconn.rfid.theowner.base.App;
import com.foxconn.rfid.theowner.model.DeviceNameAndId;
import com.yzh.rfid.app.response.Device;
import com.yzh.rfidbike_sustain.R;

import net.tsz.afinal.FinalDb;

import java.util.List;

/**
 * Created by appadmin on 2017/4/25.
 */

public class AbnormalAdapter extends AbsBaseAdapter<Device.DeviceMessage> {

    FinalDb mDb= FinalDb.create(context, App.DB_NAME, true,App.DB_VERSION, (FinalDb.DbUpdateListener) context);

    public AbnormalAdapter(Context context) {
        super(context, R.layout.item_abnormal_bs2);
    }


    @Override
    public void bindDatas(ViewHodler viewHodler, Device.DeviceMessage data) {
       List<DeviceNameAndId> allList = mDb.findAll(DeviceNameAndId.class);

        viewHodler
                .setTextView(R.id.tv_abnormal_id2,data.getDeviceIdDecimal())
                .setTextView(R.id.tv_abnormal_name2,data.getDeviceName());

        for (int i = 0; i < allList.size(); i++) {
            if (data.getCompanyId() == allList.get(i).getDeviceID()) {
                viewHodler
//                        .setTextView(R.id.tv_abnormal_address,allList.get(i).getDeviceName());
                        .setTextView(R.id.tv_company_name,allList.get(i).getDeviceName());
            }
        }

    }


}
