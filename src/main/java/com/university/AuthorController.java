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
 * from the Google Scholar API. 
 *
 * For this educational project, the data is simulated.
 * In a real application, this class would make HTTP GET
 * requests using a library like Apache HttpClient or HttpURLConnection.
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
            String affiliation = authorData.get("affiliations") != null ? authorData.get("affiliations").getAsString() : "N/A";
            String urlProfile = authorData.get("link") != null ? authorData.get("link").getAsString() : "N/A";

            List<String> publications = new ArrayList<>();
            if (json.has("articles")) {
                JsonArray articles = json.getAsJsonArray("articles");
                for (int i = 0; i < Math.min(5, articles.size()); i++) {
                    JsonObject article = articles.get(i).getAsJsonObject();
                    publications.add(article.get("title").getAsString());
                }
            }

            return new Author(name, affiliation, urlProfile, publications);

        } catch (Exception e) {
            System.out.println("❌ Exception while fetching author: " + e.getMessage());
            return null;
        }
    }
}
