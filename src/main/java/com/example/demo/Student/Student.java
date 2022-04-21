package com.example.demo.Student;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "Sequence_Student",allocationSize = 1,sequenceName ="Sequence_Student")
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "Sequence_Student" )
             private Long Id;
             private String name;
             private LocalDate dob;
             private String email;
             @Transient
             private Integer age;



    public Student(long id, String name, LocalDate dob, String email) {
        Id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;

    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;

    }

    public Student() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

