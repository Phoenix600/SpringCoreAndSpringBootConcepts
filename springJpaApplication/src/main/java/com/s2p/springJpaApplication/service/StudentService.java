package com.s2p.springJpaApplication.service;

import com.s2p.springJpaApplication.model.Student;
import com.s2p.springJpaApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student)
    {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public List<Student> fetchAllStudents()
    {
        // SELECT * FROM student;
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }



    public Boolean deleteStudentById(Long studentId)
    {
        boolean isDeleted = false;

        Optional<Student> studentOptional =  studentRepository.findById(studentId);

        if(studentOptional.isPresent())
        {
            isDeleted = true;
            Student student = studentOptional.get();
            studentRepository.delete(student);
        }

        return isDeleted;
    }

}
