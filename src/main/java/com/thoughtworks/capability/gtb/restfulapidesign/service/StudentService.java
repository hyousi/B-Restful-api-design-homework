package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void remove(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAll(Gender gender) {
        if (gender == null) {
            return studentRepository.findAll();
        }

        return studentRepository.findAllByGender(gender);
    }

    public Student update(int id, Student student) {
        return studentRepository.updateById(id, student);
    }
}
