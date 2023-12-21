package com.example.firstspring.service;

import com.example.firstspring.model.Student;

import java.util.List;

public interface IStudentService {
    void create(Student student);

    void update(Student student, Long id);

    void delete(Long id);

    List<Student> findAll();

    Student findById(Long id);

    List<Student> sortByAge();

    List<Student> findAllByGender(String gender);
}
