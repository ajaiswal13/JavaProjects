package com.microservices.Student.controller;

import com.microservices.Student.model.Student;
import com.microservices.Student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
         studentService.saveStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/school/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentsBySchoolId(@PathVariable Integer schoolId){
        return studentService.getStudentsBySchoolId(schoolId);
    }

}
