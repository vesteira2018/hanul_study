package com.example.my10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private static final String TAG = "main:SubActivity";

    Button button2;
    TextView textView2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);

        //데이터를 받는 곳
        intent = getIntent();
        String id = intent.getStringExtra("id");
        int pw = intent.getIntExtra("pw", 0);
        Person person1 = (Person) intent.getSerializableExtra("person1");

        Log.d(TAG, "onCreate: id => " + id);
        Log.d(TAG, "onCreate: pw => " + pw);

        textView2.setText("받은 값은 \n아이디 : " + id + "\n암호 : " + pw);
        textView2.append("\n" + person1.getId() + "\n" + person1.getPw());

        //MainActivity로 데이터 보내기
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent();
                reIntent.putExtra("key", textView2.getText().toString() + " ㅋㅋㅋ");
                setResult(RESULT_OK, reIntent);

                finish();
            }//onClick() override
        });//button2.setOnClickListener


    }//onCreate() override
}//class