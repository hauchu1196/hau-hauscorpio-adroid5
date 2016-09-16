package com.example.hau.homeworksession3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {
    private static final String TAG = ActivityB.class.toString();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countCreate++;
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_activity_b);
        getReferences();
        addListeners();
    }

    private void addListeners() {

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
        onStart = (TextView) findViewById(R.id.tv_count_on_start2);
        onRestart = (TextView) findViewById(R.id.tv_count_on_restart2);
        onResume = (TextView) findViewById(R.id.tv_count_on_resume2);
        onPause = (TextView) findViewById(R.id.tv_count_on_pause2);
        onStop = (TextView) findViewById(R.id.tv_count_on_stop2);
        onDestroy = (TextView) findViewById(R.id.tv_count_on_destroy2);

    }


    @Override
    protected void onStart() {
        super.onStart();
        countStart++;
        Log.d(TAG, "onStart");
        setupUIProperties();
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
