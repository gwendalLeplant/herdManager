package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.LocusSpotted;
import org.gleplant.herdManager.dal.LocusSpottedDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LocusSpottedManager extends CrudManager<LocusSpotted, LocusSpottedDAOJDBCImpl> {

}
