package com.example.hau.homeworkss15_categories.models;

import android.graphics.Bitmap;

import com.example.hau.homeworkss15_categories.MainActivity;
import com.example.hau.homeworkss15_categories.R;
import com.example.hau.homeworkss15_categories.configs.Screen;
import com.example.hau.homeworkss15_categories.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 25/10/2016.
 */
public class Category {
    private String title;
    private Bitmap bitmap;

    public Category(String title, Bitmap bitmap) {
        this.title = title;
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private static List<Category> list = null;

    public static List<Category> getList() {
        if (list == null) {
            list = new ArrayList<>();
            int width = Screen.getInstance().getWidth() / 2;
            int height = Screen.getInstance().getHeight() / 2000;
            list.add(new Category("breakfast", Utils.decodeSampledBitmapFromResource(MainActivity.resources, R.drawable.breakfirst, width, height)));
            list.add(new Category("coffee", Utils.decodeSampledBitmapFromResource(MainActivity.resources, R.drawable.coffee, width, height)));
            list.add(new Category("appetizers", Utils.decodeSampledBitmapFromResource(MainActivity.resources, R.drawable.appertizer, width, height)));
            list.add(new Category("drinks", Utils.decodeSampledBitmapFromResource(MainActivity.resources, R.drawable.drinks, width, height)));
            list.add(new Category("lunch", Utils.decodeSampledBitmapFromResource(MainActivity.resources, R.drawable.lunch, width, height)));
        }
        return list;
    }
}
