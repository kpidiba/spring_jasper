package com.test.jasper.practice1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.jasper.practice1.models.Employe;
import com.test.jasper.practice1.repository.EmployeRepository;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public Employe addEtudiant(Employe employe) {
        return this.employeRepository.save(employe);
    }

    public List<Employe> getAll() {
        return (List<Employe>) this.employeRepository.findAll();
    }
}
