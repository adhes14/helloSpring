package com.adhemar.service;

import java.util.ArrayList;

import com.adhemar.domains.Person;

public interface PeopleService {
    public ArrayList<Person> listPeople();

    public void save(Person person);

    public void delete(Person person);

    public Person findPerson(Person person);
}
