package com.example.hau.lab4turn1a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DetailsFragment extends Fragment {
    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onStop() {
        MainActivity.lvItem.setEnabled(true);
        MainActivity.lvItem.setVisibility(View.VISIBLE);
        super.onStop();
    }
}
