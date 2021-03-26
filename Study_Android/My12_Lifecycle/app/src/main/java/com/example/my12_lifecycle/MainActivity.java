package com.example.my12_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    private static final String TAG = "main:MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: 호출됨");

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }//onClick() override
        });//button1.setOnClickListener

    }//onCreate() override

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onCreate: 호출됨");
    }//onStart() override

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 호출됨");
        savePersonal();
    }//onStop() override

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 호출됨");
    }//onDestroy() override

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 호출됨");
    }//onPause() override

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: 호출됨");
        loadPersonal();
    }//onResume() override

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: 호출됨");
    }//onRestart() override

    private void savePersonal() {
        SharedPreferences pref = getSharedPreferences("personal", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", "eyedial");
        editor.putInt("pw", 1234);
        editor.commit();
    }//savePersonal()

    private void loadPersonal() {
        SharedPreferences pref = getSharedPreferences("personal", Activity.MODE_PRIVATE);
        if (pref != null) {
            String id = pref.getString("id", "css");
            int pw = pref.getInt("pw", 1111);
            Log.d(TAG, "가져온 값 : " + id + " / " + pw);
        }
    }//loadPersonal()
}//class