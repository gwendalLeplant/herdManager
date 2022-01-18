package org.gleplant.herdManager.dal;

import org.gleplant.herdManager.bo.Color;
import org.springframework.data.repository.CrudRepository;

public interface ColorDAOJDBCImpl extends CrudRepository<Color, Integer> {
	
}
