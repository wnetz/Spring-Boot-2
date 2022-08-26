package com.example.demo.service.impl;

import com.example.demo.entity.Class;
import com.example.demo.entity.Teacher;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService
{
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Class createClases(Class clas,long tID) {
        Teacher teacher = teacherRepository.findById(tID).orElseThrow(()->new ResourceNotFoundException("Teacher","Id",tID));
        clas.setTeacher(teacher);
        return  classRepository.save(clas);
    }

    @Override
    public List<Class> getAllClasses()
    {
        return classRepository.findAll();
    }

    @Override
    public List<Class> getAllClassesByTeacherId(long id) {
        if (!teacherRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Teacher","Id",id);
        }
        return classRepository.findByTeacherId(id);
    }

    @Override
    public Class getClassById(long id)
    {
        return classRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Class","Id",id));
    }

    @Override
    public Class updateClass(Class clas, long id) {
        Class e = getClassById(id);
        e.setClassNumber(clas.getClassNumber());
        e.setClassName(clas.getClassName());
        e.setMaxStudents(clas.getMaxStudents());
        return classRepository.save(e);
    }

    @Override
    public void deleteClassById(long id)
    {
        classRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Class","Id",id));
        classRepository.deleteById(id);
    }

    @Override
    public void deleteAllClassesOfTeacher(long id)
    {
        if (!teacherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Teacher","Id",id);
        }
        classRepository.deleteByTeacherId(id);
    }

}
