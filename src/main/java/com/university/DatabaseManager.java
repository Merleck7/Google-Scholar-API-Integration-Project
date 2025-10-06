package com.university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Utility class to manage SQLite database connections
 * and initialize the articles table.
 */
public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:scholar.db";

    /**
     * Initialize the database and create the articles table if it doesn't exist.
     */
    public static void initializeDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            String sql = """
                CREATE TABLE IF NOT EXISTS articles (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    authors TEXT,
                    publication_date TEXT,
                    abstract TEXT,
                    link TEXT,
                    keywords TEXT,
                    cited_by INTEGER
                );
                """;
            stmt.execute(sql);
            System.out.println("✅ Database initialized successfully.");
        } catch (SQLException e) {
            System.out.println("⚠️ Error initializing database: " + e.getMessage());
        }
    }

    /**
     * Returns a new connection to the SQLite database.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
