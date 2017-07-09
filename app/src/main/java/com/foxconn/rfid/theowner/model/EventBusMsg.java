package com.foxconn.rfid.theowner.model;


import java.util.Map;

public class EventBusMsg {

    private MsgType mMsgType;
    private Map value;

    public MsgType getMsgType() {
        return mMsgType;
    }

    public void setMsgType(MsgType msgType) {
        mMsgType = msgType;
    }

    public Map getValue() {
        return value;
    }

    public void setValue(Map value) {
        this.value = value;
    }

    public enum MsgType {
        MSG_COMPANY_ID,
        MSG_ADDRESS_ID
    }


    private int listSize;
    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }


    private MsgEmptyType emptyType;

    public MsgEmptyType getEmptyType() {
        return emptyType;
    }

    public void setEmptyType(MsgEmptyType emptyType) {
        this.emptyType = emptyType;
    }

    public enum MsgEmptyType {
        ALERTMSG_LISTSIZEEMPTY_ID,
        REFRESH_COMPANYLIST
    }
}
