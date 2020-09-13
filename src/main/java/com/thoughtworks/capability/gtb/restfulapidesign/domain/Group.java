package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private Integer id;
    private String name;
    private String note;
    private List<Student> students;

    public Group(int id) {
        this.id = id;
        this.students = new ArrayList<>();
        this.name = String.format("Team %d", id);
    }

    public void clear() {
        students.clear();
    }

    public void add(Student student) {
        students.add(student);
    }
}
