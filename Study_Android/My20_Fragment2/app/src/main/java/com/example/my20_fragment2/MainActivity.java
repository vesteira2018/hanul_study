package com.example.my20_fragment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment;
    ViewerFragment viewerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) getSupportFragmentManager().findFragmentById(R.id.viewerFragment);
    }

    public void onBtnSelect(int resId) {
        viewerFragment.onImgChange(resId);
    }//onBtnSelect()
}//class