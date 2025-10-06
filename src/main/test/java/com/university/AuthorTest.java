package com.university;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    @Test
    void testAuthorCreation() {
        Author author = new Author("Luis", "University of Tech", "http://example.com", List.of("Paper 1", "Paper 2"));

        assertEquals("Luis", author.getName());
        assertEquals("University of Tech", author.getAffiliation());
        assertEquals("http://example.com", author.getUrl());
        assertEquals(2, author.getPublications().size());
    }
}




