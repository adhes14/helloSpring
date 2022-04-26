package com.adhemar.dao;

import com.adhemar.domains.Person;
import org.springframework.data.repository.CrudRepository;

public interface PeopleDao extends CrudRepository<Person, Long> {
    
}
