package com.foxconn.rfid.theowner.model;

import com.yzh.rfid.app.response.Device;

import java.io.Serializable;
import java.util.List;

/**
 * Created by appadmin on 2017/4/27.
 */

public class AbNormalDevice implements Serializable {
    private List<Device.DeviceMessage> listAbnormalDevice;

    public List<Device.DeviceMessage> getListAbnormalDevice() {
        return listAbnormalDevice;
    }

    public void setListAbnormalDevice(List<Device.DeviceMessage> listAbnormalDevice) {
        this.listAbnormalDevice = listAbnormalDevice;
    }


}
