package com.example.hau.session18.managers;

import android.content.Context;

import com.example.hau.session18.models.Dog;
import com.example.hau.session18.models.Person;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by Hau on 02/11/2016.
 */
public class DbContext {
    private Realm realm;

    private DbContext(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    /*=========================== Dog ================================*/
    public void add(Dog dog) {
        // 2: Get Realm default
        Realm realm = Realm.getDefaultInstance(); // Singleton

        // 4: Add object to realm (managed object)
        realm.beginTransaction();
        realm.copyToRealm(dog);
        realm.commitTransaction();
    }

    public List<Dog> findAllDog() {
        // 2
        Realm realm = Realm.getDefaultInstance();

        // 3: Query - Lazy load
        RealmResults<Dog> dogs = realm
                .where(Dog.class)
                .findAll();
        return dogs;
    }

    public Dog findDogByName(String name) {
        // 2
        Realm realm = Realm.getDefaultInstance();

        // 3: Quere - lazy load
        Dog dog = realm
                .where(Dog.class)
                .equalTo("name", name, Case.INSENSITIVE)
                .findFirst();

        return dog;
    }

    public void update(Dog dog, String name, String breed) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        dog.setName(name);
        dog.setBreed(breed);
        realm.commitTransaction();
    }

    public void delete(Dog dog) {
        if (dog == null) return;

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        dog.deleteFromRealm();
        realm.commitTransaction();
    }

    public void addDogToPerson(Person person, Dog dog) {
        realm.beginTransaction();
        person.getDogs().add(dog);
        realm.commitTransaction();
    }


    /*=========================== Person ================================*/
    public void add(Person person) {
        // 2: Get Realm default
        Realm realm = Realm.getDefaultInstance(); // Singleton

        // 4: Add object to realm (managed object)
        realm.beginTransaction();
        realm.copyToRealm(person);
        realm.commitTransaction();
    }

    public List<Person> findAllPerson() {
        // 2
        Realm realm = Realm.getDefaultInstance();

        // 3: Query - Lazy load
        RealmResults<Person> persons = realm
                .where(Person.class)
                .findAll();
        return persons;
    }

    public Person findPersonByName(String name) {
        // 2
        Realm realm = Realm.getDefaultInstance();

        // 3: Quere - lazy load
        Person person = realm
                .where(Person.class)
                .equalTo("name", name, Case.INSENSITIVE)
                .findFirst();

        return person;
    }

    public void update(Person person, String name, int age) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        person.setName(name);
        person.setAge(age);
        realm.commitTransaction();
    }

    public void delete(Person person) {
        if (person == null) return;

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        person.deleteFromRealm();
        realm.commitTransaction();
    }

    public void deleteAll(Class<? extends RealmModel> clazz) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();
    }
    /*=========================== Singleton ================================*/

    public static DbContext instance;

    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbContext(context);
    }

    public int getNextId(Class<? extends RealmModel> clazz, String idKey) {
        Number idNumber = realm
                .where(clazz)
                .max(idKey);
        if (idNumber == null) return 1;
        return idNumber.intValue() + 1;
    }

}
