package it.repositoryGroup;

import it.model.Group;
import it.repository.repository.RepositoryGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GroupRepositoryImp implements RepositoryGroup {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
    }

    @Override
    public void update(Group group, int id) {
        Session session = sessionFactory.getCurrentSession();
        Group group1 = session.get(Group.class, id);
        group1.setGroupname(group.getGroupname());
        group1.setDateofstart(group.getDateofstart());
        group1.setDateoffinish(group.getDateoffinish());

        session.merge(group1);

    }

    @Override
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
      Group group1=session.get(Group.class,id);
        session.delete(group1);
    }

    @Override
    public List<Group> findAll() {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("select d from Group d", Group.class).getResultList();
    }

    @Override
    public Group findById(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Group.class,id);
    }
}



