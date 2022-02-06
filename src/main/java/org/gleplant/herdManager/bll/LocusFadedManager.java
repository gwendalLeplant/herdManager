package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.LocusFaded;
import org.gleplant.herdManager.dal.LocusFadedDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LocusFadedManager extends CrudManager<LocusFaded, LocusFadedDAOJDBCImpl> {

}
