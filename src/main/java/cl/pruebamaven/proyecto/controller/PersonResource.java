package cl.pruebamaven.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.pruebamaven.proyecto.model.Person;

@RestController
@RequestMapping
public class PersonResource {

	@RequestMapping(method = RequestMethod.GET, value = "/people")
	public List<Person> getPeople() {
		return new ArrayList<Person>();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/people/{id}")
	public Person getPerson(@PathVariable("id") Integer id) {
		return new Person();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/people")
	public void setPerson(@RequestBody Person person) {
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/people/{id}")
	public void updatePerson(@RequestBody Person person, @PathVariable("id") Integer id) {
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/people/{id}")
	public void deletePerson(@PathVariable("id") Integer id) {
	}
}
