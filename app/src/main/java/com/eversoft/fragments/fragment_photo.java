package com.eversoft.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eversoft.traversenepal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_photo extends Fragment {


    public fragment_photo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_photo,container,false);
        return rootView;
    }

}
