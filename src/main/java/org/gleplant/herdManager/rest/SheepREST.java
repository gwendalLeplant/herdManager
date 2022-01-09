package org.gleplant.herdManager.rest;

import java.util.List;

import org.gleplant.herdManager.bll.SheepManager;
import org.gleplant.herdManager.bo.Sheep;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("sheep")
public class SheepREST {

	@GET
	public List<Sheep> getNotes() {
		return SheepManager.selectAll();
	}

	@GET
	@Path("/{id:\\d+}")
	public Sheep getNoteById(@PathParam("id") int id) {
		return SheepManager.selectById(id);
	}

	@POST
	public Sheep insertSheep(@FormParam("content") String content) {
		Sheep sheepToInsert = new Sheep();
		// TODO code the form treatment
		return SheepManager.insert(sheepToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Sheep updateSheep(@PathParam("id") int id, @FormParam("content") String content) {
		Sheep sheepToUpdate = SheepManager.selectById(id);
		// TODO code the form treatment
		return SheepManager.update(sheepToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Sheep deleteSheepById(@PathParam("id") int id) {
		return SheepManager.delete(SheepManager.selectById(id));
	}
}
