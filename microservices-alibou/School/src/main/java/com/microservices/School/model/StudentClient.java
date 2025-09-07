package com.microservices.School.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="STUDENTS")
//If instead of making the services communicate with each other,you want to use api gateway
//to make the services communicate to each other,do the following
//@FeignClient(name="API-GATEWAY")
public interface StudentClient {

    @GetMapping("/api/student/school/{schoolId}") //This endpoint should be same as what used in
    //Studentcontroller's method
    List<Student> findStudentsBySchoolId(@PathVariable Integer schoolId);
}
