package dev.tber.springbootmongodb.controllers;

import dev.tber.springbootmongodb.models.Requests.StudentRequest;
import dev.tber.springbootmongodb.models.documents.Student;
import dev.tber.springbootmongodb.services.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<Page<Student>> getStudents(Pageable pageable){
        log.info("Getting all users.");
        Page<Student> studentPage=studentService.getAllStudents(pageable);
        return ResponseEntity.ok(studentPage);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        log.info("Getting student with ID: {}.", id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @GetMapping("/byFirstname")
    public ResponseEntity<Student> getStudentByFirstname(@RequestParam String firstname) {
        log.info("Getting student with Firstname: {}.", firstname);
        Student student = studentService.getStudentByFirstname(firstname);
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentRequest studentRequest){
        log.info("Saving user.");
        Student student=Student.builder().firstname(studentRequest.getFirstname())
                .lastname(studentRequest.getLastname()).age(studentRequest.getAge()).build();
        Student newStudent=studentService.addStudent(student);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }
}
