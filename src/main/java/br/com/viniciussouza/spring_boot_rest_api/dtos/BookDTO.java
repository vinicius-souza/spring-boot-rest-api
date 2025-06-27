package br.com.viniciussouza.spring_boot_rest_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id", "address", "first_name", "last_name",  "gender"})
// @JsonFilter("PersonFilter") // to filter out fields during serialization
public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {

    private Long id;
    private String author;
    private String title;
    private Double price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date launchDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) && Objects.equals(author, bookDTO.author) && Objects.equals(title, bookDTO.title) && Objects.equals(price, bookDTO.price) && Objects.equals(launchDate, bookDTO.launchDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, author, title, price, launchDate);
    }
}
