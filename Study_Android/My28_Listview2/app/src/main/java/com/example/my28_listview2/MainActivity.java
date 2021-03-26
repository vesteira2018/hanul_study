package com.example.my28_listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView listView;

    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;

    Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 핸드폰
        size = getDeviceSize();

        dtos = new ArrayList<>();

        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        adapter = new SingerAdapter(MainActivity.this, dtos, size);
        adapter.addDto(new SingerDTO("BLACKPINK", "010-1111-1111", 24, R.drawable.singer1));
        adapter.addDto(new SingerDTO("DREAMCATCHER", "010-2222-2222", 25, R.drawable.singer2));
        adapter.addDto(new SingerDTO("BTS", "010-3333-3333", 26, R.drawable.singer3));
        adapter.addDto(new SingerDTO("MAMAMOO", "010-4444-4444", 26, R.drawable.singer4));
        adapter.addDto(new SingerDTO("TWICE", "010-5555-5555", 25, R.drawable.singer5));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerDTO dto = (SingerDTO) adapter.getItem(position);
                Toast.makeText(MainActivity.this,
                        "선택 : " + position + "\n이름 : " + dto.getName() + "\n전화번호 : " + dto.getPhonenum()
                        + "\n나이 : " + dto.getAge() + "\n이미지" + dto.getResId()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "ITZY";
                String phonenum = "010-6666-6666";
                int age = 20;
                int resId = R.drawable.singer1;

                SingerDTO dto = new SingerDTO(name, phonenum, age, resId);
                adapter.addDto(dto);
                //자동갱신
                adapter.notifyDataSetChanged();
            }
        });
    }

    private Point getDeviceSize() {
        Display display = getWindowManager().getDefaultDisplay();   //Activity일 때
        //getActivity().getWindowManager().getDefaultDisplay()  //Fragment일 때
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;
        return size;
    }
}