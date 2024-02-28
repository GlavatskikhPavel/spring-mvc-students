package ru.glavatskikh.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.glavatskikh.model.Group;
import ru.glavatskikh.repository.GroupRepository;
import ru.glavatskikh.services.GroupServices;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServicesImpl implements GroupServices {
    private final GroupRepository groupRepository;

    public void save(Group group) {
        log.info("Save Group: {}", group);
        groupRepository.save(group);
    }
}
