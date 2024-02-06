package java12;

import java12.config.DatabaseConnection;
import java12.entit.Addresses;
import java12.entit.Companies;
import java12.entit.Project;
import java12.service.AddressesService;
import java12.service.CompaniesService;
import java12.service.ProjectService;
import java12.service.impl.AddressesServiceImpl;
import java12.service.impl.CompaniesServiceImpl;
import java12.service.impl.ProjectServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AddressesService addressesService = new AddressesServiceImpl();

        CompaniesService companiesService = new CompaniesServiceImpl();

        ProjectService projectService = new ProjectServiceImpl();


        // AddressService

//          addressesService.saveAddresses(new Addresses("Kyrgystan"));
//          addressesService.saveAddresses(new Addresses("Osh"));
//          addressesService.saveAddresses(new Addresses("Naryn"));
//          addressesService.saveAddresses(new Addresses("Batken"));
     //   System.out.println(addressesService.getAddressesByID(1L));
     //   System.out.println(addressesService.getAllAddresses());
  //      System.out.println(addressesService.updateAddresses(3L, new Addresses("Talas")));
      //  System.out.println(addressesService.deleteAddresses(3L));
        //---------------------------------------------------------------------





        // Company Service
//          addressesService.save(5L,new Companies("Apple"));
//          addressesService.save(6L,new Companies("Peaksoft"));
//          addressesService.save(7L,new Companies("goole"));
//          addressesService.save(8L,new Companies("instagram"));
      //  System.out.println(companiesService.getCompaniesByID(1L));
     //   System.out.println(companiesService.getAllCompanies());
      //  System.out.println(companiesService.deleteCompanies(2L));

        ///  Project
        Project project = new Project();

     //   projectService.saveProject(new Project("Onlain-Store"));
        projectService.assignProjectToCompany(5L,1L);
    }
}
