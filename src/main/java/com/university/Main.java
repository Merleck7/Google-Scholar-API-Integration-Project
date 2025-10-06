package com.university;

public class Main {
    public static void main(String[] args) {
        System.out.println("✅ Scholar API running correctly!");

        DatabaseManager.initializeDatabase();

        String apiKey = System.getenv("SERPAPI_KEY");
        if (apiKey == null) {
            System.out.println("⚠️ API Key not found. Please set SERPAPI_KEY.");
            return;
        } else {
            System.out.println("🔑 API Key loaded from environment.");
        }

        if (args.length == 0) {
            System.out.println("⚠️ No author ID provided. Example usage:");
            System.out.println("   mvn exec:java -Dexec.mainClass=com.university.Main -Dexec.args=\"<author_id>\"");
            return;
        }

        String authorId = args[0];
        AuthorController controller = new AuthorController(apiKey);
        Author author = controller.fetchAuthor(authorId);

        if (author != null) {
            System.out.println("\n📚 Author Information:");
            System.out.println("👤 Name: " + author.getName());
            System.out.println("🏛️ Affiliation: " + author.getAffiliation());
            System.out.println("🔗 Profile: " + author.getUrl());

            System.out.println("\n📖 Top Publications:");
            author.getPublications().forEach(pub -> System.out.println("   - " + pub));
        } else {
            System.out.println("⚠️ Could not fetch author data.");
        }
    }
}



