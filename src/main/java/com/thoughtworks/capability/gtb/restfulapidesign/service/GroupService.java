package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public Group updateGroupName(int id, Group group) {
        Group target = groupRepository.findById(id);
        if (target != null) {
            target.setName(group.getName());
            return target;
        }
        return null;
    }

    public Group get(int id) {
        return groupRepository.findById(id);
    }
}
