package com.example.hau.session2;

import android.graphics.Color;
import android.hardware.Camera;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlash;
    private Camera camera;
    RelativeLayout backGround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCamera();
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        getReferences();
        tgFlash.setChecked(true);
        addListeners();

    }

    private void getCamera() {
        try {
            camera = Camera.open();
        } catch (RuntimeException e) {
            Log.e(TAG, String.format("Could not open camera: %s", e.getMessage()));
        }
    }

    private void getReferences() {
        tgFlash = (ToggleButton) findViewById(R.id.tb_flash);
        backGround = (RelativeLayout) findViewById(R.id.backGround);
    }

    private void addListeners() {
        tgFlash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("tgFlash check changed : %s", isChecked));
                if (isChecked) {
                    stateCamera(Camera.Parameters.FLASH_MODE_TORCH);
                    backGround.setBackgroundColor(Color.WHITE);
                } else {
                    stateCamera(Camera.Parameters.FLASH_MODE_OFF);
                    backGround.setBackgroundColor(Color.BLACK);

                }
            }
        });
    }

    private void stateCamera(String state) {
        Camera.Parameters params = camera.getParameters();
        params.setFlashMode(state);
        camera.setParameters(params);
        camera.startPreview();
    }

    @Override
    protected void onStart() { // visible
        super.onStart();
        stateCamera(Camera.Parameters.FLASH_MODE_TORCH);
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() { // active
        super.onStop();
//        stateCamera(Camera.Parameters.FLASH_MODE_OFF);
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        stateCamera(Camera.Parameters.FLASH_MODE_OFF);
        if(camera != null){
            camera.release();
            camera = null;
        }
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCamera();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
