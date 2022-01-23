package org.gleplant.herdManager.rest;

import java.util.List;

import org.gleplant.herdManager.bll.SheepManager;
import org.gleplant.herdManager.bo.Sheep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SheepREST {

	@Autowired
	SheepManager sheepManager;
	
	@GetMapping("WS/sheep")
	public List<Sheep> getNotes() {
		return sheepManager.selectAll();
	}

	@GetMapping("WS/sheep/{id}")
	public Sheep getNoteById(@PathVariable("id") int id) {
		return sheepManager.selectById(id);
	}
	
	@GetMapping("WS/sheep/genealogy/{id}")
	public List<Sheep> getGenealogyById(@PathVariable("id") int id) {
		return sheepManager.getGenealogyOnNGeneration(sheepManager.selectById(id), 5);
	}


	@PostMapping("WS/sheep")
	public Sheep insertSheep(@RequestBody Sheep sheepToInsert) throws Exception {
		return sheepManager.insert(sheepToInsert);
	}

	@PutMapping("WS/sheep")
	public Sheep updateSheep(@RequestBody Sheep sheepToUpdate) throws Exception {
		return sheepManager.update(sheepToUpdate);
	}


	@DeleteMapping("WS/sheep/{id}")
	public Sheep deleteSheepById(@PathVariable("id") int id) {
		return sheepManager.delete(sheepManager.selectById(id));
	}
}
