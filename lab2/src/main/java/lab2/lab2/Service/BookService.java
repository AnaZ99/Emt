package lab2.lab2.Service;

import lab2.lab2.Model.Author;
import lab2.lab2.Model.Book;
import lab2.lab2.Model.DTO.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto productDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    List<Author> findALlAuthors();


    public Book like(Long id);


}
