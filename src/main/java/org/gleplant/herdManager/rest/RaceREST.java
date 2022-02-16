package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.RaceManager;
import org.gleplant.herdManager.bo.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/race")
public class RaceREST implements CrudREST<Race> {

	@Autowired
	RaceManager manager;
	
	@Override
	public List<Race> getAll() {
		return manager.selectAll();
	}

	@Override
	public Race getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Race insert(@Valid Race objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public Race update(Integer id, @Valid Race objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public Race deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
