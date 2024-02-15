package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //öğrenci yarat restapi
    @PostMapping
    public  Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //build student restapi
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        return ResponseEntity.ok(student);
    }

    //öğrenci güncelle restapi
    @PutMapping("{id}")
    public  ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setGrade(studentDetails.getGrade());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    //öğrenci silme
    @DeleteMapping("{id}")
    public  ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));

        studentRepository.delete(student);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
