package lab2.lab2.Model.DTO;

import lab2.lab2.Model.Author;
import lab2.lab2.Model.Type;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
@Data
public class BookDto {
    String name;

    @Enumerated(value = EnumType.STRING)
    Type category;

    Long author;
    int availableCopies;

    public BookDto(String name, Type category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }

    public String getName() {
        return name;
    }

    public Type getCategory() {
        return category;
    }

    public Long getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Type category) {
        this.category = category;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
