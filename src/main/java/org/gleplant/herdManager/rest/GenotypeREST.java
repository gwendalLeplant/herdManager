package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.GenotypeManager;
import org.gleplant.herdManager.bo.Genotype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/WS/genotype")
public class GenotypeREST implements CrudREST<Genotype> {

	@Autowired
	GenotypeManager manager;
	
	@Override
	public List<Genotype> getAll() {
		return manager.selectAll();
	}

	@Override
	public Genotype getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Genotype insert(@Valid Genotype objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public Genotype update(Integer id, @Valid Genotype objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public Genotype deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
