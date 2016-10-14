package com.example.rafaelmeyer.thefirstmvpapp.model;

import com.example.rafaelmeyer.thefirstmvpapp.present.IPerson;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public class Person implements IPerson {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void saveNamePerson(String nameModel) {
        setName(nameModel);
    }

    @Override
    public String getNamePerson() {
        return getName();
    }
}
