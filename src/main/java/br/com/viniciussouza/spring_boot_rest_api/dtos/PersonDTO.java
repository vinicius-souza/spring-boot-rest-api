package br.com.viniciussouza.spring_boot_rest_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id", "address", "first_name", "last_name",  "gender"})
// @JsonFilter("PersonFilter") // to filter out fields during serialization
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //@JsonProperty("first_name")
    private String firstName;

    //@JsonProperty("last_name")
    private String lastName;
    private String address;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;

    //@JsonIgnore // to ignore the field in serialization
    //@JsonInclude(JsonInclude.Include.NON_NULL) // to not include the field if it is null
    //@JsonInclude(JsonInclude.Include.NON_EMPTY) // to not include the field if it is empty
    //@JsonSerialize(using = GenderSerializer.class)
    private String gender;

    private String sensitiveData; // Example of a field that could be filtered out

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public Date getBirthDay() { return birthDay; }

    public void setBirthDay(Date birthDay) { this.birthDay = birthDay; }


    public String getSensitiveData() { return sensitiveData; }

    public void setSensitiveData(String sensitiveData) { this.sensitiveData = sensitiveData; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName, personDTO.firstName)
                && Objects.equals(lastName, personDTO.lastName)
                && Objects.equals(address, personDTO.address)
                && Objects.equals(birthDay, personDTO.birthDay)
                && Objects.equals(gender, personDTO.gender)
                && Objects.equals(sensitiveData, personDTO.sensitiveData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, birthDay, gender, sensitiveData);
    }
}

