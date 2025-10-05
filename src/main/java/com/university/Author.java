package com.university;
/**
 * Represents an author retrieved from the Google Scholar API.
 * This class models key information such as the author's name,
 * affiliation, profile URL, and a list of their top publications.
 */
import java.util.List;

public class Author {
    private String name;
    private String affiliation;
    private String url;
    private List<String> publications;

    public Author(String name, String affiliation, String url, List<String> publications) {
        this.name = name;
        this.affiliation = affiliation;
        this.url = url;
        this.publications = publications;
    }

    public String getName() {
        return name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getPublications() {
        return publications;
    }
}
