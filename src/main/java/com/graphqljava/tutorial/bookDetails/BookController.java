package com.graphqljava.tutorial.bookDetails;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class BookController {



    @QueryMapping
    public Book bookById (@Argument String id) {
        log.info("argument passed: " + id);
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> booksByGender (@Argument String gender) {
        log.info("argument passed: " + gender);
        return Book.getBooksByGender(gender);
    }

    @SchemaMapping
    public Author author(Book book){
        return Author.getById(book.getAuthorId());
    }

}
