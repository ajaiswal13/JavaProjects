package com.microservices.Student.repository;

import com.microservices.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
