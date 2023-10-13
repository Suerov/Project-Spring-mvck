package it.repository.repository;

import it.model.Company;
import it.model.Group;

import java.util.List;

public interface RepositoryGroup {
    void save(Group group);
    void update(Group group, int id);
    void delete(int id);
    List<Group> findAll();
    Group findById(int id);
}
