package org.gleplant.herdManager.dal;

import java.util.List;

import org.gleplant.herdManager.bo.Sheep;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SheepDAOJDBCImpl extends CrudRepository<Sheep, Integer> {


	List<Sheep> findByRegistrationNumber(String regNumber);

	@Query("SELECT sh.registrationNumber FROM Sheep as sh")
	List<String> getAllRegistrationNumber();

}
