package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import java12.config.DatabaseConnection;
import java12.dao.ProjectDao;
import java12.entit.Companies;
import java12.entit.Project;

import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
   EntityManagerFactory entityManagerFactory = DatabaseConnection.getEntityManager();
    @Override
    public String saveProject( Project addProject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(addProject);
        entityManager.getTransaction().commit();
        entityManager.close();
        return addProject + " добавлет !!";
    }
    @Override
    public String saveProjects(Long companyId, Project projects) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Companies company = entityManager.find(Companies.class, companyId);
            if (company == null) {
                return "Company with id" + companyId + " not found";
            }
            projects.setCompanies(company);
            entityManager.persist(projects);
            entityManager.getTransaction().commit();
            return "Successfully saved !" + company.getName();
        } catch (EntityNotFoundException e) {
            entityManager.getTransaction().rollback();
            return e.getMessage();
        }
    }

    @Override
    public Project getProjectByID(Long getProject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, getProject);
        entityManager.getTransaction().commit();
        entityManager.close();
        return project;
    }

    @Override
    public List<Project> getAllProject() {
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         entityManager.getTransaction().begin();
        List<Project> resultList = entityManager.createQuery("select p from Project p").getResultList();
        entityManager.getTransaction().commit();
         entityManager.close();
        return resultList;
    }
    @Override
    public String updateProject(Long oldProject, Project newProject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
           entityManager.getTransaction().begin();
            int i = entityManager
                    .createNativeQuery("update Project set title = ?1 where  id = ?2", Project.class)
                    .setParameter(1, newProject.getTitle())
                    .setParameter(2, oldProject)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            if (i > 0) return "success";
            else return "error";
        }catch (RuntimeException e){
           return e.getMessage();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public String deleteProject(Long projectID) {

        return null;
    }

    @Override
    public String assignProjectToCompany(Long companyId, Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Companies company = entityManager.find(Companies.class, companyId);
        Project projects = entityManager.find(Project.class, projectId);
        projects.setCompanies(company);
        entityManager.merge(projects);
        entityManager.getTransaction().commit();
        entityManager.close();
        return projects.getTitle();
    }
}
