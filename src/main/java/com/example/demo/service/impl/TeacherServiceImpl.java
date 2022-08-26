package com.example.demo.service.impl;

import com.example.demo.entity.Teacher;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository)
    {
        super();
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher)
    {
        return  teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers()
    {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(long id)
    {
        return teacherRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Teacher","Id",id));
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, long id) {
        Teacher e = getTeacherById(id);
        e.setEmail(teacher.getEmail());
        e.setFirstName(teacher.getFirstName());
        e.setLastName(teacher.getLastName());
        teacherRepository.save(e);
        return e;
    }

    @Override
    public void deleteTeacher(long id)
    {
        teacherRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Teacher","Id",id));
        teacherRepository.deleteById(id);
    }

}
