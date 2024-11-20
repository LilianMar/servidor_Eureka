package com.co.maradiago.usuarios.controller;



import com.co.maradiago.usuarios.entity.Student;
import com.co.maradiago.usuarios.service.StudentService;
import com.maradiago.MicroservicioSpringCommons.controller.CommonController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController extends CommonController<Student, StudentService> {


    @Value("${config.balanceador.test}")
    private String balanceadorTest;


     @GetMapping("/balanceador-test") public ResponseEntity<?> balanceadorTest() {
     Map<String, Object> response = new HashMap<String, Object>();
     response.put("balanceador", balanceadorTest);
     response.put("students", service.findAll());
     return ResponseEntity.ok().body(response);
     }

/**
   @GetMapping("/balanceador-test")
   public ResponseEntity<String> balanceadorTest() {
       return ResponseEntity.ok("balanceador");
   }**/

    @GetMapping("/list")
    public ResponseEntity<?> listStudents(){
        return ResponseEntity.ok().body(service.findAll());
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


}
