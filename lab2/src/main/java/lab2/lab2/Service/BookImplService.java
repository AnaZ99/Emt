package lab2.lab2.Service;

import lab2.lab2.ManufacturerNotFoundException;
import lab2.lab2.Model.Author;
import lab2.lab2.Model.Book;

import lab2.lab2.Model.DTO.BookDto;
import lab2.lab2.Repository.AuthorJpaRepository;
import lab2.lab2.Repository.BookJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImplService implements BookService {
    private final BookJpaRepository bookJpaRepository;
    private final AuthorJpaRepository authorJpaRepository;

    public BookImplService(BookJpaRepository bookJpaRepository, AuthorJpaRepository authorJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {

        return bookJpaRepository.findById(id);

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorJpaRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new ManufacturerNotFoundException(bookDto.getAuthor()));


        this.bookJpaRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookJpaRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookJpaRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
        Author author = this.authorJpaRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new ManufacturerNotFoundException(bookDto.getAuthor()));


        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookJpaRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookJpaRepository.deleteById(id);

    }

    @Override
    public List<Author> findALlAuthors() {
        return authorJpaRepository.findAll();
    }

    @Override

    public Book like(Long id) {

        Book e = bookJpaRepository.findById(id).orElse(null);

        int likes = e.getAvailableCopies();
        likes--;
        e.setAvailableCopies(likes);
        return bookJpaRepository.save(e);

    }
}
