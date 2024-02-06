package java12.dao;

import java12.entit.Addresses;
import java12.entit.Companies;

import java.util.List;
import java.util.Optional;

public interface CompaniesDao {
    // crud

    // creat
    String saveCompanies(Companies addcompanies);
    Companies getCompaniesByID(Long getCompanies);
    List<Companies> getAllCompanies();
    String updateCompanies(Long oldCompanies, Companies newCompanies);
    String deleteCompanies(Long CompaniesID);

    String assignCompanyToAddress( Companies companiesId,Addresses addressesId);

    Optional<Companies> findByID(Long companiesId);


}
