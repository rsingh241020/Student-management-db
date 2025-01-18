package com.jpahibernate.example.student_management_db.service;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // It Contains the Business Logic of the application
public class StudentService {
    @Autowired // It will Create Spring internal bean - of Spring IOC Container
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student save into database Successfully ";
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
    public Student getStudentById(int studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.get(); // this will get student inside optional .
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student with id :"+studentId+" got deleted";
    }
    public String updateStudentUsingPut(int studentId,Student newStudentRequest){
        // find the student with id
        //if student present then update it else can not update it
        Student student = getStudentById(studentId);
        if(student != null){
            studentRepository.save(newStudentRequest);
            return "Student Updated";
        }
        else{
            return "Not Found";
        }
    }
    public String updateStudentUsingPatch(int studentId,String grade){
        // find the student with id
        //if student present then update it else can not update it
        Student student = getStudentById(studentId);
        if(student != null){
            student.setGrade(grade);
            studentRepository.save(student);
            return "Student Updated";
        }
        else{
            return "Not Found ";
        }
    }
}
