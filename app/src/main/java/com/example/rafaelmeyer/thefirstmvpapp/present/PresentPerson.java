package com.example.rafaelmeyer.thefirstmvpapp.present;

import com.example.rafaelmeyer.thefirstmvpapp.model.Person;
import com.example.rafaelmeyer.thefirstmvpapp.model.PersonRealm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public class PresentPerson implements IPerson {

    private RealmList<PersonRealm> personRealms;
    private RealmResults<PersonRealm> results;
    private PersonRealm personRealm;
    private Realm myRealm;

    @Override
    public String getNamePerson() {
        return personRealm.getNamePerson();
    }

    @Override
    public void saveNamePerson(String nameModel, String cpfModel) {
        myRealm = Realm.getDefaultInstance();
        personRealms = new RealmList<>();
        personRealm = myRealm.where(PersonRealm.class).findFirst();
        if (personRealm == null) {
            myRealm.beginTransaction();
            personRealm = myRealm.createObject(PersonRealm.class);
            myRealm.commitTransaction();
        }
        personRealms.add(personRealm.saveNamePerson(nameModel, cpfModel));
    }

    @Override
    public List<Person> loadPersons() {
        List<Person> myList = new ArrayList<>();

        myRealm = Realm.getDefaultInstance();
        results = myRealm.where(PersonRealm.class).findAll();

        for (PersonRealm personList : results) {
            String name = personList.getName();
            String cpf  = personList.getCpf();
            Person person = new Person(name, cpf);
            myList.add(person);
        }

        return myList;
    }

    @Override
    public void deleteAllObjects() {
        myRealm = Realm.getDefaultInstance();
        results = myRealm.where(PersonRealm.class).findAll();
        myRealm.beginTransaction();
        results.deleteAllFromRealm();
        myRealm.commitTransaction();
    }

}
