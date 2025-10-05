# 🎓 Google Scholar API - Academic Project

This academic project implements a **Java client** that connects to the **Google Scholar Author API** using **SerpAPI**, applying the **MVC (Model-View-Controller)** design pattern.  
The goal is to retrieve and display academic author information, including name, affiliation, and featured publications.

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
    │           └── TestEnv.java
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
- A valid **API Key** from [SerpAPI](https://serpapi.com/)

---

## 🔑 Setting the API Key

1. Open your system’s **Environment Variables**.
2. Create a new variable named:

   ```
   SERPAPI_KEY
   ```

3. Set its value to your API Key, for example:

   ```
   6229dc8de6489ba9rytsdg68f0h67j562b4f1b
   ```

4. Save the changes and **restart your terminal or IDE**.

---

## 🏃‍♂️ Running the Project

From the project root, execute:

```bash
mvn exec:java
```

If the system prints:

```
✅ Scholar API running correctly!
✅ API Key loaded from environment.
```

it means the API Key was successfully detected.

---

## 🔍 Query an Author

To query a specific author, use their **Google Scholar ID**.  
Example: Geoffrey Hinton has the ID `JicYPdAAAAAJ`.

Run the command:

```bash
mvn exec:java "-Dexec.mainClass=com.university.Main" "-Dexec.args=JicYPdAAAAAJ"
```

Expected output:

```
✅ Scholar API running correctly!
✅ API Key loaded from environment.

👤 Author Information:
📘 Name: Geoffrey Hinton
🏛️ Affiliation: Emeritus Prof. Computer Science, University of Toronto

📚 Top Publications:
 - Imagenet classification with deep convolutional neural networks
 - Deep learning
 - Visualizing data using t-SNE
 - Learning internal representations by error-propagation
 - Dropout: a simple way to prevent neural networks from overfitting
```

---

## 🧠 Design Pattern

The project follows the **MVC** pattern:

- **Model (`Author.java`)** → Represents the author’s data structure.  
- **View (`AuthorView.java`)** → Displays information in the console.  
- **Controller (`AuthorController.java`)** → Manages API connection logic and data flow.  
- **Main (`Main.java`)** → Entry point of the application.

---

## 🧩 Libraries Used

- `org.json` → For handling JSON responses.  
- `java.net.HttpURLConnection` → For HTTP GET requests.  
- `org.apache.maven.plugins:maven-exec-plugin` → To execute the project from the command line.

---

## 🧪 Testing

The `TestEnv.java` file checks that the **environment variable** is correctly set and that the application can run without errors.

Run tests with:

```bash
mvn test
```

---

## 📚 Resources

- [Official SerpAPI Documentation](https://serpapi.com/)
- [Google Scholar Author API](https://serpapi.com/google-scholar-author-api)
- [MVC Design Pattern in Java Guide](https://www.geeksforgeeks.org/mvc-design-pattern/)

---

## 🏁 Author

Academic project developed by **Luis Mendoza**  
📧 [mendozarl@outlook.es](mailto:mendozarl@outlook.es)  
💼 [LinkedIn](https://www.linkedin.com/in/luismendoza2007/) | 🧑‍💻 [GitHub](https://github.com/Merleck7)
