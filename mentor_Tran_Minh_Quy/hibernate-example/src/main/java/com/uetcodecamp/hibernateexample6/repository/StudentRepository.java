package com.uetcodecamp.hibernateexample6.repository;

import com.uetcodecamp.hibernateexample6.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// HQL
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByNameContains(String name);

}
