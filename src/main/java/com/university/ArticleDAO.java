package com.university;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ArticleDAO {

    public static void saveArticleToDB(String title, String authors, String publicationDate,
                                       String abstractText, String link, String keywords, int citedBy) {
        String sql = "INSERT INTO articles(title, authors, publication_date, abstract, link, keywords, cited_by) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, authors);
            pstmt.setString(3, publicationDate);
            pstmt.setString(4, abstractText);
            pstmt.setString(5, link);
            pstmt.setString(6, keywords);
            pstmt.setInt(7, citedBy);

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("❌ Error saving article to DB: " + e.getMessage());
        }
    }
}
