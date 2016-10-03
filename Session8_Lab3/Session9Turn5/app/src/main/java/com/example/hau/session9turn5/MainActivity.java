package com.example.hau.session9turn5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.dsb_test)
    DiscreteSeekBar dsbTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        dsbTest.setProgress(50);
    }
}
