package com.example.hau.session12laba.json_models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 13/10/2016.
 */
public class FlickrFeed {
    @SerializedName("title")
    private String title;

    @SerializedName("items")
    private ArrayList<FlickrItem> items;

    public String getTitle() {
        return title;
    }

    public List<FlickrItem> getItems() {
        return items;
    }
}
