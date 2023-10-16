package dev.tber.springbootmongodb.services;

import dev.tber.springbootmongodb.models.documents.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);

    Student getStudentById(String id);

    Student getStudentByFirstname(String firstname);

    Student addStudent(Student student);
}
