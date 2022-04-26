package com.adhemar.service;

import java.util.ArrayList;

import com.adhemar.domains.People;

public interface PeopleService {
    public ArrayList<People> listPeople();

    public void save(People person);

    public void delete(People person);

    public People findPerson(People person);
}
