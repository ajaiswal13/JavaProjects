package com.microservices.School.controller;

import com.microservices.School.model.FullSchoolResponse;
import com.microservices.School.model.School;
import com.microservices.School.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchool(@RequestBody School school){
        schoolService.saveSchool(school);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAllSchools(){
        return schoolService.getAllSchools();
    }

    @GetMapping("/with-students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public FullSchoolResponse getSchoolsWithStudents(@PathVariable Integer studentId) {

        return schoolService.getSchoolsWithStudents(studentId);
    }
}
