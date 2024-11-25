package com.co.maradiago.usuarios.repository;

import com.maradiago.common.usuario.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Long> {
}
