package com.example.hau.session18.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Hau on 02/11/2016.
 */
public class Person extends RealmObject {
    private String name;
    private int age;
    private RealmList<Dog> dogs;

    public Person() {
        dogs = new RealmList<>();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dogs=" + dogs.size()+
                '}';
    }

    public static Person create(String name, int age) {
        Person person = new Person();
        person.name = name;
        person.age = age;
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RealmList<Dog> getDogs() {
        if (dogs == null) {
            dogs = new RealmList<>();
        }
        return dogs;
    }
}
