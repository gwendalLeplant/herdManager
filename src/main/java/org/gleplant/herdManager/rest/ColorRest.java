package org.gleplant.herdManager.rest;

import java.util.List;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.ColorManager;
import org.gleplant.herdManager.bo.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/WS/color")
public class ColorRest implements CrudREST<Color> {

	@Autowired 
	ColorManager manager;
	
	@Override
	public List<Color> getAll() {
		return manager.selectAll();
	}

	@Override
	public Color getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Color insert(@Valid Color objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public Color update(Integer id, @Valid Color objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public Color deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
