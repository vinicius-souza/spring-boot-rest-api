package br.com.viniciussouza.spring_boot_rest_api.services;

import br.com.viniciussouza.spring_boot_rest_api.controllers.BookController;
import br.com.viniciussouza.spring_boot_rest_api.dtos.BookDTO;
import br.com.viniciussouza.spring_boot_rest_api.exception.RequiredObjectIsNullException;
import br.com.viniciussouza.spring_boot_rest_api.exception.ResourceNotFoundException;
import br.com.viniciussouza.spring_boot_rest_api.model.Book;
import br.com.viniciussouza.spring_boot_rest_api.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.map;
import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.mapList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class.getName());

    @Autowired
    BookRepository repository;


    public List<BookDTO> findAll() {

        logger.info("Finding all Books!");

        var bookList = mapList(repository.findAll(), BookDTO.class);

        return bookList.stream()
                .peek(BookService::addHateoasLinks)
                .toList();
    }

    public BookDTO findById(Long id) {
        logger.info("Finding one Book!");

        var bookFound = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        var bookDTO = map(bookFound, BookDTO.class);
        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public BookDTO create(BookDTO book) {

        if (book == null) {
            throw new RequiredObjectIsNullException();
        }

        logger.info("Creating one Book!");

        var bookDTO = map(repository.save(map(book, Book.class)), BookDTO.class);
        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public BookDTO update(BookDTO book) {

        if (book == null) {
            throw new RequiredObjectIsNullException();
        }

        logger.info("Updating one Book!");
        Book entity = repository.findById(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setPrice(book.getPrice());
        entity.setLaunchDate(book.getLaunchDate());

        var bookDTO = map(repository.save(entity), BookDTO.class);
        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public void delete(Long id) {

        logger.info("Deleting one Book!");

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }


    private static void addHateoasLinks(BookDTO bookDTO) {
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId()))
                .withSelfRel().withType("GET"));

        bookDTO.add(linkTo(methodOn(BookController.class).findAll())
                .withRel("findAll").withType("GET"));

        bookDTO.add(linkTo(methodOn(BookController.class).create(bookDTO))
                .withRel("create").withType("POST"));

        bookDTO.add(linkTo(methodOn(BookController.class).update(bookDTO))
                .withRel("update").withType("PUT"));

        bookDTO.add(linkTo(methodOn(BookController.class).delete(bookDTO.getId()))
                .withRel("delete").withType("DELETE"));
    }
}
