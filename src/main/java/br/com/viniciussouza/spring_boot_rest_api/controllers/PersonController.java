package br.com.viniciussouza.spring_boot_rest_api.controllers;

import br.com.viniciussouza.spring_boot_rest_api.dtos.PersonDTO;
import br.com.viniciussouza.spring_boot_rest_api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.APPLICATION_YAML_VALUE;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {
            APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE,
            APPLICATION_YAML_VALUE})
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {
                    APPLICATION_JSON_VALUE,
                    APPLICATION_XML_VALUE,
                    APPLICATION_YAML_VALUE}
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = {
                    APPLICATION_JSON_VALUE,
                    APPLICATION_XML_VALUE,
                    APPLICATION_YAML_VALUE},
            produces = {
                    APPLICATION_JSON_VALUE,
                    APPLICATION_XML_VALUE,
                    APPLICATION_YAML_VALUE}
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(
            consumes = {
                    APPLICATION_JSON_VALUE,
                    APPLICATION_XML_VALUE,
                    APPLICATION_YAML_VALUE},
            produces = {
                    APPLICATION_JSON_VALUE,
                    APPLICATION_XML_VALUE,
                    APPLICATION_YAML_VALUE}
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
