package com.example.hau.session4;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FoodDetailActivity extends AppCompatActivity {

    public static final String EXTRA_FOOD = "Food";
    private static final String TAG = FoodDetailActivity.class.toString();


    private Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        getDataFromIntent();
        openDetailFragment();
        getReferences();
        setupUI();
    }

    private void openDetailFragment() {
        FoodDetailFragment foodDetailFragment = new FoodDetailFragment();
        foodDetailFragment.setFood(food);
        // 1
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 2
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_food_detail_container, foodDetailFragment);

        // 3
//                    fragmentTransaction.addToBackStack(null);

        // 4
        fragmentTransaction.commit();
    }

    private void setupUI() {

    }

    private void getReferences() {

    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra(EXTRA_FOOD);
        Log.d(TAG, food.getTitle());
    }


}
