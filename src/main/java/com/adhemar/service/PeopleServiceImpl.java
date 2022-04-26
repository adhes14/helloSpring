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
    public void save(People people) {
        peopleDao.save(people);
    }

    @Override
    @Transactional
    public void delete(People people) {
        peopleDao.delete(people);
    }

    @Override
    @Transactional(readOnly = true)
    public People findPerson(People people) {
        return peopleDao.findById(people.getIdPerson()).orElse(null);
    }
    
}
