package com.example.my09_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    LinearLayout linear;
    RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        linear = findViewById(R.id.linear);
        relative = findViewById(R.id.relative);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater
                        = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub1, linear, true);
                inflater.inflate(R.layout.sub2, relative, true);

                Button btnLinear = linear.findViewById(R.id.button2);
                Button btnRelative = relative.findViewById(R.id.button3);

                btnLinear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Sub1 Button", Toast.LENGTH_SHORT).show();
                    }//onClick() override
                });//btnLinear.setOnClickListener

                btnRelative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Sub2 Button", Toast.LENGTH_LONG).show();
                    }//onClick() override
                });//btnRelative.setOnClickListener

            }//onClick() override
        });//button1.setOnClickListener

    }//onCreate() override
}//class