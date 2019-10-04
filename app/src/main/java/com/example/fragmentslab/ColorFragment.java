package com.example.fragmentslab;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        if(getArguments() != null) {
            int color = getArguments().getInt(getString(R.string.all_color_key));
            updateContent(color);
        }
    }
    public void updateContent(int color) {
        TextView tv = getActivity().findViewById(R.id.text_color_label);
        tv.setTextColor(color);
    }

}
