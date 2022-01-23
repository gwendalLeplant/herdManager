package org.gleplant.herdManager.bll;

import org.gleplant.herdManager.bo.Color;
import org.gleplant.herdManager.dal.ColorDAOJDBCImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ColorManager extends CrudManager<Color,ColorDAOJDBCImpl> {

}
