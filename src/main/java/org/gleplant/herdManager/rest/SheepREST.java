package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.SheepManager;
import org.gleplant.herdManager.bo.Sheep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/sheep")
public class SheepREST implements CrudREST<Sheep>{

	@Autowired
	SheepManager manager;
	
	@GetMapping("/genealogy/{id}")
	public List<Sheep> getGenealogyById(@PathVariable("id") int id) {
		return manager.getGenealogyOnNGeneration(manager.selectById(id), 5);
	}
	
	@Override
	public List<Sheep> getAll() {
		return manager.selectAll();
	}

	@Override
	public Sheep getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Sheep insert(@Valid Sheep objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public Sheep update(Integer id, @Valid Sheep objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public Sheep deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}
}
