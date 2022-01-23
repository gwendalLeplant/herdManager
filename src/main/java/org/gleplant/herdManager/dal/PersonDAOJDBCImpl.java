package org.gleplant.herdManager.dal;

import org.gleplant.herdManager.bo.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAOJDBCImpl extends CrudRepository<Person, Integer> {

}
