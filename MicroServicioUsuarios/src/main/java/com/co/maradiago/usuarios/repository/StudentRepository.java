package com.co.maradiago.usuarios.repository;

import com.co.maradiago.usuarios.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Long> {
}
