package com.example.hau.session18.jsonmodels;

/**
 * Created by Hau on 02/11/2016.
 */
public class Repo {
    private String id;
    private String name;
    private String full_name;

    @Override
    public String toString() {
        return "Repo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }
}
