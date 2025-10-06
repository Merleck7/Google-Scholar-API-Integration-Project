package com.university;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class responsible for fetching author data
 * from the Google Scholar API and saving articles in the database.
 */
public class AuthorController {
    private final String apiKey;

    public AuthorController(String apiKey) {
        this.apiKey = apiKey;
    }

    public Author fetchAuthor(String authorId) {
        try {
            String urlString = String.format(
                    "https://serpapi.com/search.json?engine=google_scholar_author&author_id=%s&api_key=%s",
                    authorId, apiKey);

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                System.out.println("❌ Error fetching author: " + conn.getResponseCode());
                return null;
            }

            JsonObject json = JsonParser.parseReader(new InputStreamReader(conn.getInputStream())).getAsJsonObject();

            JsonObject authorData = json.getAsJsonObject("author");
            if (authorData == null) {
                System.out.println("⚠️ No author data found.");
                return null;
            }

            String name = authorData.get("name").getAsString();
            String affiliation = authorData.has("affiliations") ? authorData.get("affiliations").getAsString() : "N/A";
            String urlProfile = authorData.has("link") ? authorData.get("link").getAsString() : "N/A";

            List<String> publications = new ArrayList<>();
            if (json.has("articles")) {
                JsonArray articles = json.getAsJsonArray("articles");
                for (int i = 0; i < Math.min(5, articles.size()); i++) {
                    JsonObject article = articles.get(i).getAsJsonObject();

                    String title = article.has("title") ? article.get("title").getAsString() : "N/A";
                    publications.add(title);

                    String authors = article.has("authors") ? article.get("authors").getAsString() : "N/A";
                    String publicationDate = article.has("year") ? article.get("year").getAsString() : "N/A";
                    String abstractText = article.has("snippet") ? article.get("snippet").getAsString() : "N/A";
                    String link = article.has("link") ? article.get("link").getAsString() : "N/A";
                    String keywords = article.has("keywords") ? article.get("keywords").getAsJsonArray().toString() : "N/A";
                    int citedBy = article.has("cited_by") ? article.getAsJsonObject("cited_by").get("value").getAsInt() : 0;

                    // Guardar artículo en la base de datos
                    ArticleDAO.saveArticleToDB(title, authors, publicationDate, abstractText, link, keywords, citedBy);
                    System.out.println("✅ Article saved: " + title);
                }
            }

            return new Author(name, affiliation, urlProfile, publications);

        } catch (Exception e) {
            System.out.println("❌ Exception while fetching author: " + e.getMessage());
            return null;
        }
    }
}
