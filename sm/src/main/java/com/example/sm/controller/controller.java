package com.example.sm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sm.entity.Students;
import com.example.sm.repo.StudentRepo;

@RestController
@RequestMapping("/api/students")
public class controller {

    @Autowired
    private StudentRepo studentRepo;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Students> saveStudent(@RequestBody Students student) {
        Students saved = studentRepo.save(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ READ ALL
    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> list = studentRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable Long id) {
        Optional<Students> student = studentRepo.findById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudent(
            @PathVariable Long id,
            @RequestBody Students updatedStudent) {

        Optional<Students> existing = studentRepo.findById(id);

        if (existing.isPresent()) {
            Students student = existing.get();
            student.setStudentName(updatedStudent.getStudentName());
            student.setStudentEmail(updatedStudent.getStudentEmail());
            student.setStudentAddress(updatedStudent.getStudentAddress());

            Students saved = studentRepo.save(student);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Optional<Students> student = studentRepo.findById(id);

        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}