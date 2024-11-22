package com.co.maradiago.usuarios.service;

import com.co.maradiago.usuarios.entity.Student;
import com.maradiago.MicroservicioSpringCommons.service.CommonService;


public interface StudentService extends CommonService<Student> {

    public Student save(Student student);
    public void deleteById(Long id);
}
