package com.example.hau.butterknifedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends BaseFragment {

    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindColor(R.color.colorAccent) int accentColor;


    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);

        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        btnOk.setBackgroundColor(accentColor);
    }

    @OnClick(R.id.btn_ok)
    void onClick(View v) {
        openFragment(new VerySimpleFragment(), true);
    }

}
