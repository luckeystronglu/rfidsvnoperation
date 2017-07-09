package com.foxconn.rfid.theowner.push;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.baidu.android.pushservice.PushMessageReceiver;
import com.foxconn.rfid.theowner.activity.MessageCenterSecondActivity;
import com.foxconn.rfid.theowner.base.BaseApplication;
import com.foxconn.rfid.theowner.model.EventBusMsgPush;
import com.foxconn.rfid.theowner.util.BaiduPushUtils;
import com.yzh.rfidbike_sustain.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import de.greenrobot.event.EventBus;


/*
 * Push消息处理receiver。请编写您需要的回调函数， 一般来说： onBind是必须的，用来处理startWork返回值；
 *onMessage用来接收透传消息； onSetTags、onDelTags、onListTags是tag相关操作的回调；
 *onNotificationClicked在通知被点击时回调； onUnbind是stopWork接口的返回值回调
 * 返回值中的errorCode，解释如下：
 *0 - Success
 *10001 - Network Problem
 *10101  Integrate Check Error
 *30600 - Internal Server Error
 *30601 - Method Not Allowed
 *30602 - Request Params Not Valid
 *30603 - Authentication Failed
 *30604 - Quota Use Up Payment Required
 *30605 -Data Required Not Found
 *30606 - Request Time Expires Timeout
 *30607 - Channel Token Timeout
 *30608 - Bind Relation Not Found
 *30609 - Bind Number Too Many
 * 当您遇到以上返回错误时，如果解释不了您的问题，请用同一请求的返回值requestId和errorCode联系我们追查问题。
 *
 */

public class MyPushMessageReceiver extends PushMessageReceiver {
    /** TAG to Log */
    public static final String TAG = MyPushMessageReceiver.class
            .getSimpleName();
    private final static String   MSG_Message_Type="messageType";
    private final static String   MSG_Sub_Message_Type="messageSubType";
    private final static String   MSG_Message_Id="referenceId";
    private final static String   MSG_Message_Timestamp="timestamp";
    private final static String   MSG_Message_Subject="subject";
    private final static String   MSG_Message_Content="content";
    /**
     * 调用PushManager.startWork后，sdk将对push
     * server发起绑定请求，这个过程是异步的。绑定请求的结果通过onBind返回。 如果您需要用单播推送，需要把这里获取的channel
     * id和user id上传到应用server中，再调用server接口用channel id和user id给单个手机或者用户推送。
     *
     * @param context
     *            BroadcastReceiver的执行Context
     * @param errorCode
     *            绑定接口返回值，0 - 成功
     * @param appid
     *            应用id。errorCode非0时为null
     * @param userId
     *            应用user id。errorCode非0时为null
     * @param channelId
     *            应用channel id。errorCode非0时为null
     * @param requestId
     *            向服务端发起的请求id。在追查问题时有用；
     * @return none
     */
    @Override
    public void onBind(Context context, int errorCode, String appid,
                       String userId, String channelId, String requestId) {
//        String responseString =  channelId;
//        Log.d(TAG, responseString);

        if (errorCode == 0) {
            // 绑定成功
            Log.d(TAG, "绑定成功");
            BaiduPushUtils.actionType=0;
            BaiduPushUtils.setBaiduPushChannelId(context, channelId);
//            Log.e("channelid",channelId);
//            ToastUtils.showTextToast(context,channelId);
//            updateContent(context);
        }
        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑

    }

