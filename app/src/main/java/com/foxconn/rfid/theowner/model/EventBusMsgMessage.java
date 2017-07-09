package com.foxconn.rfid.theowner.model;


public class EventBusMsgMessage {


    public static final int MSG_Message_Alarm_Delete = 1999;
    private int MsgType;

    public int getMsgType() {
        return MsgType;
    }

    public void setMsgType(int msgType) {
        MsgType = msgType;
    }
}
