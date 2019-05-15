package com.uetcodecamp.hibernateexample6.controller;

import com.uetcodecamp.hibernateexample6.model.Student;
import com.uetcodecamp.hibernateexample6.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("")
    public List<Student> getAllStudent(@RequestParam("name") String name){
//        return studentRepository.findAll();
//        return studentRepository.findByName(name);
        return studentRepository.findByNameContains(name);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentRepository.getOne(id);
    }

    @PostMapping("")
    public Student addNewStudentById(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("")
    public Student updateStudentById(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            logger.error("Student not found!!!");
            return;
        }

        studentRepository.delete(student.get());
    }

}
