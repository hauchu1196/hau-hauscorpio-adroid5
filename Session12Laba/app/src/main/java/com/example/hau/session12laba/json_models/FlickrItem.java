package com.example.hau.session12laba.json_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 13/10/2016.
 */
public class FlickrItem {
    @SerializedName("title")
    private String title;

    @SerializedName("date_taken")
    private String dateTaken;

    @SerializedName("media")
    private Media media;

    public String getImageLink() {
        return media.getLink();
    }

    private class Media {
        @SerializedName("m")
        private String link;

        public String getLink() {
            return link;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
