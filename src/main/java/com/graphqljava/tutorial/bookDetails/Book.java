package com.graphqljava.tutorial.bookDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Book {

    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3")
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().
                orElseThrow(() -> new BookNotFoundException("Book having ID: " + id + " is not found in our collection."));
    }

    public static List<Book> getBooksByGender(String gender) {
        List<Book> response = new ArrayList<>();
        List<String> authorIds = Author.getAuthorsByGender(gender).stream().map(Author::getId).toList();
        for (Book book: books) {
            for (String s: authorIds) {
                if (book.getAuthorId().equals(s)){
                    response.add(book);
                }
            }
        }
        return response;
    }




}
