package com.example.demoAPI.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student insertStudent(@RequestBody Student student){
        Student returnedStudent = studentService.insertStudent(student);
        // Test if Student inserted
        if (returnedStudent.getId() == null){
            return null;
        }
        return returnedStudent;
    }
}
