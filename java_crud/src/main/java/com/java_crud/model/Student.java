package com.java_crud.model;

import java.util.Date;

public class Student {
    private int students_id;
    private String name;
    private String lastname;
    private int age;
    private String email;
    private Date load_date;
    private Date update_date; 
    
    public Student(String name, String lastname, int age, String email){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email; 
    
    }


    //Getters & Setters
    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLoad_date() {
        return load_date;
    }

    public void setLoad_date(Date load_date) {
        this.load_date = load_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

}
