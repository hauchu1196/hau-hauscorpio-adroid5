package com.example.hau.session12.jsonmodels;

/**
 * Created by Hau on 12/10/2016.
 */
public class FlickrJSONModel {
    private Item[] items;

    public FlickrJSONModel(Item[] items) {
        this.items = items;
    }



    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}
