package lab2.lab2.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    @ManyToOne
    Country country;

    public Author(String name, String surname, Country country) {

        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {
    }
}
