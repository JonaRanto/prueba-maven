package cl.pruebamaven.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.pruebamaven.proyecto.model.Person;
import cl.pruebamaven.proyecto.repository.PersonRepository;

@RestController // Indica que la clase es un controlador
@RequestMapping(path = "/api") // Esto indica que despues de la ruta de la app, la URL comienza con /api
public class PersonResource {

	@Autowired // Esto significa obtener el bean userRepository generado automaticamente por
				// Spring para manejar los datos
	private PersonRepository personRepository;

	@GetMapping(path = "/people") // Asignar solo solicitudes GET
	public @ResponseBody Iterable<Person> getPeople() {
		// Esto retorna un JSON o XML de las personas
		return personRepository.findAll();
	}

	@GetMapping(path = "/person/{id}")
	public @ResponseBody Optional<Person> getPerson(@PathVariable("id") Integer id) {
		return personRepository.findById(id);
	}

	@PostMapping(path = "/person") // Asignar solo solicitudes POST
	public @ResponseBody String setPerson(@RequestBody Person person) {
		personRepository.save(person);
		return "Agregado!";
	}

	@PutMapping(path = "/person/{id}") // Asignar solo solicitudes PUT
	public @ResponseBody String updatePerson(@RequestBody Person person, @PathVariable("id") Integer id) {
		person.setId(id);
		personRepository.save(person);
		return "Modificado!";
	}

	@DeleteMapping(path = "/person/{id}") // Asignar solo solicitudes DELETE
	public @ResponseBody String deletePerson(@PathVariable("id") Integer id) {
		personRepository.deleteById(id);
		return "Eliminado!";
	}

}
