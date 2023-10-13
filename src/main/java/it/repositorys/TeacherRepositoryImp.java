package it.repositorys;

import it.model.Student;
import it.model.Teacher;
import it.repository.repository.RepositoryTeacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TeacherRepositoryImp implements RepositoryTeacher {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);

    }

    @Override
    public void update(Teacher teacher, int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = session.get(Teacher.class, id);
        teacher1.setEmail(teacher.getEmail());
        teacher1.setFirstname(teacher.getFirstname());
        teacher1.setLastname(teacher.getLastname());
        session.merge(teacher1);

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = findById(id);
        session.delete(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from Teacher r", Teacher.class).getResultList();
    }

    @Override
    public Teacher findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }
}
