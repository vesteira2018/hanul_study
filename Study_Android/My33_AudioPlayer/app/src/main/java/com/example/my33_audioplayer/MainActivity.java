package com.example.my33_audioplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    String AUDIO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    MediaPlayer mediaPlayer;
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        // 재생
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playAudio(AUDIO_URL);
                playAudio1(R.raw.m01);
                Toast.makeText(MainActivity.this, "음악파일 재생", Toast.LENGTH_SHORT).show();
            }//onClick() override
        });//button1.setOnClickListener

        // 중지
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Toast.makeText(MainActivity.this, "음악파일 재생중지", Toast.LENGTH_SHORT).show();
            }//onClick() override
        });//button2.setOnCLickListener

        // 일시정지
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    position = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();

                    Toast.makeText(MainActivity.this, "음악파일 일시정지", Toast.LENGTH_SHORT).show();
                }
            }//onClick() override
        });//button3.setOnCLickListener

        // 재시작
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    mediaPlayer.seekTo(position);

                    Toast.makeText(MainActivity.this, "음악파일 재시작", Toast.LENGTH_SHORT).show();
                }
            }//onClick() override
        });//button4.setOnCLickListener

    }//onCreate() override

    private void playAudio(String audio_url) {
        killMediaPlayer();

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(AUDIO_URL);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.getMessage();
        }
    }//playAudio()

    private void playAudio1(int resId) {
        killMediaPlayer();

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), resId);
            mediaPlayer.start();
        } catch (Exception e) {
            e.getMessage();
        }
    }//playAudio1()

    private void killMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();  //플레이어 재생 종료
            mediaPlayer = null;
        }
    }//killMediaPlayer()

    @Override
    protected void onStop() {
        super.onStop();
        killMediaPlayer();
    }
}//class