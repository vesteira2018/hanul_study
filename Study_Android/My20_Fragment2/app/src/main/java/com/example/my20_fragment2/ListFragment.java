package com.example.my20_fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    MainActivity activity;
    Button button1, button2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        activity = (MainActivity) getActivity();
        button1 = rootView.findViewById(R.id.button1);
        button2 = rootView.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBtnSelect(R.drawable.dream01);
            }//onClick() override
        });//button1.setOnClickListener

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBtnSelect(R.drawable.dream02);
            }//onClick() override
        });//button2.setOnClickListener

        return rootView;
    }//onCreateView()
}//class

