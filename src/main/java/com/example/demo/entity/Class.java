package com.example.demo.entity;
import jdk.jfr.Relational;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Class's")
public class Class
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@ManyToOne
    //@JoinColumn(name = "id")
    @Column(name = "T_id")
    private long teacher_id;
    @Column(name = "class_name", nullable = false)
    private String className;
    @Column(name = "class_number")
    private long classNumber;
    @Column(name = "max_students")
    private long max_students;
}
