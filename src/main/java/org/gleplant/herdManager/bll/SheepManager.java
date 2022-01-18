package org.gleplant.herdManager.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.gleplant.herdManager.bo.Sheep;
import org.gleplant.herdManager.dal.SheepDAOJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SheepManager {
	
	@Autowired
	SheepDAOJDBCImpl sheepDAO;
	
	@Transactional
	public List<Sheep> selectAll() {
		return (List<Sheep>)sheepDAO.findAll();
	}
	
	@Transactional
	public Sheep selectById(Integer id) {
		return sheepDAO.findById(id).orElse(null);
	}
	
	@Transactional
	public Sheep insert(Sheep sheepToInsert) {
		return sheepDAO.save(sheepToInsert);
	}
	
	@Transactional
	public Sheep update(Sheep sheepToUpdate) {
		return sheepDAO.save(sheepToUpdate);
	}

	@Transactional
	public Sheep delete(Sheep sheepToDelete) {
		sheepDAO.delete(sheepToDelete);
		return sheepToDelete;
				
	}
}
