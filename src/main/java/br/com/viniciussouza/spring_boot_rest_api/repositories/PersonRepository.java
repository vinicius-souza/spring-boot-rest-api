package br.com.viniciussouza.spring_boot_rest_api.repositories;

import br.com.viniciussouza.spring_boot_rest_api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
