package com.microservices.School.service.impl;

import com.microservices.School.model.FullSchoolResponse;
import com.microservices.School.model.School;
import com.microservices.School.model.Student;
import com.microservices.School.model.StudentClient;
import com.microservices.School.repository.SchoolRepository;
import com.microservices.School.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient; //do no use final keyword here or you won't be able
    //to run the application

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse getSchoolsWithStudents(Integer schoolId) {
       School school = schoolRepository.findById(schoolId).orElseThrow(()->new RuntimeException("School not found"));
       List<Student> studentList= studentClient.findStudentsBySchoolId(schoolId);
       return FullSchoolResponse.builder().
               name(school.getName())
               .email(school.getEmail())
               .studentList(studentList)
               .build();
    }
}
