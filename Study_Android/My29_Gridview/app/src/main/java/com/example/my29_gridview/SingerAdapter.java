package com.example.my29_gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {
    private static final String TAG = "main:SingerAdapter";

    Context context;
    ArrayList<SingerDTO> dtos;
    Point size;

    LayoutInflater inflater;
    AlertDialog dialog;

    public SingerAdapter(Context context, ArrayList<SingerDTO> dtos, Point size) {
        this.context = context;
        this.dtos = dtos;
        this.size = size;

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //필요한 메소드
    public void addDto(SingerDTO dto) {
        dtos.add(dto);
    }

    public void delDto(int position) {
        dtos.remove(position);
    }

    public void removeDtos() {
        dtos.clear();
    }

    @Override
    public int getCount() {
        return dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: position => " + position);
        SingerViewHolder viewHolder;
        //화면이 만들어져있지 않다면 화면을 만들어서 세팅
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.singerview, parent, false);
            viewHolder = new SingerViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.name);
            viewHolder.tvPhonenum = convertView.findViewById(R.id.phonenum);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (SingerViewHolder) convertView.getTag();
        }

        SingerDTO dto = dtos.get(position);
        String name = dto.getName();
        String phonenum = dto.getPhonenum();
        int resId = dto.getResId();

        viewHolder.tvName.setText(name);
        viewHolder.tvPhonenum.setText(phonenum);
        viewHolder.imageView.setImageResource(resId);

        //imageView에 클릭 반응 추가
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "선택 : " + dtos.get(position).getName(), Toast.LENGTH_SHORT).show();
                //이미지뷰 추가하여 직접 붙이기
                //popupImg(dtos.get(position).getResId());

                //xml 파일 추가하여 붙이기
                popupImgXml(dtos.get(position).getResId(), dtos.get(position).getName());


            }

        });
        
        return convertView;
    }

    private void popupImgXml(int resId, String name) {
        //팝업창에 xml 붙이기
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.popupimg, null);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(resId);
        textView.setTextSize(35);
        textView.append(name + "\n" + name + "\n" + name + "\n" + name + "\n" + name);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("이미지 띄우기").setView(view);
        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.create();
        dialog.show();

        // 디바이스 사이즈에서 팝업 크기창 조절
        int sizeX = size.x;
        int sizeY = size.y;

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.x = (int) Math.round(sizeX * 0.005); //x 위치
        params.y = (int) Math.round(sizeY * 0.1); //y 위치
        params.width = (int) Math.round(sizeX * 0.9);   //너비
        params.height = (int) Math.round(sizeY * 0.8);  //높이
        dialog.getWindow().setAttributes(params);

    }

    private void popupImg(int resId) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(resId);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("이미지 띄우기");
        builder.setView(imageView);

        builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    public class SingerViewHolder {
        public ImageView imageView;
        public TextView tvName, tvPhonenum;
    }

}
