package com.example.hau.session12.jsonmodels;

/**
 * Created by Hau on 12/10/2016.
 */
public class Item {
    private String title;
    private Media media;

    public Item(String title, Media media) {
        this.title = title;
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
