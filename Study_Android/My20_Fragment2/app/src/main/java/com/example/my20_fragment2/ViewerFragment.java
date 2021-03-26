package com.example.my20_fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {
    MainActivity activity;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);
        activity = (MainActivity) getActivity();
        imageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }//onCreateView() override

    public void onImgChange(int resId) {
        imageView.setImageResource(resId);
    }//onImgChange()

}//class
