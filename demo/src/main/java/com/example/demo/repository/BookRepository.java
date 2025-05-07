package com.example.demo.repository;


import com.example.demo.dto.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookRepository {
    private Map<Integer, Book> booksById = new HashMap<>(Map.of(
            1, new Book(1, "An unexpected Journey", "Fantasy"),
            2, new Book(2, "Lord of the Rings", "Fantasy")
    ));

    public void saveBook(Book book) {
        booksById.put(book.getId(), book);
    }

    public Book findbyId(int id) {
        return booksById.get(id);
    }

    public List<Book> findAll() {
        return booksById.values().stream().toList();
    }

    public void deleteBook(int id) {
        booksById.remove(id);
    }

    public void updateBook(int id, Book book) {
        booksById.put(id, book);
    }
}
