package org.gleplant.herdManager.bll;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.gleplant.herdManager.bo.Genealogy;
import org.gleplant.herdManager.bo.Sheep;
import org.gleplant.herdManager.dal.SheepDAOJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SheepManager extends CrudManager<Sheep,SheepDAOJDBCImpl>{

	@Autowired
	SheepDAOJDBCImpl sheepDAO;

	@Transactional
	public List<Sheep> selectByRegistrationNumber(String regNumber) {
		return (List<Sheep>) sheepDAO.findByRegistrationNumber(regNumber);
	}

	@Transactional
	public Genealogy getGenealogy(Sheep sh) {
		Genealogy gen = new Genealogy();
		gen.setChild(sh);
		if (sh.getFatherRegistrationNumber() != null && sh.getFatherRegistrationNumber() != "UNKNOWN") {
			// TODO Purge database from doublons
			List<Sheep> lst = selectByRegistrationNumber(sh.getFatherRegistrationNumber());
			gen.setFather(lst.get(0));
		} else {
			gen.setFather(null);
		}
		if (sh.getMotherRegistrationNumber() != null && sh.getMotherRegistrationNumber() != "UNKNOWN") {
			// TODO Purge database from doublons
			List<Sheep> lst = selectByRegistrationNumber(sh.getMotherRegistrationNumber());
			gen.setMother(lst.get(0));
		} else {
			gen.setMother(null);
		}
		return gen;
	}

	@Transactional
//	public List<Sheep> getGenealogyOnNGeneration(Sheep sh, Integer nbGenerations) {		
//		List<Sheep> listGen = new ArrayList<Sheep>();
//		Sheep sheepNode = sh;
//		Genealogy sheepNodeGenealogy;
//		// For each generations
//		listGen.add(sheepNode);
//		for (int i = 0; i < nbGenerations; i++) {
//			int nbGenealogyToFind = (int) (Math.pow(2, i));
//			// For each individual in a generation
//			for (int j = 0; j < nbGenealogyToFind; j++) {
//				// Get genealogy for the new sheep node
//				sheepNodeGenealogy = getGenealogy(sheepNode);
//				// Add this genealogy to the list to return
//				listGen.add(sheepNodeGenealogy.getFather());
//				listGen.add(sheepNodeGenealogy.getMother());
//				sheepNode = listGen.get(listGen.size()-1-nbGenealogyToFind+j);				
//			}
//		}
//		return listGen;
//	}

	public List<Genealogy> getGenealogyOnNGeneration(Sheep sh, Integer nbGenerations) {		
	List<Genealogy> listGen = new ArrayList<Genealogy>();
	Sheep sheepNode = sh;
	Genealogy sheepNodeGenealogy = getGenealogy(sheepNode);
	// For each generations
	listGen.add(sheepNodeGenealogy);
	for (int i = 0; i < nbGenerations; i++) {
		int nbGenealogyToFind = (int) (Math.pow(2, i));
		// For each individual in a generation
		for (int j = 0; j < nbGenealogyToFind; j++) {
			// Get genealogy for the new sheep node
			sheepNodeGenealogy = getGenealogy(sheepNode);
			// Add this genealogy to the list to return
			listGen.add(getGenealogy(sheepNodeGenealogy.getFather()));
			listGen.add(getGenealogy(sheepNodeGenealogy.getMother()));
			sheepNode = listGen.get(listGen.size()-1-nbGenealogyToFind+j).getChild();				
		}
	}
	return listGen;
}
	
	public List<String> getAllRegistrationNumber() {
		return sheepDAO.getAllRegistrationNumber();
	}
}
