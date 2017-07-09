package com.foxconn.rfid.theowner.model;

import net.tsz.afinal.annotation.sqlite.Table;

/**
 * Created by appadmin on 2017/4/27.
 */

@Table(name = "DeviceNameAndId")
public class DeviceNameAndId{


    private int id;
    private Long deviceID;
    private String deviceName;


    public Long getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Long deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
