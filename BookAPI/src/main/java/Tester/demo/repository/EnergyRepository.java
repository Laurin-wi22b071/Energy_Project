package Tester.demo.repository;

import Tester.demo.dto.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnergyRepository {
    private Map<Integer, Book> booksyById = new HashMap<>(Map.of(
            1, new Book(1, "An unexpected Journey", "Fantasy"),
            2, new Book(2, "Harry Potter", "Trottel")
    ));

    public void saveBook(Book book) {
        booksyById.put(book.getTid(), book);
    }

    public Book findByTid(int tid) {
        return booksyById.get(tid);
    }

    public List<Book> findAll() {
        return booksyById.values().stream().toList();
    }

    public void deleteByTid(int tid) {
        booksyById.remove(tid);
    }

    public void updateByTid(int tid, Book book) {
        booksyById.put(tid, book);
    }


}
