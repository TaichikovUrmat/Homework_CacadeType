package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.DatabaseConnection;
import java12.dao.AddressesDao;
import java12.entit.Addresses;
import java12.entit.Companies;

import java.util.List;
import java.util.Optional;

public class AddressesDaoImpl implements AddressesDao {
   EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManager();

    @Override
    public String saveAddresses(Addresses addresses) {
        EntityManager entityManager  = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(addresses);
        entityManager.getTransaction().commit();
        entityManager.close();
        return addresses.getCountry();
    }

    @Override
    public Addresses getAddressesByID(Long addressesId) {
//        EntityManager entityManager = null;
//        try {
//            entityManager = entityManagerFactory.createEntityManager();
//            entityManager.getTransaction().begin();
//            Addresses addresses = entityManager.find(Addresses.class, addressesId);
//            entityManager.getTransaction().commit();
//            return addresses;
//        } catch (Exception e) {
//            if (entityManager != null && entityManager.getTransaction().isActive()) {
//                entityManager.getTransaction().rollback();
//            }
//            // Логирование ошибки
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (entityManager != null) {
//                entityManager.close();
//            }
//        }
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Addresses addresses = entityManager.find(Addresses.class, addressesId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return addresses;
    }

    @Override
    public List<Addresses> getAllAddresses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Addresses> resultList = entityManager.createQuery("select  a from Addresses  a ").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }


    @Override
    public String updateAddresses(Long oldAddresses, Addresses newAddresses) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            int i = entityManager.createNativeQuery("update Addresses set country = ?1 where id = ?2", Addresses.class)
                    .setParameter(1, newAddresses.getCountry())
                    .setParameter(2, oldAddresses)
                    .executeUpdate();

            entityManager.getTransaction().commit();
            if (i > 0) return "success";
            else return "error";
        }catch (RuntimeException e){
            return e.getMessage();
        } finally {
            entityManager.close();
        }
   }

    @Override
    public String deleteAddresses(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Addresses addresse = entityManager.find(Addresses.class, id);

            Companies companies = addresse.getCompanies();
            if (companies != null) companies.setAddresses(null);

            if (addresse != null){
                entityManager.remove(addresse);
                entityManager.getTransaction().commit();
            }

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            return e.getMessage();
        }finally {
            entityManager.close();
       }
        return  "Address deleted";
    }

    @Override
    public Optional<Addresses> findByID(Long addressesId) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Addresses addresses = null;
        try {
            entityManager.getTransaction().begin();

            addresses = entityManager
                    .createQuery("select a from Addresses  a where a.id = :addId",Addresses.class)
                    .setParameter("addId",addressesId)
                    .getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){

            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }

        return Optional.ofNullable(addresses);

    }
}
