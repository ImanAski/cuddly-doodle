package com.example.monopoly.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() { return groupRepository.findAll(); }

    public Group getGroup(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            throw new IllegalArgumentException("Group not found");
        }
        return optionalGroup.get();
    }
    public Group createGroup(Group group) {
        Optional<Group> optionalGroup = groupRepository.findById(group.getId());
        if (optionalGroup.isPresent()) {
            throw new IllegalArgumentException("Group already exists");
        }
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            throw new IllegalArgumentException("Group not found");
        }
        groupRepository.delete(optionalGroup.get());
    }

    public void updateGroup(Group group) {
        Optional<Group> optionalGroup = groupRepository.findById(group.getId());
        if (optionalGroup.isEmpty()) {
            throw new IllegalArgumentException("Group not found");
        }
        groupRepository.save(group);
    }
}
