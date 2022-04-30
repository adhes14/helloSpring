package com.adhemar.service;

import java.util.ArrayList;

import com.adhemar.dao.PeopleDao;
import com.adhemar.domains.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Person> listPeople() {
        return (ArrayList<Person>) peopleDao.findAll();
    }

    @Override
    @Transactional
    public void save(Person people) {
        peopleDao.save(people);
    }

    @Override
    @Transactional
    public void delete(Person people) {
        peopleDao.delete(people);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person people) {
        return peopleDao.findById(people.getIdPerson()).orElse(null);
    }
    
}
