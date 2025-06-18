package br.com.viniciussouza.spring_boot_rest_api.services;

import br.com.viniciussouza.spring_boot_rest_api.dtos.v1.PersonDTO;
import br.com.viniciussouza.spring_boot_rest_api.dtos.v2.PersonDTOV2;
import br.com.viniciussouza.spring_boot_rest_api.exception.ResourceNotFoundException;
import br.com.viniciussouza.spring_boot_rest_api.mapper.custom.PersonMapper;
import br.com.viniciussouza.spring_boot_rest_api.model.Person;
import br.com.viniciussouza.spring_boot_rest_api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.map;
import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.mapList;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper personMapper;


    public List<PersonDTO> findAll() {

        logger.info("Finding all People!");

        return mapList(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var personFound = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return map(personFound, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Creating one Person!");

        return map(repository.save(map(person, Person.class)), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {

        logger.info("Creating one Person V2!");

        return personMapper.personToPersonDTOV2(repository.save(personMapper.personDTOV2ToPerson(person)));
    }

    public PersonDTO update(PersonDTO person) {

        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return map(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
