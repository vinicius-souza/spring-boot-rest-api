package br.com.viniciussouza.spring_boot_rest_api.repositories;

import br.com.viniciussouza.spring_boot_rest_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
