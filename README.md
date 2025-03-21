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
<dependency>
     <groupId>net.sf.jasperreports</groupId>
     <artifactId>jasperreports-fonts</artifactId>
     <version>6.21.2</version>
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

- **Define Parameters:**  
  Add parameters to the `.jrxml` file to be used for dynamic values. For example, to add a `logoPath` parameter:
  
  ```xml
  <parameter name="logoPath" class="java.lang.String"/>
  ```

This parameter can then be passed from the application to customize the report, such as setting a dynamic image path.

### 6. Populate Report

- In the **Details** section of the Jasper Report file, insert your variable names.

### 7. DEFAULT FONT

- **DejaVu Sans**

---

## 🛠 Example Code Snippets

### Sample Controller

```java
@RestController
@RequestMapping("/reports")
public class ReportController {

    @GetMapping("/testing")
    public void generateReport() {
        try {
            // Load the .jrxml file as an InputStream
            InputStream jrxmlStream = getClass().getResourceAsStream("/jasper/dos-preview.jrxml");
            if (jrxmlStream == null) {
                throw new IllegalArgumentException("Jasper report file not found: /jasper/dos-preview.jrxml");
            }

            // Compile the .jrxml into a .jasper file
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlStream);

            // Resolve the image path from the classpath
            String logoPath = new ClassPathResource("images/logo.jpg").getFile().getAbsolutePath();

            // Set up parameters (if any)
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("logoPath", logoPath);

            // Use an empty data source as the template has no dynamic fields
            JRDataSource dataSource = new JREmptyDataSource();

            // Fill the report with data and parameters
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the filled report to a PDF
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            // Save the PDF to the output directory
            Files.createDirectories(Paths.get("output")); // Ensure the output directory exists
            Files.write(Paths.get("output/report.pdf"), pdfBytes);

            System.out.println("Report generated successfully at: output/report.pdf");

        } catch (Exception e) {
            System.out.println("===========================================================================");
            System.err.println("Error generating report:");
            e.printStackTrace();
        }
    }
}
```

### 7. Add an Image to JRXML

To add an image to your `.jrxml` file, define the image component in the file. Set the `imageExpression` to use the parameter that will hold the image path:

```xml
<image>
    <reportElement x="0" y="0" width="100" height="100"/>
    <imageExpression><![CDATA[$P{logoPath}]]></imageExpression>
</image>
```

Make sure the `logoPath` parameter is properly defined in the `.jrxml` file as shown earlier:

```xml
<parameter name="logoPath" class="java.lang.String"/>
```

**Get the Image Path from Resources:**  
If the image is stored in the `resources` folder (e.g., `src/main/resources/images/logo.jpg`), you can get the absolute path of the image file as follows:

```java
String logoPath = new ClassPathResource("images/logo.jpg").getFile().getAbsolutePath();
```

This path can then be passed as a parameter when filling the report, ensuring the image is dynamically loaded.

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
