package com.university;
/**
 * Unit tests for the Author and AuthorController classes.
 * Uses JUnit 5 for assertions.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    void testAuthorCreation() {
        Author author = new Author("Luis", "University of Tech");
        assertEquals("Luis", author.getName());
        assertEquals("University of Tech", author.getAffiliation());
    }
}

