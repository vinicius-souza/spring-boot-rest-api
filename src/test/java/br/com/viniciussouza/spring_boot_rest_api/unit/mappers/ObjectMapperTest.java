package br.com.viniciussouza.spring_boot_rest_api.unit.mappers;

import br.com.viniciussouza.spring_boot_rest_api.dtos.v1.PersonDTO;
import br.com.viniciussouza.spring_boot_rest_api.mocks.PersonMock;
import br.com.viniciussouza.spring_boot_rest_api.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.map;
import static br.com.viniciussouza.spring_boot_rest_api.mapper.ObjectMapper.mapList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperTest {
    PersonMock inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new PersonMock();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = map(inputObject.mockPerson(), PersonDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name 0", output.getFirstName());
        assertEquals("Last Name 0", output.getLastName());
        assertEquals("Address 0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = mapList(inputObject.mockPersonList(), PersonDTO.class);
        PersonDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name 0", outputZero.getFirstName());
        assertEquals("Last Name 0", outputZero.getLastName());
        assertEquals("Address 0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());

        PersonDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name 7", outputSeven.getFirstName());
        assertEquals("Last Name 7", outputSeven.getLastName());
        assertEquals("Address 7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());

        PersonDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name 12", outputTwelve.getFirstName());
        assertEquals("Last Name 12", outputTwelve.getLastName());
        assertEquals("Address 12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseDTOToEntityTest() {
        Person output = map(inputObject.mockPersonDTO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name 0", output.getFirstName());
        assertEquals("Last Name 0", output.getLastName());
        assertEquals("Address 0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = mapList(inputObject.mockPersonDTOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name 0", outputZero.getFirstName());
        assertEquals("Last Name 0", outputZero.getLastName());
        assertEquals("Address 0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name 7", outputSeven.getFirstName());
        assertEquals("Last Name 7", outputSeven.getLastName());
        assertEquals("Address 7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name 12", outputTwelve.getFirstName());
        assertEquals("Last Name 12", outputTwelve.getLastName());
        assertEquals("Address 12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
}