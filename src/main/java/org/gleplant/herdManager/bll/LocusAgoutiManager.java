package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.LocusAgouti;
import org.gleplant.herdManager.dal.LocusAgoutiDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LocusAgoutiManager extends CrudManager<LocusAgouti, LocusAgoutiDAOJDBCImpl> {

}
