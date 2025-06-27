package br.com.viniciussouza.spring_boot_rest_api.controllers;

import br.com.viniciussouza.spring_boot_rest_api.controllers.docs.BookControllerDocs;
import br.com.viniciussouza.spring_boot_rest_api.dtos.BookDTO;
import br.com.viniciussouza.spring_boot_rest_api.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/v1/book")
@Tag(name = "Book", description = "Endpoints for managing books")
public class BookController implements BookControllerDocs {

    @Autowired
    private BookService service;


    @GetMapping(produces = {
            APPLICATION_JSON_VALUE,
            APPLICATION_XML_VALUE,
            APPLICATION_YAML_VALUE})
    @Override
    public List<BookDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {
                    APPLICATION_JSON_VALUE,
                    APPLICATION_XML_VALUE,
                    APPLICATION_YAML_VALUE}
    )
    @Override
    public BookDTO findById(@PathVariable("id") Long id) {
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
    @Override
    public BookDTO create(@RequestBody BookDTO book) {
        return service.create(book);
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
    @Override
    public BookDTO update(@RequestBody BookDTO book) {
        return service.update(book);
    }


    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
