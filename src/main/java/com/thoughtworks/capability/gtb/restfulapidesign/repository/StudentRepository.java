package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student.Gender;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

    public void deleteById(int id) {
        Student student = findById(id);
        students.remove(student);
    }

    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public List<Student> findAllByGender(Gender gender) {
        return findAll().stream().filter(student -> student.getGender() == gender).collect(
            Collectors.toList());
    }

    public int size() {
        return students.size();
    }
}
