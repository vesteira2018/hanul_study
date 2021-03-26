package com.example.my07_alllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    ImageView imageView1, imageView2, imageView3, imageView4;
    int viewIndex1 = 2, viewIndex2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewIndex1 == 1) {
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                    viewIndex1 = 2;
                } else if (viewIndex1 == 2) {
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.VISIBLE);
                    viewIndex1 = 1;
                }
            }
        });

        button2 = findViewById(R.id.button2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewIndex2 == 1) {
                    imageView3.setVisibility(View.VISIBLE);
                    imageView4.setVisibility(View.GONE);
                    viewIndex2 = 2;
                } else if (viewIndex2 == 2) {
                    imageView3.setVisibility(View.GONE);
                    imageView4.setVisibility(View.VISIBLE);
                    viewIndex2 = 1;
                }
            }
        });
    }
}