package com.university;
/**
 * Utility class used to check whether the environment
 * variable for the API key is correctly configured.
 */
public class TestEnv {
    public static void main(String[] args) {
        String apiKey = System.getenv("SERPAPI_KEY");

        if (apiKey != null) {
            System.out.println("✅ SERPAPI_KEY found: " + apiKey.substring(0, 8) + "...");
        } else {
            System.out.println("⚠️ SERPAPI_KEY not found!");
        }
    }
}

