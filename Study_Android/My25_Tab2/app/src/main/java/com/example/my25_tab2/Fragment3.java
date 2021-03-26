package com.example.my25_tab2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Fragment3 extends Fragment {
    MainActivity activity;
    String sendData, receiveData;
    Button button4;
    TextView textView3;
    Student student3;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
        sendData = "Fragment 3에서 보낸 데이터입니다.";
        receiveData = "";
        student3 = new Student("Android", 41);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        textView3 = rootView.findViewById(R.id.textView3);
        button4 = rootView.findViewById(R.id.button4);

        //데이터 받는 곳
        if (activity.mBundle != null) {
            Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            int index = bundle.getInt("index");
            Student student2 = (Student) bundle.getSerializable("student2");
            String name = student2.getName();
            int age = student2.getAge();

            textView3.setText(receiveData + "\n");
            textView3.append("name : " + name + "\nage : " + age);
            activity.mBundle = null;
        }

        //데이터 보내는 곳
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData", sendData);
                bundle.putInt("index", 2);
                bundle.putSerializable("student3", student3);

                activity.fragBtnClicked(bundle);

                TabLayout.Tab tab = activity.tabs.getTabAt(0);
                tab.select();
            }
        });

        return rootView;
    }//onCreateView() override
}//class
