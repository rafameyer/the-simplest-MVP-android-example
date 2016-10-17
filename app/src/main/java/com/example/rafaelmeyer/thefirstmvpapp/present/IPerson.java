package com.example.rafaelmeyer.thefirstmvpapp.present;

import com.example.rafaelmeyer.thefirstmvpapp.model.Person;
import com.example.rafaelmeyer.thefirstmvpapp.model.PersonRealm;

import java.util.List;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public interface IPerson {

    String getNamePerson();

    void saveNamePerson(String nameModel, String cpfModel);

    List<Person> loadPersons();

    void deleteAllObjects();

}
