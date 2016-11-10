package com.example.hau.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private View vItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vItem = findViewById(R.id.v_item);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit)
                .replace(R.id.fl_container, new InFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.actionbar_menu, menu);
        menu.findItem(R.id.mni_animate).setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Log.d(TAG, "onMenuItemClick");

                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit)
                                .replace(R.id.fl_container, new OutFragment())
                                .commit();
//                        translateScale();
                        return false;
                    }
                }
        );
        return true;
    }

    void translate() {
        // 1: Create animation
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 300, // X
                0, 0 // Y
        );

        translateAnimation.setDuration(300);

        translateAnimation.setFillAfter(true);

        translateAnimation.setInterpolator(new LinearInterpolator());

        // 2: Animate
        vItem.startAnimation(translateAnimation);
    }

    void translateByXML() {
        // 1: Load animation from XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_to_right);

        // 2: Animate
        vItem.startAnimation(animation);
    }

    void rotate() {
        // 1: Create animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setDuration(3000);
//        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());

        // 2: Animate
        vItem.startAnimation(rotateAnimation);
    }

    void rotateByXML() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        vItem.startAnimation(animation);
    }

    void scale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 2f,
                1f, 2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(scaleAnimation);
    }

    void scaleByXML() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);

        vItem.startAnimation(animation);
    }

    void alpha() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(alphaAnimation);
    }

    void alphaByXML() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(animation);
        animationSet.addAnimation(rotateAnimation);
        vItem.startAnimation(animationSet);
    }

    void translateScale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_scale);
        vItem.startAnimation(animation);
    }
}
