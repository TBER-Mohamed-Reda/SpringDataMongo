package dev.tber.springbootmongodb.repositories;

import dev.tber.springbootmongodb.models.documents.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findByFirstname(String firstname);
}
