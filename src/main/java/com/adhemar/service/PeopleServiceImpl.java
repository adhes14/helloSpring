package com.adhemar.service;

import java.util.ArrayList;

import com.adhemar.dao.PeopleDao;
import com.adhemar.domains.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<People> listPeople() {
        return (ArrayList<People>) peopleDao.findAll();
    }

    @Override
    @Transactional
    public void save(People person) {
        peopleDao.save(person);
    }

    @Override
    @Transactional
    public void delete(People person) {
        peopleDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public People findPerson(People person) {
        return peopleDao.findById(person.getIdPerson()).orElse(null);
    }
    
}
