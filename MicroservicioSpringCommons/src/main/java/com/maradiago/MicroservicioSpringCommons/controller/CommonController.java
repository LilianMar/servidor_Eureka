package com.maradiago.MicroservicioSpringCommons.controller;


import com.maradiago.MicroservicioSpringCommons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class CommonController <E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("students", service.findAll());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listStudents(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/view")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<E> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody E entity){
        E studentDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDb);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
