package com.test.jasper.practice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jasper.practice1.models.Employe;

public interface EmployeRepository  extends JpaRepository<Employe,Integer>{
        
}
