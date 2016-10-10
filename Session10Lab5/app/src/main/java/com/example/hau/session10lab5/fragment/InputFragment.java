package com.example.hau.session10lab5.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hau.session10lab5.MainActivity;
import com.example.hau.session10lab5.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    private static final String TAG = InputFragment.class.toString();
    private ImageView ivBack;

    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).showSendMenu(true);
        ((MainActivity) getActivity()).defaultToggle(false);
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetah");
        ((MainActivity) getActivity()).setDefault();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        return view;
    }



}
