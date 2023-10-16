package dev.tber.springbootmongodb.services.impl;

import dev.tber.springbootmongodb.exceptions.ExistingStudentException;
import dev.tber.springbootmongodb.exceptions.StudentNotFoundException;
import dev.tber.springbootmongodb.models.documents.Student;
import dev.tber.springbootmongodb.repositories.StudentRepository;
import dev.tber.springbootmongodb.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id "+id));
    }

    @Override
    public Student getStudentByFirstname(String firstname) {
        return studentRepository.findByFirstname(firstname)
                .orElseThrow(()->new StudentNotFoundException("Student not found with firstname "+firstname));
    }

    @Override
    public Student addStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findByFirstname(student.getFirstname());
        if(studentOptional.isPresent()){
            throw new ExistingStudentException("student exists with this firstname "+student.getFirstname());
        }
        return studentRepository.save(student);
    }
}
