# 🎓 Google Scholar API - Academic Project

This academic project implements a **Java client** that connects to the **Google Scholar Author API** using **SerpAPI**, following the **MVC (Model-View-Controller)** design pattern. It now also integrates **SQLite** to store articles and author metadata.

---

## 🚀 Project Structure

```
Google-api/
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/university/
    │           ├── Author.java               
    │           ├── AuthorController.java
    │           ├── Main.java
    │           ├── TestEnv.java
    │           ├── DatabaseManager.java
    │           └── ArticleDAO.java
    │
    └── test/
        └── java/
            └── com/university/
                └── AuthorTest.java
```

---

## ⚙️ Requirements

- **Java 17+**
- **Apache Maven**
- A valid **SerpAPI Key** ([SerpAPI](https://serpapi.com/))

---

## 🔑 Setting the API Key

1. Open your system’s **Environment Variables**.
2. Create a variable named:

   ```
   SERPAPI_KEY
   ```

3. Assign your API Key, for example:

   ```
   6229dc8de6489ba9rytsdg68f0h67j562b4f1b
   ```

4. Save and restart your terminal or IDE.

---

## 🏃‍♂️ Running the Project

From the project root, run:

```bash
mvn exec:java -Dexec.mainClass=com.university.Main -Dexec.args="<author_id>"
```

For example, for Geoffrey Hinton (ID `JicYPdAAAAAJ`):

```bash
mvn exec:java -Dexec.mainClass=com.university.Main -Dexec.args="JicYPdAAAAAJ"
```

Expected output:

```
✅ Scholar API running correctly!
✅ Database initialized successfully.
✅ API Key loaded from environment.
📚 Found 20 articles.
✅ Article saved: ...
👤 Name: ...
🏛️ Affiliation: ...
🔗 Profile: ...
```

---

## 🗄️ SQLite Database

- Database: `scholar.db`
- Table: `articles`

```sql
CREATE TABLE articles (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT,
    authors TEXT,
    publication_date TEXT,
    abstract TEXT,
    link TEXT,
    keywords TEXT,
    cited_by INTEGER
);
```

- Article data is automatically saved when running the application.
- You can query it using **SQLite Viewer** or the CLI:

```bash
sqlite3 scholar.db
SELECT * FROM articles;
```

---

## 🧠 Design Pattern

- **Model (`Author.java`)** → Represents author data.
- **View (Console)** → Displays information.
- **Controller (`AuthorController.java`)** → Handles API and database logic.
- **Main (`Main.java`)** → Application entry point.

---

## 🧪 Testing

- `TestEnv.java` checks that the **API Key** is correctly set.
- Run tests with:

```bash
mvn test
```

---

## ⚠️ Considerations

- **API limits**: respect SerpAPI usage restrictions.
- **Error handling**: app manages network, API, and database errors.
- `abstract` and `keywords` are stored as `"N/A"` if unavailable.

---

## 🏁 Author

Academic project developed by **Luis Mendoza**  
📧 [mendozarl@outlook.es](mailto:mendozarl@outlook.es)  
💼 [LinkedIn](https://www.linkedin.com/in/luismendoza2007/) | 🧑‍💻 [GitHub](https://github.com/Merleck7)