package com.example.demoAPI.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Insert Student
    public Student insertStudent(Student student){
        // Testing Data
        studentRepository.findStudentByEmail(student.getEmail()).ifPresentOrElse(
                s -> {
                    // Is email exist
                    System.out.println(s + " already exists");
                }, () -> {
                    System.out.println("Inserting Student : " + student);
                    studentRepository.insert(student);
                }
        );
        return student;
    }

}
