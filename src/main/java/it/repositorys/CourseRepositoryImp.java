package it.repositorys;

import it.model.Course;

import it.repository.repository.RepositoryCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class CourseRepositoryImp implements RepositoryCourse {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);

    }

    @Override
    public void update(Course course, int id) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = session.get(Course.class, id);
        course1.setCoursename(course.getCoursename());
        course1.setDuration(course.getDuration());
        session.merge(course1);

    }

    @Override
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
       Course course=session.get(Course.class,id);
        session.delete(course);

    }

    @Override
    public List<Course> findAll() {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("select g from Course g", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Course.class,id);
    }
}
