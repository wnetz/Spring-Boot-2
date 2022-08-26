package com.example.demo.service;

import com.example.demo.entity.Class;

import java.util.List;

public interface ClassService
{
    Class createClases(Class clas, long tID);
    List<Class> getAllClasses();
    List<Class> getAllClassesByTeacherId(long id);
    Class getClassById(long id);
    Class updateClass(Class clas, long id);
    void deleteClassById(long id);
    void deleteAllClassesOfTeacher(long id);
}
