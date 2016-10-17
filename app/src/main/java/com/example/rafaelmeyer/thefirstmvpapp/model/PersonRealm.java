package com.example.rafaelmeyer.thefirstmvpapp.model;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public class PersonRealm extends RealmObject {

    private String name;
    private String cpf;

    private PersonRealm personRealm;

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PersonRealm saveNamePerson(String nameModel, String cpfName) {
        Realm myRealm;
        myRealm = Realm.getDefaultInstance();
        myRealm.beginTransaction();
        personRealm = myRealm.where(PersonRealm.class).findFirst();
        myRealm.commitTransaction();
        if (personRealm.getName() == null){
            myRealm.beginTransaction();
            personRealm.setName(nameModel);
            personRealm.setCpf(cpfName);
            myRealm.commitTransaction();
        } else {
            myRealm.beginTransaction();
            personRealm = myRealm.createObject(PersonRealm.class);
            personRealm.setName(nameModel);
            personRealm.setCpf(cpfName);
            myRealm.commitTransaction();
        }

        Log.d("Realm"," : " + personRealm.getName() + personRealm.getCpf());

        return personRealm;
    }

    public String getNamePerson() {
        Realm myRealm;
        myRealm = Realm.getDefaultInstance();
        PersonRealm personRealm = myRealm.where(PersonRealm.class).findFirst();

        return personRealm.getName();
    }
}
