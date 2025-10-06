package com.university;

public class Article {
    private String title;
    private String authors;
    private String publicationDate;
    private String summary;
    private String link;
    private String keywords;
    private int citedBy;

    public Article(String title, String authors, String publicationDate, String summary, String link, String keywords, int citedBy) {
        this.title = title;
        this.authors = authors;
        this.publicationDate = publicationDate;
        this.summary = summary;
        this.link = link;
        this.keywords = keywords;
        this.citedBy = citedBy;
    }

    public String getTitle() { return title; }
    public String getAuthors() { return authors; }
    public String getPublicationDate() { return publicationDate; }
    public String getSummary() { return summary; }
    public String getLink() { return link; }
    public String getKeywords() { return keywords; }
    public int getCitedBy() { return citedBy; }
}
