package com.example.rafaelmeyer.thefirstmvpapp.model;

/**
 * Created by rafael.meyer on 10/14/16.
 */
public class Person {

    private String name;
    private String cpf;

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

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
}
