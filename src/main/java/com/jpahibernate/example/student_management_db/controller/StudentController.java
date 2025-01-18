package com.jpahibernate.example.student_management_db.controller;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    //Controller <-> Service <-> Repository
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        String response = studentService.addStudent(student);
        return response;
    }

    @GetMapping("/findAll")
    public List<Student> findAll() {
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }

    @GetMapping("/find/{studentId}")
    public Student findStudentById(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;
    }
    @DeleteMapping("/delete/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        String response = studentService.deleteStudentById(studentId);
        return response;
    }

    //PUT - We update whole Fields(Whole Object)
    //PATCH - We Update the Specific Fields

    @PutMapping("/update/{studentId}")
    public String updateStudentUsingPut(@PathVariable int studentId,@RequestBody Student student){

        String response = studentService.updateStudentUsingPut(studentId,student);
        return  response;
    }
    @PatchMapping("/update/{studentId}")
    public String updateStudentUsingPatch(@PathVariable int studentId,@RequestParam String grade){

        String response = studentService.updateStudentUsingPatch(studentId,grade);
        return  response;
    }
}
