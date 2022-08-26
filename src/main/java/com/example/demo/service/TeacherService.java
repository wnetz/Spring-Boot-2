package com.example.demo.service;

import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService
{
    Teacher saveTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(long id);
    Teacher updateTeacher(Teacher teacher, long id);
    void deleteTeacher(long id);
}
