package br.com.viniciussouza.spring_boot_rest_api.mocks;

import br.com.viniciussouza.spring_boot_rest_api.dtos.BookDTO;
import br.com.viniciussouza.spring_boot_rest_api.model.Book;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BookMock {

    public Book mockBook() {
        return mockEntity(1);
    }

    public BookDTO mockBookDTO() {
        return mockDTO(1);
    }

    public List<Book> mockBookList() {
        List<Book> list = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            list.add(mockEntity(i));
        }
        return list;
    }

    public List<BookDTO> mockBookDTOList() {
        List<BookDTO> list = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            list.add(mockDTO(i));
        }
        return list;
    }

    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setTitle("Title " + number);
        book.setAuthor("Author " + number);
        book.setPrice(number.doubleValue());
        book.setLaunchDate(new GregorianCalendar(2024, Calendar.JULY, 2).getTime());

        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(number.longValue());
        bookDTO.setTitle("Title " + number);
        bookDTO.setAuthor("Author " + number);
        bookDTO.setPrice(number.doubleValue());
        bookDTO.setLaunchDate(new GregorianCalendar(2024, Calendar.JULY, 2).getTime());

        return bookDTO;
    }
}
