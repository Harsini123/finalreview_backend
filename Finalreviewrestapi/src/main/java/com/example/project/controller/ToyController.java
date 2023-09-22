package com.example.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.project.model.Toy;
import com.example.project.repository.ToyRepository;

@RestController
@RequestMapping("/api/books")
@CrossOrigin // Allowing Cross-Origin Resource Sharing (CORS)
public class ToyController {
    @Autowired
    private ToyRepository bookRepository;

    // Create a new book
    @PostMapping
    public ResponseEntity<Toy> createBook(@RequestBody Toy book) {
        Toy savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Toy>> getAllBooks() {
        List<Toy> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Toy> getBookById(@PathVariable Long id) {
        Toy book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a book by ID
    @PutMapping("/{id}")
    public ResponseEntity<Toy> updateBook(@PathVariable Long id, @RequestBody Toy updatedBook) {
        Toy existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setCustomer(updatedBook.getCustomer());
            existingBook.setDept(updatedBook.getDept());
            existingBook.setList(updatedBook.getList());
            Toy savedBook = bookRepository.save(existingBook);
            return ResponseEntity.ok(savedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        Toy book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}