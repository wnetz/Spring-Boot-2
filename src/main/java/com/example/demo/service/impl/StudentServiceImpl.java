package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository)
    {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student)
    {
        return  studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id)
    {
        return studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student e = getStudentById(id);
        e.setEmail(student.getEmail());
        e.setFirstName(student.getFirstName());
        e.setLastName(student.getLastName());
        studentRepository.save(e);
        return e;
    }

    @Override
    public void deleteStudent(long id)
    {
        studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
        studentRepository.deleteById(id);
    }

}
