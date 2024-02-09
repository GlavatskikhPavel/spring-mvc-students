package ru.glavatskikh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.glavatskikh.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupByName(String name);
}
