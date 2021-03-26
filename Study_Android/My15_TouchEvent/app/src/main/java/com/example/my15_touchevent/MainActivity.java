package com.example.my15_touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view1, view2;
    ScrollView scrollView;
    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        scrollView = findViewById(R.id.scrollView);
        textView = findViewById(R.id.textView);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();
                float curY = event.getY();

                //구역에 손가락의 행동에 따른 반응
                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락이 눌림 : " + curX + ", " + curY);
                } else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락이 움직임 : " + curX + ", " + curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    println("손가락이 떼짐 : " + curX + ", " + curY);
                }//if

                return true;
            }//onTouch() override
        });//view1.setOnTouchListener

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);

                return true;
            }//onTouch() override
        });//view2.setOnTouchListener

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            //화면이 눌렸을 때
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown() 호출됨");
                return true;
            }

            //화면이 눌렸다가 떼어졌을 때
            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress() 호출됨");
            }

            //화면이 한 손가락으로 눌렸다가 떼어졌을 때
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp() 호출됨");
                return true;
            }

            //화면이 눌린채 일정한 속도와 방향으로 움직였다 떼어졌을 때
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll() 호출됨" + distanceX + ", " + distanceY);
                return true;
            }

            //화면을 손가락으로 오랫동안 눌렀을 때
            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress() 호출됨");
            }

            //화면이 눌린 채 가속도를 붙여 손가락을 움직였다 떼었을 때
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling() 호출됨" + velocityX + ", " + velocityY);
                return true;
            }
        });

    }//onCreate() override

    private void println(String data) {
        textView.append(data + "\n");
        scrollView.fullScroll(View.FOCUS_DOWN);
    }//println()

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            println("시스템에서 [BACK]버튼이 눌렸습니다");
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            println("시스템에서 [Vol Up]버튼이 눌렸습니다");
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            println("시스템에서 [Vol Down]버튼이 눌렸습니다");
        }
        return super.onKeyDown(keyCode, event);
    }//onKeyDown() override
}//class