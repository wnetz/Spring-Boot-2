package com.example.demo.controller;

import com.example.demo.entity.Class;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassController
{
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;
    private ClassService classService;

    public ClassController(ClassService classService)
    {
        super();
        this.classService = classService;
    }

    @PostMapping("/teachers/{t_id}/classes")
    public ResponseEntity<Class> createClass(@PathVariable(value = "t_id") Long id, @RequestBody Class classRequest)
    {
        return new ResponseEntity<>(classService.createClases(classRequest,id), HttpStatus.CREATED);
    }
    @GetMapping("/teachers/{t_id}/classes")
    public ResponseEntity<List<Class>> getAllClassesByTeacherId(@PathVariable(value = "t_id") Long id)
    {
        return new ResponseEntity<>(classService.getAllClassesByTeacherId(id), HttpStatus.OK);
    }
    @GetMapping("/classes/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable(value = "id") Long id)
    {
        return new ResponseEntity<>(classService.getClassById(id), HttpStatus.OK);
    }

    @GetMapping("/classes")
    public ResponseEntity<List<Class>> getAllClasses()
    {
        return new ResponseEntity<>(classService.getAllClasses(), HttpStatus.OK);
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable("id") long id, @RequestBody Class classRequest)
    {
        return new ResponseEntity<>(classService.updateClass(classRequest,id), HttpStatus.OK);
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<HttpStatus> deleteClass(@PathVariable("id") long id) {
        classService.deleteClassById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/teachers/{t_id}/classes")
    public ResponseEntity<HttpStatus> deleteAllClassesOfTeacher(@PathVariable(value = "t_id") Long id) {
        classService.deleteAllClassesOfTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
