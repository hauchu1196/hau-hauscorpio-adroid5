package com.example.hau.turn1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemActivity extends AppCompatActivity {

    @BindView(R.id.rl_add_to_cart)
    RelativeLayout rlAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.rl_add_to_cart)
    public void showDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(fragmentManager, "fragment_dialog");

    }
}
