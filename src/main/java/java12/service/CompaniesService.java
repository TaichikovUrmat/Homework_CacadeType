package java12.service;

import java12.entit.Addresses;
import java12.entit.Companies;
import java12.entit.Project;

import java.util.List;

public interface CompaniesService {
    // crud

    // creat
    String saveCompanies(Companies addcompanies);
    Companies getCompaniesByID(Long getCompanies);
    List<Companies> getAllCompanies();
    String updateCompanies(Long oldCompanies, Companies newCompanies);
    String deleteCompanies(Long CompaniesID);

    String assignCompanyToAddress( Companies companiesId,Addresses addressesId);


   // void  save (Long companiesId, Project projectId );
}
