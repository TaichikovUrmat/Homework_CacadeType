package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.DatabaseConnection;
import java12.dao.CompaniesDao;
import java12.entit.Addresses;
import java12.entit.Companies;

import java.util.List;
import java.util.Optional;

public class CompaniesDaoImpl implements CompaniesDao {
    EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManager();

    @Override
    public String saveCompanies(Companies addcompanies) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(addcompanies);
        entityManager.getTransaction().commit();
        entityManager.close();
        return addcompanies.getName() + "Добавлен";
    }

    @Override
    public Companies getCompaniesByID(Long getCompanies) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Companies companies = entityManager.find(Companies.class, getCompanies);
        entityManager.getTransaction().commit();
        entityManager.close();
        return companies;
    }

    @Override
    public List<Companies> getAllCompanies() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Companies> selectCFromCompaniesC = entityManager.createQuery("select c from Companies c").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectCFromCompaniesC;
    }

    @Override
    public String updateCompanies(Long oldCompanies, Companies newCompanies) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            int i = entityManager.createNativeQuery("update Companies set name = ?1 where id = ?2", Companies.class)
                    .setParameter(1, newCompanies.getName())
                    .setParameter(2, oldCompanies)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            if (i > 0 ) return "success";
            else return "error";
        }catch (RuntimeException e){
           return e.getMessage();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteCompanies(Long CompaniesID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Companies companies = entityManager.find(Companies.class, CompaniesID);
            entityManager.remove(companies);
             entityManager.getTransaction().commit();
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            return  e.getMessage();
        }finally {
            entityManager.close();
        }
        return "Companies delete";
    }

    @Override
    public String assignCompanyToAddress(Companies companiesId, Addresses addressesId) {
        return null;
    }

    @Override
    public Optional<Companies> findByID(Long companiesId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Companies companies = null;
        try {
            entityManager.getTransaction().begin();
            companies = entityManager
                    .createQuery("select c from Companies  c where c.id = ?1", Companies.class)
                    .setParameter(1, companiesId)
                    .getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return Optional.ofNullable(companies);
    }
}



