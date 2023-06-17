package com.test.jasper.practice1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String designation;
    private double salary;
    private String obj;

    public Employe(){
        super();
    }

    public Employe(Integer id, String name, String designation, double salary, String obj) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.obj = obj;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getObj() {
        return obj;
    }
    public void setObj(String obj) {
        this.obj = obj;
    }
    @Override
    public String toString() {
        return "Employe [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary + ", obj="
                + obj + "]";
    }
    
}
