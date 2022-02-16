package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.LocusFadedManager;
import org.gleplant.herdManager.bo.LocusFaded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WS/locusFaded")
public class LocusFadedREST implements CrudREST<LocusFaded> {

	@Autowired
	LocusFadedManager manager;
	
	@Override
	public List<LocusFaded> getAll() {
		return manager.selectAll();
	}

	@Override
	public LocusFaded getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public LocusFaded insert(@Valid LocusFaded objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public LocusFaded update(Integer id, @Valid LocusFaded objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public LocusFaded deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
