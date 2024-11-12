package com.co.maradiago.usuarios.service;

import com.co.maradiago.usuarios.entity.Student;

import java.util.Optional;

public interface StudentService {

    public Iterable<Student> findAll();
    public Optional<Student> findById(Long id);
    public Student save(Student student);
    public void deleteById(Long id);
}
