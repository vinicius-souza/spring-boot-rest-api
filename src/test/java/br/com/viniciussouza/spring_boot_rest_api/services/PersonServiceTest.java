package br.com.viniciussouza.spring_boot_rest_api.services;

import br.com.viniciussouza.spring_boot_rest_api.exception.RequiredObjectIsNullException;
import br.com.viniciussouza.spring_boot_rest_api.mocks.PersonMock;
import br.com.viniciussouza.spring_boot_rest_api.model.Person;
import br.com.viniciussouza.spring_boot_rest_api.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    PersonMock input;

    @InjectMocks
    PersonService service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() {
        input = new PersonMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        List<Person> personList = input.mockPersonList();

        when(repository.findAll()).thenReturn(personList);

        var result = service.findAll();

        assertNotNull(result);
        assertEquals(14, result.size());


        var personOne = result.get(1);
        assertNotNull(personOne.getLinks());

        assertEquals("First Name 1",personOne.getFirstName());
        assertEquals("Last Name 1",personOne.getLastName());
        assertEquals("Address 1",personOne.getAddress());
        assertEquals("Female",personOne.getGender());

        assertTrue(personOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(personOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("GET"))
        );

        assertTrue(personOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("POST"))
        );

        assertTrue(personOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(personOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("PUT"))
        );


        var personFour = result.get(4);
        assertNotNull(personFour.getLinks());

        assertEquals("First Name 4",personFour.getFirstName());
        assertEquals("Last Name 4",personFour.getLastName());
        assertEquals("Address 4",personFour.getAddress());
        assertEquals("Male",personFour.getGender());

        assertTrue(personFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/person/4")
                                && link.getType().equals("GET"))
        );

        assertTrue(personFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("GET"))
        );

        assertTrue(personFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("POST"))
        );

        assertTrue(personFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/person/4")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(personFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("PUT"))
        );

        var personSeven = result.get(7);
        assertNotNull(personSeven.getLinks());

        assertEquals("First Name 7",personSeven.getFirstName());
        assertEquals("Last Name 7",personSeven.getLastName());
        assertEquals("Address 7",personSeven.getAddress());
        assertEquals("Female",personSeven.getGender());

        assertTrue(personSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/person/7")
                                && link.getType().equals("GET"))
        );

        assertTrue(personSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("GET"))
        );

        assertTrue(personSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("POST"))
        );

        assertTrue(personSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/person/7")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(personSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void findById() {
        Person person = input.mockPerson();

        when(repository.findById(1L)).thenReturn(Optional.of(person));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertEquals("First Name 1",result.getFirstName());
        assertEquals("Last Name 1",result.getLastName());
        assertEquals("Address 1",result.getAddress());
        assertEquals("Female",result.getGender());

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("POST"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void create() {
        Person person = input.mockPerson();

        when(repository.save(person)).thenReturn(person);

        var result = service.create(input.mockPersonDTO());

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertEquals("First Name 1",result.getFirstName());
        assertEquals("Last Name 1",result.getLastName());
        assertEquals("Address 1",result.getAddress());
        assertEquals("Female",result.getGender());

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("POST"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void update() {
        Person person = input.mockPerson();

        when(repository.findById(1L)).thenReturn(Optional.of(person));
        when(repository.save(person)).thenReturn(person);

        var result = service.update(input.mockPersonDTO());

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertEquals("First Name 1",result.getFirstName());
        assertEquals("Last Name 1",result.getLastName());
        assertEquals("Address 1",result.getAddress());
        assertEquals("Female",result.getGender());

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("POST"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/person/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/person")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void delete() {
        Person person = input.mockPerson();

        when(repository.findById(1L)).thenReturn(Optional.of(person));

        service.delete(1L);

        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(Person.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void createWithNullPerson() {
        var exception = assertThrows(
                RequiredObjectIsNullException.class,
                () -> service.create(null)
        );

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected message to contain: " + expectedMessage);
    }

    @Test
    void updateWithNullPerson() {
        var exception = assertThrows(
                RequiredObjectIsNullException.class,
                () -> service.update(null)
        );

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected message to contain: " + expectedMessage);
    }
}