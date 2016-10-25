package com.example.hau.homeworkss15_categories.configs;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Hau on 25/10/2016.
 */
public class Screen {
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private WindowManager windowManager;

    private Screen(Context context) {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
    }

    private static Screen instance;
    public static Screen getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new Screen(context);
    }
}
