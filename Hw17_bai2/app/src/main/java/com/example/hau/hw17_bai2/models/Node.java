package com.example.hau.hw17_bai2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hau on 29/10/2016.
 */
public class Node {
    private int id;
    private String title;
    private String content;
    private String timeCreated;

    public Node(int id, String title, String content, String timeCreated) {
        this.title = title;
        this.content = content;
        this.timeCreated = timeCreated;
        this.id = id;
    }

    public Node(String title, String content, String timeCreated) {
        this(-1, title, content, timeCreated);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public static List<Node> list = new ArrayList<>();
}
