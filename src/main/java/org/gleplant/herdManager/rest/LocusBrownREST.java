package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.LocusBrownManager;
import org.gleplant.herdManager.bo.LocusBrown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/WS/locusBrown")
public class LocusBrownREST implements CrudREST<LocusBrown> {

	@Autowired
	LocusBrownManager manager;
	
	@Override
	public List<LocusBrown> getAll() {
		return manager.selectAll();
	}

	@Override
	public LocusBrown getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public LocusBrown insert(@Valid LocusBrown objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public LocusBrown update(Integer id, @Valid LocusBrown objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public LocusBrown deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
