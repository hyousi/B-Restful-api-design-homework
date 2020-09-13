package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/api/groups")
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PatchMapping("/api/groups/{id}")
    public Group updateGroupName(@PathVariable int id, @RequestBody Group group) {
        return groupService.updateGroupName(id, group);
    }

}
