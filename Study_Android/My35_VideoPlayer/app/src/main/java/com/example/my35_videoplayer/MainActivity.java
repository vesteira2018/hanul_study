package com.example.my35_videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    Button button1;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        videoView = findViewById(R.id.videoView);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "동영상이 준비되었습니다", Toast.LENGTH_SHORT).show();
            }//onPrepared() override
        });//videoView.setOnPreparedListener

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "동영상 재생 완료", Toast.LENGTH_SHORT).show();
            }//onCompletion() override
        });//videoView.setOnCompletionListener

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVideoURI(Uri.parse(VIDEO_URL));
                videoView.requestFocus();
                videoView.start();
            }//onClick() override
        });//button1.setOnClickListener
    }//onCreate() override

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
    }
}//class