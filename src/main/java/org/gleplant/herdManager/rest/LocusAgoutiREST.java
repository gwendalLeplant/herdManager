package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.LocusAgoutiManager;
import org.gleplant.herdManager.bo.LocusAgouti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/locusAgouti")
public class LocusAgoutiREST implements CrudREST<LocusAgouti> {
	
	@Autowired
	LocusAgoutiManager manager;

	@Override
	public List<LocusAgouti> getAll() {
		return manager.selectAll();
	}

	@Override
	public LocusAgouti getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public LocusAgouti insert(@Valid LocusAgouti objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public LocusAgouti update(Integer id, @Valid LocusAgouti objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public LocusAgouti deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
