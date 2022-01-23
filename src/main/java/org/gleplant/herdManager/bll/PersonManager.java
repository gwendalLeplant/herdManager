package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.Person;
import org.gleplant.herdManager.dal.PersonDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PersonManager extends CrudManager<Person,PersonDAOJDBCImpl> {

}
