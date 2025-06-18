package br.com.viniciussouza.spring_boot_rest_api.mapper.custom;

import br.com.viniciussouza.spring_boot_rest_api.dtos.v2.PersonDTOV2;
import br.com.viniciussouza.spring_boot_rest_api.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 personToPersonDTOV2(Person person) {
        if (person == null) {
            return null;
        }

        PersonDTOV2 personDTOV2 = new PersonDTOV2();
        personDTOV2.setId(person.getId());
        personDTOV2.setFirstName(person.getFirstName());
        personDTOV2.setLastName(person.getLastName());
        personDTOV2.setAddress(person.getAddress());
        personDTOV2.setGender(person.getGender());
        personDTOV2.setBirthDay(new Date());

        return personDTOV2;
    }

    public Person personDTOV2ToPerson(PersonDTOV2 personDTOV2) {
        if (personDTOV2 == null) {
            return null;
        }

        Person person = new Person();
        person.setId(personDTOV2.getId());
        person.setFirstName(personDTOV2.getFirstName());
        person.setLastName(personDTOV2.getLastName());
        person.setAddress(personDTOV2.getAddress());
        person.setGender(personDTOV2.getGender());
//        person.setBirthDay(new Date());


        return person;
    }
}
