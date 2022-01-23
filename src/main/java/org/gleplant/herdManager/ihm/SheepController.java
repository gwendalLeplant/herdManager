package org.gleplant.herdManager.ihm;

import javax.validation.Valid;

import org.gleplant.herdManager.bll.ColorManager;
import org.gleplant.herdManager.bll.GenotypeManager;
import org.gleplant.herdManager.bll.PersonManager;
import org.gleplant.herdManager.bll.RaceManager;
import org.gleplant.herdManager.bll.SheepManager;
import org.gleplant.herdManager.bo.Sheep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SheepController {

	@Autowired
	SheepManager sheepManager;
	
	@Autowired 
	ColorManager colorManager;
	
	@Autowired
	RaceManager raceManager;
	
	@Autowired
	PersonManager personManager;
	
	@Autowired
	GenotypeManager genotypeManager;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("lstSheep",sheepManager.selectAll());
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Model model,Sheep sheep) {
		model.addAttribute("id",0); 
		model.addAttribute("mode","add");
		model.addAttribute("lstSheep",sheepManager.selectAll());
		model.addAttribute("lstRace",raceManager.selectAll());
		model.addAttribute("lstPerson",personManager.selectAll());
		model.addAttribute("lstGenotype",genotypeManager.selectAll());
		model.addAttribute("lstColor",colorManager.selectAll());
		return "form";
	}
	
	@GetMapping("/modify/{id}")
	public String modify(Model model,@PathVariable("id") Integer id, Sheep sheep) {
		sheep = sheepManager.selectById(id); 
		model.addAttribute("mode","modify");
		model.addAttribute("module",sheep); 
		model.addAttribute("id",id);
		return "form";
	}

	@GetMapping("/show/{id}")
	public String show(Model model,@PathVariable("id") Integer id) {
		Sheep sheep = sheepManager.selectById(id);
		model.addAttribute("sheep",sheep);
		model.addAttribute("sheepGenealogy",sheepManager.getGenealogyOnNGeneration(sheep, 5));
		model.addAttribute("mode","show");
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		sheepManager.delete(sheepManager.selectById(id));
		return "redirect:/index";
	}

	@PostMapping("/valid/{mode}/{id}")
	public String valid(Model model, @Valid Sheep sheep, BindingResult result, @PathVariable String mode, @PathVariable Integer id) throws Exception {
		if(result.hasErrors()) {
			return "form";
		}
		if("add".equals(mode)) {
			sheepManager.insert(sheep);
		}
		else if("modify".equals(mode)) {
			sheep.setSheepId(id); 
			sheepManager.update(sheep);
		}
		return "redirect:/index";
	}
}
