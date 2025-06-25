package br.com.viniciussouza.spring_boot_rest_api.services;

import br.com.viniciussouza.spring_boot_rest_api.controllers.PersonController;
import br.com.viniciussouza.spring_boot_rest_api.dtos.PersonDTO;
import br.com.viniciussouza.spring_boot_rest_api.exception.ResourceNotFoundException;
import br.com.viniciussouza.spring_boot_rest_api.model.Person;
import br.com.viniciussouza.spring_boot_rest_api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.map;
import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.mapList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;


    public List<PersonDTO> findAll() {

        logger.info("Finding all People!");

        var personList = mapList(repository.findAll(), PersonDTO.class);

        return personList.stream()
                .peek(PersonService::addHateoasLinks)
                .toList();
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var personFound = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var personDTO = map(personFound, PersonDTO.class);
        addHateoasLinks(personDTO);

        return personDTO;
    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");

        var personDTO = map(repository.save(map(person, Person.class)), PersonDTO.class);
        addHateoasLinks(personDTO);

        return personDTO;
    }

    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var personDTO = map(repository.save(entity), PersonDTO.class);
        addHateoasLinks(personDTO);

        return personDTO;
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }


    private static void addHateoasLinks(PersonDTO personDTO) {
        personDTO.add(linkTo(methodOn(PersonController.class).findById(personDTO.getId()))
                .withSelfRel().withType("GET"));

        personDTO.add(linkTo(methodOn(PersonController.class).findAll())
                .withRel("findAll").withType("GET"));

        personDTO.add(linkTo(methodOn(PersonController.class).create(personDTO))
                .withRel("create").withType("POST"));

        personDTO.add(linkTo(methodOn(PersonController.class).update(personDTO))
                .withRel("update").withType("PUT"));

        personDTO.add(linkTo(methodOn(PersonController.class).delete(personDTO.getId()))
                .withRel("delete").withType("DELETE"));
    }
}
