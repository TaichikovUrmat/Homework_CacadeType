package java12.dao;

import java12.entit.Companies;
import java12.entit.Project;

import java.util.List;

public interface ProjectDao {
    String saveProject( Project addProject);

    String assignProjectToCompany(Long companyId, Long projectId);
    String saveProjects(Long companyId, Project projects);
    Project getProjectByID(Long getProject);
    List<Project> getAllProject();
    String updateProject(Long oldProject, Project newProject);
    String deleteProject(Long projectID);
}
