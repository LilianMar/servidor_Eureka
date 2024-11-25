package com.maradiago.curso.service;

import com.maradiago.MicroservicioSpringCommons.service.CommonServiceImpl;
import com.maradiago.common.usuario.models.entity.Course;
import com.maradiago.curso.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CourseService {


    }

