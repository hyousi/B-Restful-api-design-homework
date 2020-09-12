package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private Set<Student> students;

    public StudentRepository() {
        students = new HashSet<>();
    }

    public void save(Student student) {
        student.setId(students.size());
        students.add(student);
    }

    public int size() {
        return students.size();
    }
}
