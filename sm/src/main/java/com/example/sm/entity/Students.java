package com.example.sm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_email", nullable = false)
    private String studentEmail;

    @Column(name = "student_address")
    private String studentAddress;

    // ✅ Default constructor (required)
    public Students() {
    }

    // ✅ Constructor WITHOUT id (important for inserts)
    public Students(String studentName, String studentEmail, String studentAddress) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    // ✅ Full constructor (optional)
    public Students(Long id, String studentName, String studentEmail, String studentAddress) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    // ⚠️ DO NOT set id manually unless you know why
    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Students [id=" + id + ", studentName=" + studentName +
                ", studentEmail=" + studentEmail +
                ", studentAddress=" + studentAddress + "]";
    }
}