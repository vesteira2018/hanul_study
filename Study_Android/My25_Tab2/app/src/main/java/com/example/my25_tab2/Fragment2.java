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

public class Fragment2 extends Fragment {
    MainActivity activity;
    String sendData, receiveData;
    Button button3;
    TextView textView2;
    Student student2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
        sendData = "Fragment 2에서 보낸 데이터입니다.";
        receiveData = "";
        student2 = new Student("JAVA", 27);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        textView2 = rootView.findViewById(R.id.textView2);
        button3 = rootView.findViewById(R.id.button3);

        //데이터 받는 곳
        if (activity.mBundle != null) {
            Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            int index = bundle.getInt("index");
            Student student1 = (Student) bundle.getSerializable("student1");
            String name = student1.getName();
            int age = student1.getAge();

            textView2.setText(receiveData + "\n");
            textView2.append("name : " + name + "\nage : " + age);
            activity.mBundle = null;
        }

        //데이터 보내는 곳
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData", sendData);
                bundle.putInt("index", 1);
                bundle.putSerializable("student2", student2);

                activity.fragBtnClicked(bundle);

                TabLayout.Tab tab = activity.tabs.getTabAt(2);
                tab.select();
            }
        });


        return rootView;
    }//onCreateView() override
}//class
