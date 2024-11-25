package com.maradiago.common.usuario.models.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }
    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> listStudents;

    public Course() {
        this.listStudents = new ArrayList<>();
    }

    //getters y setters
    public List<Student> getListStudents() {
        return listStudents;
    }
    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
    public void addStudent(Student student) {
        this.listStudents.add(student);
    }
    public void removeStudent(Student student) {
        this.listStudents.remove(student);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


}