    /**
     * 接收透传消息的函数。
     *
     * @param context
     *            上下文
     * @param message
     *            推送的消息
     * @param customContentString
     *            自定义内容,为空或者json字符串
     */
    @Override
    public void onMessage(Context context, String message,
                          String customContentString) {
// 自定义内容获取方式，mykey和myvalue对应通知推送时自定义内容中设置的键和值

        int messageType=0;
        int subMessageType=0;
        String referenceId="";
        long timestamp=0L;
        String subject="";
        String content="";
        if (!TextUtils.isEmpty(message)) {

            try {
                JSONObject customJson = null;
                JSONObject   returnMessage= new JSONObject(message);
                customJson=returnMessage.optJSONObject("custom_content");
                if (!customJson.isNull(MSG_Message_Type)) {
                    messageType = customJson.getInt(MSG_Message_Type);
                }
                if (!customJson.isNull(MSG_Sub_Message_Type)) {
                    subMessageType = customJson.getInt(MSG_Sub_Message_Type);
                }
                if (!customJson.isNull(MSG_Message_Id)) {
                    referenceId = customJson.getString(MSG_Message_Id);
                }
                if (!customJson.isNull(MSG_Message_Timestamp)) {
                    timestamp = customJson.getLong(MSG_Message_Timestamp);
                }
                if (!customJson.isNull(MSG_Message_Subject)) {
                    subject = customJson.getString(MSG_Message_Subject);
                }
                if (!customJson.isNull(MSG_Message_Content)) {
                    content = customJson.getString(MSG_Message_Content);
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> list = am.getRunningTasks(100);
        boolean isAppRunning = false;
        String MY_PKG_NAME = "com.yzh.rfidbike_sustain";
        for (RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(MY_PKG_NAME) || info.baseActivity.getPackageName().equals(MY_PKG_NAME)) {
                isAppRunning = true;
                break;
            }
        }
        if(isAppRunning )
        {
            EventBusMsgPush pushMessage=new EventBusMsgPush();
            pushMessage.setMsgType(messageType);
            pushMessage.setSubMsgType(subMessageType);
            pushMessage.setReferenceId(referenceId);
            pushMessage.setNotifyType(EventBusMsgPush.NotifyType.MSG_Arrived);
            pushMessage.setCreateDate(timestamp);
            pushMessage.setSubject(subject);
            pushMessage.setSubjectContent(content);
            EventBus.getDefault().post(pushMessage);
        }
    }

    /**
     * 接收通知点击的函数。
     *
     * @param context
     *            上下文
     * @param title
     *            推送的通知的标题
     * @param description
     *            推送的通知的描述
     * @param customContentString
     *            自定义内容，为空或者json字符串
     *            点击的时候，正在运行或是运行在后台
     *            点击的时候，没有运行
     */
    @Override
    public void onNotificationClicked(Context context, String title,
                                      String description, String customContentString) {
//        String notifyString = "通知点击 title=\"" + title + "\" description=\""
//                + description + "\" customContent=" + customContentString;
//        Log.d(TAG, notifyString);

        // 自定义内容获取方式，mykey和myvalue对应通知推送时自定义内容中设置的键和值
        int messageType=0;
        int subMessageType=0;
        String referenceId="";
        long timestamp=0L;
        String subject="";
        String content="";
        if (!TextUtils.isEmpty(customContentString)) {
            JSONObject customJson = null;
            try {
                customJson = new JSONObject(customContentString);
                if (!customJson.isNull(MSG_Message_Type)) {
                    messageType = customJson.getInt(MSG_Message_Type);
                }
                if (!customJson.isNull(MSG_Sub_Message_Type)) {
                    subMessageType = customJson.getInt(MSG_Sub_Message_Type);
                }
                if (!customJson.isNull(MSG_Message_Id)) {
                    referenceId = customJson.getString(MSG_Message_Id);
                }
                if (!customJson.isNull(MSG_Message_Timestamp)) {
                    timestamp = customJson.getLong(MSG_Message_Timestamp);
                }
                if (!customJson.isNull(MSG_Message_Subject)) {
                    subject = customJson.getString(MSG_Message_Subject);
                }
                if (!customJson.isNull(MSG_Message_Content)) {
                    content = customJson.getString(MSG_Message_Content);
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑

        //判断应用是否在运行
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> list = am.getRunningTasks(100);
        boolean isAppRunning = false;
        String MY_PKG_NAME = "com.yzh.rfidbike_sustain";
        for (RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(MY_PKG_NAME) || info.baseActivity.getPackageName().equals(MY_PKG_NAME)) {
                isAppRunning = true;
                break;
            }
        }

        EventBusMsgPush pushMessage=new EventBusMsgPush();
        pushMessage.setMsgContent(description);
        pushMessage.setMsgTitle(title);

        pushMessage.setMsgType(messageType);
        pushMessage.setSubMsgType(subMessageType);
        pushMessage.setReferenceId(referenceId);
        pushMessage.setCreateDate(timestamp);
        pushMessage.setNotifyType(EventBusMsgPush.NotifyType.MSG_Clicked);
        pushMessage.setSubject(subject);
        pushMessage.setSubjectContent(content);

        Intent intent = new Intent();
        intent.setClass(context.getApplicationContext(), MainActivity.class);
        BaseApplication.getInstance().needGoToMessageCenter=true;
        BaseApplication.getInstance().MessageType=messageType;
        context.getApplicationContext().startActivity(intent);
    }

    /**
     * 接收通知到达的函数。
     *
     * @param context
     *            上下文
     * @param title
     *            推送的通知的标题
     * @param description
     *            推送的通知的描述
     * @param customContentString
     *            自定义内容，为空或者json字符串
     *            //消息类型为1或2进入消息界面，消息类型为3，只有在界面处于基站界面才会收到，
     *            系统正在运行，如果在消息界面，跳转到相应的tabview,并添加一条记录
     *            系统正在运行，如果不在消息界面，弹出对话框，跳转后处理逻辑同上
     *            系统没有运行不处理
     */

    @Override
    public void onNotificationArrived(Context context, String title,
                                      String description, String customContentString) {

        int messageType=0;
        int subMessageType=0;
        String referenceId="";
        long timestamp=0L;
        String subject="";
        String content="";

        if (!TextUtils.isEmpty(customContentString)) {
            JSONObject customJson = null;
            try {
                customJson = new JSONObject(customContentString);
                if (!customJson.isNull(MSG_Message_Type)) {
                    messageType = customJson.getInt(MSG_Message_Type);
                }
                if (!customJson.isNull(MSG_Sub_Message_Type)) {
                    subMessageType = customJson.getInt(MSG_Sub_Message_Type);
                }
                if (!customJson.isNull(MSG_Message_Id)) {
                    referenceId = customJson.getString(MSG_Message_Id);
                }
                if (!customJson.isNull(MSG_Message_Timestamp)) {
                    timestamp = customJson.getLong(MSG_Message_Timestamp);
                }
                if (!customJson.isNull(MSG_Message_Subject)) {
                    subject = customJson.getString(MSG_Message_Subject);
                }
                if (!customJson.isNull(MSG_Message_Content)) {
                    content = customJson.getString(MSG_Message_Content);
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑

        //判断应用是否在运行
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> list = am.getRunningTasks(100);
        boolean isAppRunning = false;
        String MY_PKG_NAME = "com.yzh.rfidbike_sustain";
        for (RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(MY_PKG_NAME) || info.baseActivity.getPackageName().equals(MY_PKG_NAME)) {
                isAppRunning = true;
                break;
            }
        }
        if(isAppRunning)
        {
            EventBusMsgPush pushMessage=new EventBusMsgPush();
            pushMessage.setMsgType(messageType);
            pushMessage.setSubMsgType(subMessageType);
            pushMessage.setReferenceId(referenceId);
            pushMessage.setCreateDate(timestamp);
//            pushMessage.setMsgId(1);
//            pushMessage.setMsgType(1);
//            pushMessage.setReferenceId("1");
            pushMessage.setMsgContent(description);
            pushMessage.setMsgTitle(title);
            pushMessage.setSubject(subject);
            pushMessage.setSubjectContent(content);
            EventBus.getDefault().post(pushMessage);
        }
    }

    /**
     * setTags() 的回调函数。
     *
     * @param context
     *            上下文
     * @param errorCode
     *            错误码。0表示某些tag已经设置成功；非0表示所有tag的设置均失败。
     * @paramsuccessTags
     *            设置成功的tag
     * @param failTags
     *            设置失败的tag
     * @param requestId
     *            分配给对云推送的请求的id
     */
    @Override
    public void onSetTags(Context context, int errorCode,
                          List<String> sucessTags, List<String> failTags, String requestId) {
        String responseString = "onSetTags errorCode=" + errorCode
                + " sucessTags=" + sucessTags + " failTags=" + failTags
                + " requestId=" + requestId;
        Log.d(TAG, responseString);

        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
        updateContent(context);
    }

    /**
     * delTags() 的回调函数。
     *
     * @param context
     *            上下文
     * @param errorCode
     *            错误码。0表示某些tag已经删除成功；非0表示所有tag均删除失败。
     * @paramsuccessTags
     *            成功删除的tag
     * @param failTags
     *            删除失败的tag
     * @param requestId
     *            分配给对云推送的请求的id
     */
    @Override
    public void onDelTags(Context context, int errorCode,
                          List<String> sucessTags, List<String> failTags, String requestId) {
        String responseString = "onDelTags errorCode=" + errorCode
                + " sucessTags=" + sucessTags + " failTags=" + failTags
                + " requestId=" + requestId;
        Log.d(TAG, responseString);

        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
        updateContent(context);
    }

    /**
     * listTags() 的回调函数。
     *
     * @param context
     *            上下文
     * @param errorCode
     *            错误码。0表示列举tag成功；非0表示失败。
     * @param tags
     *            当前应用设置的所有tag。
     * @param requestId
     *            分配给对云推送的请求的id
     */
    @Override
    public void onListTags(Context context, int errorCode, List<String> tags,
                           String requestId) {
        String responseString = "onListTags errorCode=" + errorCode + " tags="
                + tags;
        Log.d(TAG, responseString);

        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
        updateContent(context);
    }

    /**
     * PushManager.stopWork() 的回调函数。
     *
     * @param context
     *            上下文
     * @param errorCode
     *            错误码。0表示从云推送解绑定成功；非0表示失败。
     * @param requestId
     *            分配给对云推送的请求的id
     */
    @Override
    public void onUnbind(Context context, int errorCode, String requestId) {
        String responseString = "onUnbind errorCode=" + errorCode
                + " requestId = " + requestId;
        Log.d(TAG, responseString);

        if (errorCode == 0) {
            // 解绑定成功
            Log.d(TAG, "解绑成功");
            BaiduPushUtils.setBaiduPushChannelId(context, "");
        }
        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑
//        updateContent(context);
    }

    private void updateContent(Context context) {
        Intent intent = new Intent();
        intent.setClass(context.getApplicationContext(), MessageCenterSecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(intent);
    }
    private boolean isRunningForeground (Context context)
    {
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if(!TextUtils.isEmpty(currentPackageName)&& currentPackageName.equals(context.getPackageName()))
        {
            return true ;
        }
        return false ;
    }


}
