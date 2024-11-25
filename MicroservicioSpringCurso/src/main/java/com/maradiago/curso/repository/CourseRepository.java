package com.maradiago.curso.repository;

import com.maradiago.common.usuario.models.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
