package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @DeleteMapping("/students/{id}")
    public void remove(@PathVariable int id) {
        studentService.remove(id);
    }

    @GetMapping("/students")
    public List<Student> getAll(@RequestParam(required = false) Gender gender) {
        return studentService.getAll(gender);
    }
}
