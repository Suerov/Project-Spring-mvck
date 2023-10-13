package it.repository.repository;

import it.model.Student;
import it.model.Teacher;

import java.util.List;

public interface RepositoryTeacher {
    void save(Teacher teacher);

    void update(Teacher teacher, int id);

    void delete(int id);

    List<Teacher> findAll();

     Teacher findById(int id);
}
