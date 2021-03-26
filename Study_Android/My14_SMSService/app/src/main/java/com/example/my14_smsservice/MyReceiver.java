package com.example.my14_smsservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "main:MyReceiver";
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 호출됨");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if (messages != null && messages.length > 0) {
            Log.d(TAG, "onReceive: SMS를 수신하였습니다");

            //발신자
            String sender = messages[0].getOriginatingAddress();
            Log.d(TAG, "onReceive: sender => " + sender);

            //메시지 수신 날짜
            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.d(TAG, "onReceive: receivedDate => " + receivedDate);

            //메시지 내용
            String contents = messages[0].getMessageBody();
            Log.d(TAG, "onReceive: contents => " + contents);

            Intent disIntent = new Intent(context, DisplayActivity.class);
            disIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                             | Intent.FLAG_ACTIVITY_CLEAR_TOP
                             | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //SINGLE_TOP : 화면에 비슷한 것이 있다면 그 ACTION을 재사용
            //이것을 주지 않았을 경우, 메시지가 올 때마다 새로운 창이 뜬다 > 메모리 과다 소모

            disIntent.putExtra("sender", sender);
            disIntent.putExtra("receivedDate", dateFormat.format(receivedDate));
            disIntent.putExtra("contents", contents);
            context.startActivity(disIntent);

        }//if
    }//onReceive() override

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        for (int i = 0; i < objs.length; i++) {
            //Android M(API 23) 이상인 경우
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                //message로 변환
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }//if
        }//for

        return messages;
    }//parseSmsMessage()
}//class