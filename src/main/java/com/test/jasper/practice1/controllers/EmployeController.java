package com.test.jasper.practice1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.jasper.practice1.models.Employe;
import com.test.jasper.practice1.services.EmployeService;
import com.test.jasper.practice1.services.ReportService;

@RestController
@RequestMapping("/test1")
public class EmployeController {
    @Autowired
    EmployeService employeService;
    @Autowired
    ReportService reportService;
    
    @GetMapping("/report/{format}")
    public String report(@PathVariable String format) {
        return reportService.exportReport(format);
    }

    @GetMapping("/reporter/{format}")
    public String reportTEST(@PathVariable String format) {
        return reportService.exportReportTEST(format);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employe>> getAll() {
        List<Employe> employes = employeService.getAll();
        return ResponseEntity.of(Optional.of(employes));
        
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Employe employe) {
        System.out.println(employe);
        try {
            this.employeService.addEtudiant(employe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("register");
    }
}
