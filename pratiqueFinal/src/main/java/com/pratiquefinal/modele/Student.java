/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pratiquefinal.modele;

import java.util.ArrayList;

/**
 *
 * @author Rova
 */
public class Student {
    int id;
    String fName;
    String lName;
    String dob;
    boolean active;
    double gpa;
    ArrayList<Resultat> resultats = new ArrayList<>();

    public Student() {
    }

    public Student(int id, String fName, String lName, String dob, boolean active, double gpa) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.active = active;
        this.gpa = gpa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public ArrayList<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(ArrayList<Resultat> resultats) {
        this.resultats = resultats;
    }

    @Override
    public String toString() {
        String res = "Student{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", dob=" + dob + ", active=" + active + ", gpa=" + gpa +", resultats=";
        for (int i = 0; i < resultats.size(); i++) {
            res=res+resultats.get(i).toString()+",";
        }
        res=res+ '}';
        return res;
    }
    
    
}
