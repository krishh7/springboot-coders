package com.springboot.coders.controller;

import com.springboot.coders.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private ArrayList<Book> books = new ArrayList<>();

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId((long) books.size() + 1);
        books.add(book);
        return book;
    }

    @GetMapping
    public ArrayList<Book> getBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            return existingBook;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        books.removeIf(b -> b.getId().equals(id));
    }

    //@RequestParam usecase
    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam String title) {
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst().stream().collect(Collectors.toList());
    }

}
