package com.test.jasper.practice1.models;


public class Notes {
    private int id;
    private String name;
    private double note1;
    private double note2;
    private double note3;
    private double moyenne;
    private String appreciations;
    private String observations;

    Notes(){
        super();
    }

    public Notes(int id, String name, double note1, double note2, double note3, Double moyenne, String appreciations,
            String observations) {
        this.id = id;
        this.name = name;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.moyenne = moyenne;
        this.appreciations = appreciations;
        this.observations = observations;
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

    public Double getNote1() {
        return note1;
    }

    public void setNote1(Double note1) {
        this.note1 = note1;
    }

    public Double getNote2() {
        return note2;
    }

    public void setNote2(Double note2) {
        this.note2 = note2;
    }

    public Double getNote3() {
        return note3;
    }

    public void setNote3(Double note3) {
        this.note3 = note3;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public String getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(String appreciations) {
        this.appreciations = appreciations;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", name=" + name + ", note1=" + note1 + ", note2=" + note2 + ", note3=" + note3
                + ", moyenne=" + moyenne + ", appreciations=" + appreciations + ", observations=" + observations + "]";
    }

    
}
