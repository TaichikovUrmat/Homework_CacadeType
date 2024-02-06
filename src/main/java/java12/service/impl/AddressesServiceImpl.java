package java12.service.impl;

import java12.dao.AddressesDao;
import java12.dao.CompaniesDao;
import java12.dao.impl.AddressesDaoImpl;
import java12.dao.impl.CompaniesDaoImpl;
import java12.entit.Addresses;
import java12.entit.Companies;
import java12.service.AddressesService;

import java.util.List;

public class AddressesServiceImpl implements AddressesService {
    AddressesDao addressesDao = new AddressesDaoImpl();
    CompaniesDao companiesDao = new CompaniesDaoImpl();
    @Override
    public String saveAddresses(Addresses addresses) {
        return addressesDao.saveAddresses(addresses);
    }

    @Override
    public Addresses getAddressesByID(Long addressesId) {
        return addressesDao.getAddressesByID(addressesId);
    }

    @Override
    public List<Addresses> getAllAddresses() {
        return addressesDao.getAllAddresses();
    }


    @Override
    public String updateAddresses(Long oldAddresses, Addresses newAddresses) {
        return addressesDao.updateAddresses(oldAddresses,newAddresses);
    }

    @Override
    public String deleteAddresses(Long id) {
        return addressesDao.deleteAddresses(id);
    }

    @Override
    public void save(Long AddressesId, Companies newCompanies) {
        Addresses addresses = addressesDao.findByID(AddressesId).orElseThrow(RuntimeException::new);
        addresses.setCompanies(newCompanies);
        newCompanies.setAddresses(addresses);
        companiesDao.saveCompanies(newCompanies);

    }




}
