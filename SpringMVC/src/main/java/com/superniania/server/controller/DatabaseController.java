package com.superniania.server.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.BeginState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.superniania.server.model.Location;
import com.superniania.server.service.DatabaseService;

@Controller
@Repository
@RequestMapping("/db")
public class DatabaseController {
	
	@Autowired
       DatabaseService databaseService;

/*	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	//public ResponseEntity<String> getMovie(@PathVariable String name, ModelMap model) {
	public @ResponseBody Auta getMovie(@PathVariable String name, ModelMap model) {
		
		model.addAttribute("movie", name);
		autaService.addAuto(2313, "toyota");
		List<Auta> auta= autaService.findAuto(name);
		return auta.get(0);
		//return new ResponseEntity<String>( "lala",HttpStatus.OK);

	}*/
	/*
	@RequestMapping(value="/{name}",method=RequestMethod.POST)
		public void create(@RequestBody @Valid Auta auta) {
			autaService.addAuto(auta.getId(), auta.getMarka());
			autaService.findAuto(auta.getMarka());
		}
	*/
	
	@RequestMapping(value="/saveLocation",method=RequestMethod.POST)
	public void create(@RequestBody @Valid Location location) {
		System.out.println("MAM COS****"+location.getLatitude());
		 databaseService.addAuto(location);
		//autaService.addAuto(auta.getId(), auta.getMarka());
	//	autaService.findAuto(auta.getMarka());
	}
}