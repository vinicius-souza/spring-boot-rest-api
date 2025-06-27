package br.com.viniciussouza.spring_boot_rest_api.services;

import br.com.viniciussouza.spring_boot_rest_api.exception.RequiredObjectIsNullException;
import br.com.viniciussouza.spring_boot_rest_api.mocks.BookMock;
import br.com.viniciussouza.spring_boot_rest_api.model.Book;
import br.com.viniciussouza.spring_boot_rest_api.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
class BookServiceTest {

    BookMock input;

    @InjectMocks
    BookService service;

    @Mock
    BookRepository repository;

    @BeforeEach
    void setUp() {
        input = new BookMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        List<Book> bookList = input.mockBookList();

        when(repository.findAll()).thenReturn(bookList);

        var result = service.findAll();

        assertNotNull(result);
        assertEquals(14, result.size());


        var bookOne = result.get(1);
        assertNotNull(bookOne.getLinks());

        assertEquals("Title 1",bookOne.getTitle());
        assertEquals("Author 1",bookOne.getAuthor());
        assertEquals(1D,bookOne.getPrice());
        assertEquals(new GregorianCalendar(2024, Calendar.JULY, 2).getTime(),bookOne.getLaunchDate());

        assertTrue(bookOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(bookOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("GET"))
        );

        assertTrue(bookOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("POST"))
        );

        assertTrue(bookOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(bookOne.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("PUT"))
        );


        var bookFour = result.get(4);
        assertNotNull(bookFour.getLinks());

        assertEquals("Title 4",bookFour.getTitle());
        assertEquals("Author 4",bookFour.getAuthor());
        assertEquals(4D,bookFour.getPrice());
        assertEquals(new GregorianCalendar(2024, Calendar.JULY, 2).getTime(),bookFour.getLaunchDate());

        assertTrue(bookFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/book/4")
                                && link.getType().equals("GET"))
        );

        assertTrue(bookFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("GET"))
        );

        assertTrue(bookFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("POST"))
        );

        assertTrue(bookFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/book/4")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(bookFour.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("PUT"))
        );

        var bookSeven = result.get(7);
        assertNotNull(bookSeven.getLinks());

        assertEquals("Title 7",bookSeven.getTitle());
        assertEquals("Author 7",bookSeven.getAuthor());
        assertEquals(7D,bookSeven.getPrice());
        assertEquals(new GregorianCalendar(2024, Calendar.JULY, 2).getTime(),bookSeven.getLaunchDate());

        assertTrue(bookSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/book/7")
                                && link.getType().equals("GET"))
        );

        assertTrue(bookSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("GET"))
        );

        assertTrue(bookSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("POST"))
        );

        assertTrue(bookSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/book/7")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(bookSeven.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void findById() {
        Book book = input.mockBook();

        when(repository.findById(1L)).thenReturn(Optional.of(book));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertEquals("Title 1",result.getTitle());
        assertEquals("Author 1",result.getAuthor());
        assertEquals(1D,result.getPrice());
        assertEquals(new GregorianCalendar(2024, Calendar.JULY, 2).getTime(),result.getLaunchDate());

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("POST"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void create() {
        Book book = input.mockBook();

        when(repository.save(book)).thenReturn(book);

        var result = service.create(input.mockBookDTO());

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertEquals("Title 1",result.getTitle());
        assertEquals("Author 1",result.getAuthor());
        assertEquals(1D,result.getPrice());
        assertEquals(new GregorianCalendar(2024, Calendar.JULY, 2).getTime(),result.getLaunchDate());

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("POST"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void update() {
        Book book = input.mockBook();

        when(repository.findById(1L)).thenReturn(Optional.of(book));
        when(repository.save(book)).thenReturn(book);

        var result = service.update(input.mockBookDTO());

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        assertEquals("Title 1",result.getTitle());
        assertEquals("Author 1",result.getAuthor());
        assertEquals(1D,result.getPrice());
        assertEquals(new GregorianCalendar(2024, Calendar.JULY, 2).getTime(),result.getLaunchDate());

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("self")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("findAll")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("GET"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("create")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("POST"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("delete")
                                && link.getHref().endsWith("api/v1/book/1")
                                && link.getType().equals("DELETE"))
        );

        assertTrue(result.getLinks()
                .stream()
                .anyMatch(link ->
                        link.getRel().value().equals("update")
                                && link.getHref().endsWith("api/v1/book")
                                && link.getType().equals("PUT"))
        );
    }

    @Test
    void delete() {
        Book book = input.mockBook();

        when(repository.findById(1L)).thenReturn(Optional.of(book));

        service.delete(1L);

        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(Book.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void createWithNullBook() {
        var exception = assertThrows(
                RequiredObjectIsNullException.class,
                () -> service.create(null)
        );

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected message to contain: " + expectedMessage);
    }

    @Test
    void updateWithNullBook() {
        var exception = assertThrows(
                RequiredObjectIsNullException.class,
                () -> service.update(null)
        );

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Expected message to contain: " + expectedMessage);
    }
}