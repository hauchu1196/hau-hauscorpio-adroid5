package com.example.hau.homeworkss15_daily_quote;

import android.app.Application;

import com.example.hau.homeworkss15_daily_quote.managers.FileManager;
import com.example.hau.homeworkss15_daily_quote.managers.NetworkManger;
import com.example.hau.homeworkss15_daily_quote.managers.Preferrences;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Hau on 25/10/2016.
 */
public class QuoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManger.init(this);
        Preferrences.init(this);
        FileManager.init(this);
        initImageLoader();


    }

    private void initImageLoader() {
        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
    }
}
