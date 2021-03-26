package com.example.my16_progress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText editText;
    Button button1, button2, button3;
    ProgressDialog dialog;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        seekBar = findViewById(R.id.seekBar);

        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(30);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() != 0) {
                    int value = Integer.parseInt(editText.getText().toString());
                    progressBar.setProgress(value);
                } else {
                    Toast.makeText(MainActivity.this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                }//if
            }//onClick() override
        });//button1.setOnClickListener

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }//onClick()
        });//button2.setOnClickListener

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialog != null) {
                    dialog.dismiss();
                }
            }//onClick() override
        });//button3.setOnClickListener

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editText.setText("" + progress);
            }//onProgressChanged() override

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }//onStartTrackingTouch() override

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }//onStopTrackingTouch() override
        });//seekBar.setOnSeekBarChangeListener

    }//onCreate() override
}//class