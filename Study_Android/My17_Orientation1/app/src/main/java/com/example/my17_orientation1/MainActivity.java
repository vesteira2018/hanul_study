package com.example.my17_orientation1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate() 호출됨");

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                showToast("입력된 값을 변수에 저장하였습니다");
            }//onClick() override
        });//button1.setOnClickListener

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            editText.setText(name);
            showToast("값을 복원하였습니다");
        }//if
    }//onCreate() override

    private void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }//showToast()

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
    }//onSaveInstanceState() override

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart() 호출됨");
    }//onStart() override

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop() 호출됨");
    }//onStop() override

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy() 호출됨");
    }//onDestroy() override

    @Override
    protected void onResume() {
        super.onResume();
        editText.setText(name);
    }//onResume() override
}//class