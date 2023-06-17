package com.test.jasper.practice1.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.test.jasper.practice1.models.Employe;
import com.test.jasper.practice1.models.Notes;
import com.test.jasper.practice1.repository.EmployeRepository;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Service
public class ReportService {
    @Autowired
    private EmployeRepository repository;

    /**
     * @param reportFormat
     * @return
     */
    public String exportReport(String reportFormat) {
        List<Employe> emList = repository.findAll();
        String path = "C:\\Users\\kpidi\\OneDrive\\Bureau";
        try {
            File file = ResourceUtils.getFile("classpath:employe.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(emList);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBY", "DAVID");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
            }
            if (reportFormat.equalsIgnoreCase("excel")) {
                // JRXlsExporter exporter = new JRXlsExporter();

                // exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME,
                // jasperPrint);
                // exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                // path + "\\employees.pdf");
                JRXlsExporter exporter = new JRXlsExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path + "\\employees.xls"));
                SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
                configuration.setOnePagePerSheet(true);
                configuration.setDetectCellType(true);
                configuration.setCollapseRowSpan(false);
                exporter.setConfiguration(configuration);
                exporter.exportReport();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "report generated in path" + path;
    }

    /**
     * @param reportFormat
     * @return
     */
    public String exportReportTEST(String reportFormat) {
        List<Employe> emList = repository.findAll();
        String path = "C:\\Users\\kpidi\\OneDrive\\Bureau";
        try {
            File file = ResourceUtils.getFile("classpath:test.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(emList);
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("semestre", "SEMESTRE 1");
            parameters.put("matiere", "PHYSIQUE");
            parameters.put("niveau", "LICENCE");
            parameters.put("annee", "2ieme");
            parameters.put("filiere", "ARCHITECTURE");
            parameters.put("anneeScolaire", "2021 - 2022");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\test.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\test.pdf");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "report generated in path" + path;
    }
}
