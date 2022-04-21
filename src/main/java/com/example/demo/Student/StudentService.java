package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> GetStudent() {
        return studentRepository.findAll();
    }

    public void AddNewStudent(Student student) {
        Optional<Student> StudentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (StudentByEmail.isPresent()){
            throw new IllegalStateException("Taken") ;
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
      boolean exists = studentRepository.existsById(studentId);
      if (!exists){
          throw new IllegalStateException("The student with id : "+studentId+ " does not exist");
      }
    studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException(" student"+studentId+"does not exixst"));
  if(name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
      student.setName(name);
  }
    }
}
