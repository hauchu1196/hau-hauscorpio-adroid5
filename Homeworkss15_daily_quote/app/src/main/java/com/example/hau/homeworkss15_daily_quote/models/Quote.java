package com.example.hau.homeworkss15_daily_quote.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 25/10/2016.
 */
public class Quote {
    private String title;
    private String content;

    public Quote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content.replace("\n", "");
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final List<Quote> list = new ArrayList<>();
}
