# Spring Boot Jasper Reports

Easily integrate **Jasper Reports** into your Spring Boot applications for generating stunning, customizable reports.

---

## 🔧 Dependency

To get started, add the following Maven dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>net.sf.jasperreports</groupId>
    <artifactId>jasperreports</artifactId>
    <version>6.20.5</version>
</dependency>
```

---

## 📚 Useful Resources

Here are some helpful tutorials and guides to deepen your understanding:

- [Using Multiple JavaBean DataSources in Jasper Report (Stack Overflow)](https://stackoverflow.com/questions/11649626/using-multiple-javabean-datasources-in-jasper-report)

- [Spring Boot + Jasper Report Example (JavaTechie on YouTube)](https://www.youtube.com/watch?v=pc4lfKm8NLY&t=318s)

- [Generate Jasper Report with Spring Boot Example (YouTube)](https://www.youtube.com/watch?v=8eR_gvFfRLM&t=1446s)

- [Design and Generate Jasper Report with Table (YouTube)](https://www.youtube.com/watch?v=YnZZm-P7lPs&t=1386s)

---

## 🚀 Phase 1: Setup and Basic Features

### 1. CRUD Operations

- Implement a simple CRUD API with **CREATE** and **GET ALL** endpoints.

### 2. Create Jasper Report Project

- Design a **Jasper Report** file.

### 3. Styling and Database

- Choose a simple **blue theme** for styling.

- Use a **sample database**.

- Execute the query:

```sql
SELECT * FROM tasks OR orders OR positions;
```

### 4. Configure Fields

- Select the number of input fields you require.

- Copy the `.jrxml` file into the `resources` folder of your Spring Boot project.

### 5. File Cleanup

- Remove `queryString` and all properties in the `.jrxml` file.

- Rename field names to match your object’s variable names.

- Define appropriate types (e.g., `class.lang.Integer`).

### 6. Populate Report

- In the **Details** section of the Jasper Report file, insert your variable names.

---

## 🛠 Example Code Snippets

### Sample Controller

```java
@RestController
@RequestMapping("/reports")
public class ReportController {

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateReport() {
        // Logic for generating and returning the Jasper report
    }
}
```

### Service for Report Generation

```java
@Service
public class ReportService {

    public byte[] exportReport() {
        // JasperReports logic
    }
}
```

---

## 🌟 Features

- **Dynamic Reports:** Customize fields dynamically based on your database.

- **Scalable Design:** Supports large datasets with efficient report generation.

- **Integration Ready:** Seamless integration with Spring Boot and other Java frameworks.

---

## 💡 Tips

- Use **JasperSoft Studio** for designing your reports visually.

- Ensure your `.jrxml` file aligns with your entity model to avoid runtime errors.

- Test your queries separately before embedding them into Jasper Reports.

---

## 📦 Output

The final output is a dynamic report in PDF, XLS, or other supported formats, showcasing the data retrieved from your Spring Boot application.

Happy Reporting! 🎉
