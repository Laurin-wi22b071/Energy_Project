package Tester.demo.Controller;

import Tester.demo.dto.Book;
import Tester.demo.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks(
            @RequestParam(value="search", defaultValue = "") String search,
            @RequestParam(value="sort", defaultValue = "name") String sort

    ) {
        return this.bookRepository.findAll().stream().filter(book -> book.getName().toLowerCase().contains(search.toLowerCase())).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createBook(@RequestBody Book book) {
        this.bookRepository.saveBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookByID(@PathVariable int id) {
        if(id < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID cannot be less than 0");
        }
        Book book = this.bookRepository.findByTid(id);
        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + id + " does not exist");
        }

        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBookByID(@PathVariable int id) {
        this.bookRepository.deleteByTid(id);
    }

    @PutMapping("/{id}")
    public void updateBookByID(@PathVariable int id, @RequestBody Book book) {
        this.bookRepository.updateByTid(id, book);
    }

}
