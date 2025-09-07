package com.microservices.Student.service.impl;

import com.microservices.Student.model.Student;
import com.microservices.Student.repository.StudentRepository;
import com.microservices.Student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsBySchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
