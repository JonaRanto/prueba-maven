package cl.pruebamaven.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import cl.pruebamaven.proyecto.model.Person;

//Esto será AUTO IMPLEMENTADO por Spring en un Bean llamado personRepository

public interface  PersonRepository extends CrudRepository<Person, Integer> {

}
