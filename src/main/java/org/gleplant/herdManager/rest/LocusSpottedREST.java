package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.LocusSpottedManager;
import org.gleplant.herdManager.bo.LocusSpotted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/locusSpotted")
public class LocusSpottedREST implements CrudREST<LocusSpotted> {

	@Autowired
	LocusSpottedManager manager;
	
	@Override
	public List<LocusSpotted> getAll() {
		return manager.selectAll();
	}

	@Override
	public LocusSpotted getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public LocusSpotted insert(@Valid LocusSpotted objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public LocusSpotted update(Integer id, @Valid LocusSpotted objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public LocusSpotted deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
