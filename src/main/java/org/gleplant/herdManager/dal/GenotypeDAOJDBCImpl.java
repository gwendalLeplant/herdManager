package org.gleplant.herdManager.dal;

import org.gleplant.herdManager.bo.Genotype;
import org.springframework.data.repository.CrudRepository;

public interface GenotypeDAOJDBCImpl extends CrudRepository<Genotype, Integer> {

}
