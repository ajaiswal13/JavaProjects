package com.microservices.Student.service;

import com.microservices.Student.model.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student student);
    public List<Student> getAllStudents();
    public List<Student> getStudentsBySchoolId(Integer schoolId);
}
