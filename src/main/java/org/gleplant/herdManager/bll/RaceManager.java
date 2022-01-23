package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.Race;
import org.gleplant.herdManager.dal.RaceDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RaceManager extends CrudManager<Race, RaceDAOJDBCImpl> {

}
