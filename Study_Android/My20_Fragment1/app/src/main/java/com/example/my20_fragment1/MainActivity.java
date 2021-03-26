package com.example.my20_fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    SubFragment subFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        subFragment = new SubFragment();
    }//onCreate() override

    public void onFragmentChange(int state) {
        if (state == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, subFragment).commit();
        } else if (state == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        }

    }//onFragmentChange()
}//class