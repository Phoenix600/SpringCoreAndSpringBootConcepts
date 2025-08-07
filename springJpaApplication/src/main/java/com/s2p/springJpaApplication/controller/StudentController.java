package com.s2p.springJpaApplication.controller;

import com.s2p.springJpaApplication.model.Student;
import com.s2p.springJpaApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;

    // POST http://localhost:8080/api/v1/student
    @PostMapping("/api/v1/student")
    public Student createStudentRecord(@RequestBody Student student)
    {
        Student createStudent = studentService.saveStudent(student);
        return createStudent;
    }

    @GetMapping("/api/v1/student")
    public List<Student> getAllStudents()
    {
       List<Student> studentList =   studentService.fetchAllStudents();
       return studentList;
    }

    // http://localhost:8080/api/v1/student/1
    @DeleteMapping("/api/v1/student/{id}")
    public String removeStudentById(@PathVariable("id")Long id)
    {
        boolean result = studentService.deleteStudentById(id);
        String message = result == true ? "Student Has Been Deleted." : "Unable To Delete Student.";
        return message;
    }

    


}
