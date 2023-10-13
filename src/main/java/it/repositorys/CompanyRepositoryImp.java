package it.repositorys;

import it.model.Company;
import it.repository.repository.RepositoryCompany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImp implements RepositoryCompany {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    @Override
    public void update(Company company, int id) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = session.get(Company.class, id);
        company1.setCompanyname(company.getCompanyname());
        company1.setLocatedcountry(company.getLocatedcountry());
        company1.setId(company.getId());
        session.merge(company1);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = session.get(Company.class, id);
        session.delete(company1);
    }

    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Company p", Company.class).getResultList();
    }

    @Override
    public Company findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }
}
