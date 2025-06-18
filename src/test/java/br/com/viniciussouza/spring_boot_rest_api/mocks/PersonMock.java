package br.com.viniciussouza.spring_boot_rest_api.mocks;

import br.com.viniciussouza.spring_boot_rest_api.dtos.v1.PersonDTO;
import br.com.viniciussouza.spring_boot_rest_api.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMock {

    public Person mockPerson() {
        return mockEntity(0);
    }

    public PersonDTO mockPersonDTO() {
        return mockDTO(0);
    }

    public List<Person> mockPersonList() {
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            list.add(mockEntity(i));
        }
        return list;
    }

    public List<PersonDTO> mockPersonDTOList() {
        List<PersonDTO> list = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            list.add(mockDTO(i));
        }
        return list;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setId(number.longValue());
        person.setFirstName("First Name " + number);
        person.setLastName("Last Name " + number);
        person.setAddress("Address " + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");

        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(number.longValue());
        personDTO.setFirstName("First Name " + number);
        personDTO.setLastName("Last Name " + number);
        personDTO.setAddress("Address " + number);
        personDTO.setGender(((number % 2) == 0) ? "Male" : "Female");

        return personDTO;
    }
}
