package dev.tber.springbootmongodb.utils;

import dev.tber.springbootmongodb.models.documents.Student;
import dev.tber.springbootmongodb.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class SaveOperationRunner implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final MongoTemplate mongoTemplate;

    public SaveOperationRunner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        this.studentRepository = studentRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.getDb().drop();
        Student student1 = Student.builder().firstname("TBER").lastname("Mohamed Reda").age(24).build();
        Student student2 = Student.builder().firstname("HAJJAMI").lastname("Reda").age(23).build();
        studentRepository.save(student1);
        studentRepository.save(student2);
    }
}


