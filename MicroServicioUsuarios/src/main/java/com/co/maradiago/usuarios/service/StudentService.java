package com.co.maradiago.usuarios.service;

import com.maradiago.MicroservicioSpringCommons.service.CommonService;
import com.maradiago.common.usuario.models.entity.Student;


public interface StudentService extends CommonService<Student> {

    public Student save(Student student);
    public void deleteById(Long id);
}
