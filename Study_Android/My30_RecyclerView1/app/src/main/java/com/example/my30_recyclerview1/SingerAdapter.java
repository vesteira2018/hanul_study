package com.example.my30_recyclerview1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my30_recyclerview1.R;
import com.example.my30_recyclerview1.SingerDTO;

import java.util.ArrayList;

public class SingerAdapter extends
        RecyclerView.Adapter<SingerAdapter.ViewHolder> {
    private static final String TAG = "SingerAdapter";

    Context context;
    ArrayList<SingerDTO> dtos;

    public SingerAdapter(Context context, ArrayList<SingerDTO> dtos) {
        this.context = context;
        this.dtos = dtos;
    }

    // 화면(xml)연결
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.singerview, parent, false);


        return new ViewHolder(itemView);
    }

    // 데이터 연결
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);

        SingerDTO dto = dtos.get(position);
        holder.setItem(dto);

        holder.parentLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + position);

                Toast.makeText(context, "phonenum : " + dtos.get(position).getPhonenum(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + position);

                Toast.makeText(context, "name : " + dtos.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dtos.size();
    }

    public void addDto(SingerDTO dto) {
        dtos.add(dto);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhonenum;
        ImageView imageView;
        LinearLayout parentLay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLay = itemView.findViewById(R.id.parentLay);

            tvName = itemView.findViewById(R.id.name);
            tvPhonenum = itemView.findViewById(R.id.phonenum);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void setItem(SingerDTO dto) {
            tvName.setText(dto.getName());
            tvPhonenum.setText(dto.getPhonenum());
            imageView.setImageResource(dto.getResId());
        }

    }
}