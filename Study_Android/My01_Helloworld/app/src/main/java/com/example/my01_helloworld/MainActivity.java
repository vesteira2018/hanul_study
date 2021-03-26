package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCall, btnNew;
    EditText etPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhoneNum = findViewById(R.id.etPhoneNum);
        btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = "tel:" + etPhoneNum.getText().toString();

                //입력한 전화번호를 받아 다이얼패드로 불러오는 기능
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse(phoneNum));
                startActivity(intent);
            }//onClick() override
        });//btnCall.setOnClickListener

        btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //서브 페이지를 열기
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }//onClick() override
        });//btnNew.setOnClickListener

    }//onCreate()

    public void btn1Clicked(View view) {
        Toast.makeText(this, "버튼1이 클릭되었습니다!!", Toast.LENGTH_SHORT).show();
    }//btn1Clicked()

    public void btn2Clicked(View view) {
        //버튼 클릭 시 네이버로 이동
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com/"));
        startActivity(intent);
    }//btn2Clicked()



}//class