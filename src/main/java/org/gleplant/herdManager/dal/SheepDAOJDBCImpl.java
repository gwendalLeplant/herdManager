package org.gleplant.herdManager.dal;

import org.gleplant.herdManager.bo.Sheep;
import org.springframework.data.repository.CrudRepository;

public interface SheepDAOJDBCImpl extends CrudRepository<Sheep, Integer> {

}
