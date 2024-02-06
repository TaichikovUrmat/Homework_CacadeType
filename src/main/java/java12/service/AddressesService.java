package java12.service;

import java12.entit.Addresses;
import java12.entit.Companies;

import java.util.List;

public interface AddressesService {

    // crud

    // creat
    String saveAddresses(Addresses addresses);

    Addresses getAddressesByID(Long addressesId);
    List<Addresses> getAllAddresses();
    String updateAddresses(Long oldAddresses , Addresses newAddresses);

    String deleteAddresses(Long id);

    void save (Long AddressesId, Companies newCompanies);
}
