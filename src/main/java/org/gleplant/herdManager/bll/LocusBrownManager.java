package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.LocusBrown;
import org.gleplant.herdManager.dal.LocusBrownDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LocusBrownManager extends CrudManager<LocusBrown, LocusBrownDAOJDBCImpl> {

}
