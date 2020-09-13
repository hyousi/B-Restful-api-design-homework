package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository {

    private static final int GROUP_NUMBER = 6;

    @Autowired
    private StudentRepository studentRepository;

    private List<Group> groups;

    public GroupRepository() {
        groups = new ArrayList<>();
        for (int i = 0; i < GROUP_NUMBER; i++) {
            Group group = new Group(i);
            groups.add(group);
        }
    }


    public List<Group> findAll() {
        List<Student> studentList = studentRepository.findAll();
        Collections.shuffle(studentList);

        for (Group group : groups) {
            group.clear();
        }

        int index = 0;
        for (Student student : studentList) {
            groups.get(index).add(student);
            index = (index + 1) % GROUP_NUMBER;
        }

        return groups;
    }
}
