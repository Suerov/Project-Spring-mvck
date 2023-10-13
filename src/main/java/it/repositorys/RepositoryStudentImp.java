package it.repositoryStudent;

import it.model.Company;
import it.model.Student;
import it.repository.repository.RepositoryStudent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RepositoryStudentImp implements RepositoryStudent {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);

    }

    @Override
    public void update(Student student, int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = session.get(Student.class, id);
        student1.setEmail(student.getEmail());
        student1.setFirstname(student.getFirstname());
        student1.setLastname(student.getLastname());
        student1.setStudentformat(student.getStudentformat());

        session.merge(student1);

    }

    @Override
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        Student student=session.get(Student.class,id);
        session.delete(student);
    }

    @Override
    public List<Student> findAll() {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("select f from Student f", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Student.class,id);
    }
}
