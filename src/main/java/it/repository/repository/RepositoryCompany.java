package it.repository.repository;

import it.model.Company;

import java.util.List;

public interface RepositoryCompany {
    void save(Company company);
    void update(Company company, int id);
    void delete(int id);
    List<Company> findAll();
    Company findById(int id);

}