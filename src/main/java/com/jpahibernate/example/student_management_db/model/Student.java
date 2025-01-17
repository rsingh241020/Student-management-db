package com.jpahibernate.example.student_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // It refers that it is a model or entity which directly represent the database table
@Table(name = "Student") // It will create a table inside the database if we not give the name then it take
// automatically class name
public class Student {

    @Id // It is a Primary Key  I need which we want to create the primary key do @id
    @Column(name = "student_Id") // It will Create a Column in the dataBase with the name student_Id
    private int studentId;

    @Column(name = "name",nullable = false) // nullable = false - It is a mandatory Field and cannot be empty
    private String name;

    @Column(name = "email",nullable = false,unique = true) // it means every value is unique
    private String email;

    @Column(name = "grade",nullable = false)
    private String grade;

    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name ="password",nullable = false )
    private String password;
}
