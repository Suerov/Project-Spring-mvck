package it.repository.repository;


import it.model.Student;

import java.util.List;

public interface RepositoryStudent {
    void save(Student student);
    void update(Student student, int id);
    void delete(int id);

    List<Student> findAll();
    Student findById(int id);
}
