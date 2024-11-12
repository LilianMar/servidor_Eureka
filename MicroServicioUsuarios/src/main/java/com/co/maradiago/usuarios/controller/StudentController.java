package com.co.maradiago.usuarios.controller;

import com.co.maradiago.usuarios.entity.Student;
import com.co.maradiago.usuarios.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<?> listStudents(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Student> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student){
        Student studentDb = service.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDb);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> modify(@RequestBody Student student, @PathVariable Long id){
        Optional<Student> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Student studentBd = ob.get();
        studentBd.setName(student.getName());
        studentBd.setLastName(student.getLastName());
        studentBd.setEmail(student.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentBd));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
