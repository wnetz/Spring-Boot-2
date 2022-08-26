package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        super();
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id)
    {
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id)
    {
        return new ResponseEntity<>(studentService.updateStudent(student,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id)
    {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

}
