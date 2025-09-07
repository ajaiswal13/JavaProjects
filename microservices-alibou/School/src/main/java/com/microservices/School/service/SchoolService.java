package com.microservices.School.service;



import com.microservices.School.model.FullSchoolResponse;
import com.microservices.School.model.School;

import java.util.List;

public interface SchoolService {
    public void saveSchool(School school);
    public List<School> getAllSchools();
    public FullSchoolResponse getSchoolsWithStudents(Integer schoolId);
}
