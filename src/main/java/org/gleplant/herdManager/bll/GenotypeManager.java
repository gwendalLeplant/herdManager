package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.Genotype;
import org.gleplant.herdManager.dal.GenotypeDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GenotypeManager extends CrudManager<Genotype,GenotypeDAOJDBCImpl> {

}
