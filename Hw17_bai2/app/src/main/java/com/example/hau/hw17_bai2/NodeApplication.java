package com.example.hau.hw17_bai2;

import android.app.Application;

import com.example.hau.hw17_bai2.managers.DbHelper;

/**
 * Created by Hau on 29/10/2016.
 */
public class NodeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DbHelper.init(this);
    }
}
