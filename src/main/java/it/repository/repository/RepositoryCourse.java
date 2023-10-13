package it.repository.repository;

import it.model.Course;


import java.util.List;

public interface RepositoryCourse {
    void save(Course course);
    void update(Course course, int id);
    void delete(int id);
    List<Course> findAll();
    Course findById(int id);
}
