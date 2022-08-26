package com.example.demo.repository;

import com.example.demo.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long>
{
    @Query("FROM Class WHERE t_id = ?1")
    List<Class> findByTeacherId(Long postId);
    @Transactional
    void deleteByTeacherId(long teacherId);
}
