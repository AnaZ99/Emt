package lab2.lab2.WebRestControllers;

import lab2.lab2.Model.Author;
import lab2.lab2.Model.Book;
import lab2.lab2.Service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorControllerRestAPi {

    private final BookService bookService;

    public AuthorControllerRestAPi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Author> findAll() {
       List<Author> authors= this.bookService.findALlAuthors();

       return authors;


    }
}
