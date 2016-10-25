package com.example.hau.homeworkss15_tumble_log.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 25/10/2016.
 */
public class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static final List<Post> list = new ArrayList<>();
}
