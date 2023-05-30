package com.graphqljava.tutorial.bookDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Author {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String sex;

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joanne", "Rowling", 35, "female"),
            new Author("author-2", "Herman", "Melville", 52, "other"),
            new Author("author-3", "Anne", "Rice", 28, "female")
    );

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().
                orElseThrow(() -> new AuthorNotFoundException("Author with id: " + id + " was not found"));
    }

    public static List<Author> getAuthorsByGender(String esex) {
        return authors.stream().filter(author -> author.getSex().equals(esex)).collect(Collectors.toList());
    }

}
