package com.example.hau.homeworkss15_categories;

import android.app.Application;

import com.example.hau.homeworkss15_categories.configs.Screen;

/**
 * Created by Hau on 25/10/2016.
 */
public class CategoryApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Screen.init(this);
    }
}
