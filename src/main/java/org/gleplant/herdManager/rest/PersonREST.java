package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.PersonManager;
import org.gleplant.herdManager.bo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/person")
public class PersonREST implements CrudREST<Person> {

	@Autowired
	PersonManager manager;
	
	@Override
	public List<Person> getAll() {
		return manager.selectAll();
	}

	@Override
	public Person getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Person insert(@Valid Person objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public Person update(Integer id, @Valid Person objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public Person deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
