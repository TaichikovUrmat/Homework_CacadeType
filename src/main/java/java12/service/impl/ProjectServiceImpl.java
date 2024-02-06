package java12.service.impl;

import java12.dao.CompaniesDao;
import java12.dao.ProjectDao;
import java12.dao.impl.CompaniesDaoImpl;
import java12.dao.impl.ProjectDaoImpl;
import java12.entit.Project;
import java12.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    ProjectDao projectDao = new ProjectDaoImpl();
    CompaniesDao companiesDao = new CompaniesDaoImpl();

    @Override
    public String saveProject(Project addProject) {
        return projectDao.saveProject(addProject);
    }

    @Override
    public String assignProjectToCompany(Long companyId, Long projectId) {
        return projectDao.assignProjectToCompany(companyId,projectId);
    }

    @Override
    public String saveProjects(Long companyId, Project projects) {
        return projectDao.saveProjects(companyId,projects);
    }

    @Override
    public Project getProjectByID(Long getProject) {
        return null;
    }

    @Override
    public List<Project> getAllProject() {
        return null;
    }

    @Override
    public String updateProject(Long oldProject, Project newProject) {
        return null;
    }

    @Override
    public String deleteProject(Long projectID) {
        return null;
    }

}
