package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController
{
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService)
    {
        super();
        this.teacherService = teacherService;
    }

    @PostMapping()
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher)
    {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Teacher> getAllTeacher()
    {
        return teacherService.getAllTeachers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") long id)
    {
        return new ResponseEntity<>(teacherService.getTeacherById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") long id)
    {
        return new ResponseEntity<>(teacherService.updateTeacher(teacher,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") long id)
    {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>("Teacher deleted", HttpStatus.OK);
    }

}
