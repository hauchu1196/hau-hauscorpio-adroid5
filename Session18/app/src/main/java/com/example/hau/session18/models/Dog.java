package com.example.hau.session18.models;

import io.realm.RealmObject;

/**
 * Created by Hau on 02/11/2016.
 */
public class Dog extends RealmObject {
    private String name;
    private String breed;


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    public static Dog create(String name, String breed) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setBreed(breed);
        return dog;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
