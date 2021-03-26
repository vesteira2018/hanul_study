package com.example.my10_intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    TextView textView1;
    int Sub_Code = 1004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        textView1 = findViewById(R.id.textView1);

        //SubActivity로 데이터 보내기
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person1 = new Person("eyedial", 4567);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("id", "CSS");
                intent.putExtra("pw",1234);
                intent.putExtra("person1", person1);
                startActivityForResult(intent, Sub_Code);
            }//onClick() override
        });//button1.setOnClickListener
    }//onCreate() override

    //SubActivity로부터 데이터 받기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1004) {
            String key = data.getStringExtra("key");
            textView1.setText(key);
        }//if 1004

        if (requestCode == 1003) {

        }
    }//onActivityResult() override
}//class