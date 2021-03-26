package com.example.my13_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "main:MyService";
    
    public MyService() {
    }//MyService()

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: 호출됨");
    }//onCreate() override

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: 호출됨 " + flags + ", " + startId);

        if (intent == null) {
            return Service.START_STICKY;
        } else {
            processCommand(intent);
        }//if

        return super.onStartCommand(intent, flags, startId);
    }//onStartCommand() override

    private void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");
        Log.d(TAG, "command : " + command + ", " + name);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getMessage();
            }//try-catch
            Log.d(TAG, "Waiting " + ( i + 1 ) + " seconds...");
        }//for
    }//processCommand()

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }//onBind() override

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 호출됨");
    }//onDestroy() override
}//class