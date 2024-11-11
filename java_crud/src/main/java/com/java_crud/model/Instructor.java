package com.java_crud.model;

import java.sql.Date;

public class Instructor {
    private int instructor_id;
    private String name;
    private String lastname;
    private int age;
    private String email;
    private Date load_date;
    private Date update_date;


    public Instructor(String name, String lastname, int age, String email, Date load_date, Date update_date){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.load_date = load_date;
        this.update_date = update_date;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
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

    
    @Override
    public String toString() {
        return "Instructor [instructor_id=" + instructor_id + ", name=" + name + ", lastname=" + lastname + ", age="
                + age + ", email=" + email + ", load_date=" + load_date + ", update_date=" + update_date + "]";
    }
    
}
