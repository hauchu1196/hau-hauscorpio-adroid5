package com.example.hau.hw6relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iv_circle)
    ImageView ivCircle;
    @BindView(R.id.iv_shape1)
    ImageView ivShape1;
    @BindView(R.id.iv_shape2)
    ImageView ivShape2;
    @BindView(R.id.iv_shape3)
    ImageView ivShape3;
    @BindView(R.id.iv_shape4)
    ImageView ivShape4;
    @BindView(R.id.iv_shape6)
    ImageView ivShape6;
    @BindView(R.id.iv_shape7)
    ImageView ivShape7;
    @BindView(R.id.iv_shape8)
    ImageView ivShape8;
    @BindView(R.id.iv_shape9)
    ImageView ivShape9;
    @BindView(R.id.iv_shape10)
    ImageView ivShape10;
    @BindView(R.id.iv_shape11)
    ImageView ivShape11;
    @BindView(R.id.id_shape12)
    ImageView ivShape12;
    @BindView(R.id.iv_icon1) ImageView ivIcon1;
    @BindView(R.id.iv_icon2) ImageView ivIcon2;
    @BindView(R.id.iv_icon3) ImageView ivIcon3;
    @BindView(R.id.iv_icon4) ImageView ivIcon4;
    @BindView(R.id.iv_icon5) ImageView ivIcon5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        ivCircle.setImageResource(R.drawable.oval_avatar);
        ivShape1.setImageResource(R.drawable.bitmap4);
        ivShape2.setImageResource(R.drawable.bitmap3);
        ivShape3.setImageResource(R.drawable.bitmap2);
        ivShape4.setImageResource(R.drawable.bitmap7);
        ivShape6.setImageResource(R.drawable.bitmap1);
        ivShape7.setImageResource(R.drawable.bitmap10);
        ivShape8.setImageResource(R.drawable.bitmap8);
        ivShape9.setImageResource(R.drawable.bitmap6);
        ivShape10.setImageResource(R.drawable.play_icon_group);
        ivShape11.setImageResource(R.drawable.bitmap12);
        ivShape12.setImageResource(R.drawable.bitmap11);
        ivIcon1.setImageResource(R.drawable.albums);
        ivIcon2.setImageResource(R.drawable.path);
        ivIcon3.setImageResource(R.drawable.music_note);
        ivIcon4.setImageResource(R.drawable.radio);
        ivIcon5.setImageResource(R.drawable.search);
    }

}
