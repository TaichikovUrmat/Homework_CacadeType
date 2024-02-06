package java12.dao;

import java12.entit.Addresses;

import java.util.List;
import java.util.Optional;

public interface AddressesDao {
    // crud

    // creat
    String saveAddresses(Addresses addresses);

    Addresses getAddressesByID(Long addressesId);
    List<Addresses> getAllAddresses();
    String updateAddresses(Long oldAddresses , Addresses newAddresses);

    String deleteAddresses(Long id);

    Optional<Addresses> findByID(Long addressesId);


}
