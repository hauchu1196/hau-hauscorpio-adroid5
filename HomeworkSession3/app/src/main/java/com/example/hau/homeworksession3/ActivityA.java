package com.example.hau.homeworksession3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {
    private static final String TAG = ActivityA.class.toString();
    private TextView onCreate;
    private int countCreate;
    private TextView onStart;
    private int countStart;
    private TextView onRestart;
    private int countRestart;
    private TextView onResume;
    private int countResume;
    private TextView onPause;
    private int countPause;
    private TextView onStop;
    private int countStop;
    private TextView onDestroy;
    private int countDestroy;
    private Button btnChangeActB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countCreate++;
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_);
        getReferences();
        addListeners();
    }

    private void addListeners() {
        btnChangeActB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                startActivity(intent);
            }
        });
    }

    private void setupUIProperties() {
        onCreate.setText(String.valueOf(countCreate));
        onStart.setText(String.valueOf(countStart));
        onRestart.setText(String.valueOf(countRestart));
        onResume.setText(String.valueOf(countResume));
        onPause.setText(String.valueOf(countPause));
        onStop.setText(String.valueOf(countStop));
        onDestroy.setText(String.valueOf(countDestroy));
    }

    private void getReferences() {
        onCreate = (TextView) findViewById(R.id.tv_count_on_create2);
        onStart = (TextView) findViewById(R.id.tv_count_on_start);
        onRestart = (TextView) findViewById(R.id.tv_count_on_restart2);
        onResume = (TextView) findViewById(R.id.tv_count_on_resume2);
        onPause = (TextView) findViewById(R.id.tv_count_on_pause);
        onStop = (TextView) findViewById(R.id.tv_count_on_stop);
        onDestroy = (TextView) findViewById(R.id.tv_count_on_destroy);
        btnChangeActB = (Button) findViewById(R.id.btn_change_activityB);

    }


    @Override
    protected void onStart() {
        super.onStart();
        countStart++;
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countRestart++;
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        countResume++;
        Log.d(TAG, "onResume");
        setupUIProperties();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countPause++;
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        countStop++;
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDestroy++;
        Log.d(TAG, "onDestroy");
    }
}
