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
public class SuccessfulFragment extends Fragment {

    private static final String TAG = SuccessfulFragment.class.toString();
    ImageView ivOk;
    private View.OnClickListener ivListener;

    public SuccessfulFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).showActionBar(false);
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
        Log.d(TAG, "onDetach");
        ((MainActivity) getActivity()).setDefault();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_successful, container, false);
        ivOk = (ImageView) view.findViewById(R.id.iv_ok);
        addListeners();
        return view;
    }

    private void addListeners() {
        if (ivListener != null) {
            ivOk.setOnClickListener(ivListener);
        }
    }

    public void setIvListener(View.OnClickListener ivListener) {
        this.ivListener = ivListener;
    }
}
