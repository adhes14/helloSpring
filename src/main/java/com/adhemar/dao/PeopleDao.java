package com.adhemar.dao;

import com.adhemar.domains.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleDao extends CrudRepository<People, Long> {
    
}
