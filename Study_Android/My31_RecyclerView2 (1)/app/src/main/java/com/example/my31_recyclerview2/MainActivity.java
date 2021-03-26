package com.example.my31_recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dtos = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SingerAdapter(this, dtos);
        adapter.addDto(new SingerDTO("BLACKPINK", "010-1111-1111", 24, R.drawable.singer1));
        adapter.addDto(new SingerDTO("DREAMCATCHER", "010-2222-2222", 25, R.drawable.singer2));
        adapter.addDto(new SingerDTO("BTS", "010-3333-3333", 26, R.drawable.singer3));
        adapter.addDto(new SingerDTO("MAMAMOO", "010-4444-4444", 26, R.drawable.singer4));
        adapter.addDto(new SingerDTO("TWICE", "010-5555-5555", 25, R.drawable.singer5));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnSingerItemClickListener() {
            @Override
            public void onItemClick(SingerAdapter.ViewHolder holderm, View view, int position) {
                SingerDTO dto = adapter.getItem(position);
                Toast.makeText(MainActivity.this, "아이템 선택됨 : " + dto.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}