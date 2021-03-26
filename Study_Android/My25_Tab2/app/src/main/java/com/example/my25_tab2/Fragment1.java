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

public class Fragment1 extends Fragment {
    MainActivity activity;
    String sendData, receiveData;
    Button button2;
    TextView textView1;
    Student student1;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
        sendData = "Fragment 1에서 보낸 데이터입니다.";
        receiveData = "";
        student1 = new Student("CSS", 35);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        textView1 = rootView.findViewById(R.id.textView1);
        button2 = rootView.findViewById(R.id.button2);

        //데이터 받는 곳
        if (activity.mBundle != null) {
            /*Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            int index = bundle.getInt("index");
            Student student3 = (Student) bundle.getSerializable("student3");
            String name = student3.getName();
            int age = student3.getAge();

            textView1.setText(receiveData + "\n");
            textView1.append("name : " + name + "\nage : " + age);*/
            activity.mBundle = null;
        }

        //데이터 보내는 곳
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData", sendData);
                bundle.putInt("index", 0);
                bundle.putSerializable("student1", student1);

                activity.fragBtnClicked(bundle);

                TabLayout.Tab tab = activity.tabs.getTabAt(1);
                tab.select();
            }
        });

        return rootView;
    }//onCreateView() override
}//class
