package com.example.hau.homeworkss15_tumble_log.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 25/10/2016.
 */
public class PostJSONModel {
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;

    public PostJSONModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
