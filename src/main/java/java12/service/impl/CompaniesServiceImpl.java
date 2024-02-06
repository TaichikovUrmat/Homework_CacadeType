package java12.service.impl;

import java12.dao.AddressesDao;
import java12.dao.CompaniesDao;
import java12.dao.ProjectDao;
import java12.dao.impl.AddressesDaoImpl;
import java12.dao.impl.CompaniesDaoImpl;
import java12.dao.impl.ProjectDaoImpl;
import java12.entit.Addresses;
import java12.entit.Companies;
import java12.entit.Project;
import java12.service.CompaniesService;

import java.util.List;

public class CompaniesServiceImpl implements CompaniesService {
    CompaniesDao companiesDao = new CompaniesDaoImpl();
  ProjectDao projectDao = new ProjectDaoImpl();
    @Override
    public String saveCompanies(Companies addcompanies) {
        return companiesDao.saveCompanies(addcompanies);
    }

    @Override
    public Companies getCompaniesByID(Long getCompanies) {
        return companiesDao.getCompaniesByID(getCompanies);
    }

    @Override
    public List<Companies> getAllCompanies() {
        return companiesDao.getAllCompanies();
    }

    @Override
    public String updateCompanies(Long oldCompanies, Companies newCompanies) {
        return companiesDao.updateCompanies(oldCompanies,newCompanies);
    }

    @Override
    public String deleteCompanies(Long CompaniesID) {
        return companiesDao.deleteCompanies(CompaniesID);
    }

    @Override
    public String assignCompanyToAddress(Companies companiesId, Addresses addressesId) {
        return companiesDao.assignCompanyToAddress(companiesId,addressesId);
    }

  //  @Override
//    public void save(Long companiesId, Project projectId) {
//        Companies companies = companiesDao.findByID(companiesId).orElseThrow(RuntimeException::new);
//        companies.setProject(projectId);
//        projectId.setCompanies(companies);
//        projectDao.saveProject(projectId);
//    }

//    @Override
//    public void save(Long AddressesId, Companies newCompanies) {
//        Addresses addresses = addressesDao.findByID(AddressesId).orElseThrow(RuntimeException::new);
//        addresses.setCompanies(newCompanies);
//        newCompanies.setAddresses(addresses);
//        companiesDao.saveCompanies(newCompanies);
//
//    }
}



