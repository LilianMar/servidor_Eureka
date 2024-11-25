package com.maradiago.curso.controller;

import com.maradiago.MicroservicioSpringCommons.controller.CommonController;
import com.maradiago.common.usuario.models.entity.Student;
import com.maradiago.common.usuario.models.entity.Course;
import com.maradiago.curso.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

    @PostMapping("/{id}")
    public ResponseEntity<?> modify(@RequestBody Course course, @PathVariable Long id){
        Optional<Course> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Course courseBd = ob.get();
        courseBd.setName(course.getName());
        courseBd.setCreateAt(course.getCreateAt());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseBd));

    }

    @PutMapping("/{id}/add-student")
    public ResponseEntity<?> addStudent(@RequestBody List<Student> studentList, @PathVariable Long id){
        Optional<Course> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Course courseBd = ob.get();
        studentList.forEach(a -> {
            courseBd.addStudent(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseBd));
    }

    @PutMapping("/{id}/remove-student")
    public ResponseEntity<?> removeStudent(@RequestBody Student student, @PathVariable Long id){
        Optional<Course> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Course courseBd = ob.get();
        courseBd.removeStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseBd));
    }


}
