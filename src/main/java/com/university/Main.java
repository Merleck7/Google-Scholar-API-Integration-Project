package com.university;
/**
 * Entry point of the Google Scholar API project.
 * 
 * This class loads the environment variable for the API key,
 * checks if the application runs correctly, and fetches
 * author information by ID using the AuthorController.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("✅ Scholar API running correctly!");

        //Load API Key from Environment Variable
        String apiKey = System.getenv("SERPAPI_KEY");
        if (apiKey == null) {
            System.out.println("⚠️ API Key not found. Please set SERPAPI_KEY.");
            return;
        } else {
            System.out.println("🔑 API Key loaded from environment.");
        }

        // Review arguments
        if (args.length == 0) {
            System.out.println("⚠️ No author ID provided. Example usage:");
            System.out.println("   mvn exec:java -Dexec.mainClass=com.university.Main -Dexec.args=\"<author_id>\"");
            return;
        }

        String authorId = args[0];

        // Create controller and get data
        AuthorController controller = new AuthorController(apiKey);
        Author author = controller.fetchAuthor(authorId);

        if (author != null) {
            System.out.println("\n📚 Author Information:");
            System.out.println("👤 Name: " + author.getName());
            System.out.println("🏛️ Affiliation: " + author.getAffiliation());
            System.out.println("🔗 Profile: " + author.getUrl());

            System.out.println("\n📖 Top Publications:");
            author.getPublications().forEach(pub ->
                    System.out.println("   - " + pub));
        } else {
            System.out.println("⚠️ Could not fetch author data.");
        }
    }
}


