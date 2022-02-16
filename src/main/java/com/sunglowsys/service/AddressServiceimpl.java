package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceimpl implements AddressService{

    private final Logger log = LoggerFactory.getLogger (AddressServiceimpl.class);

    private final AddressRepository addressRepository;

    public AddressServiceimpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        log.debug ("REST program save successfully{}:",address);
        return addressRepository.save (address);
    }

    @Override
    public Address update(Address address) {
        log.debug ("REST program update successfully");
        return addressRepository.save (address);
    }

    @Override
    public List<Address> findAll() {
        log.debug ("REST program findAll successfully");
        return addressRepository.findAll ();
    }

    @Override
    public Address findByID(Long id) {
        log.debug ("program get successfully{}:",id);
        return addressRepository.getById (id);
    }

    @Override
    public void delete(Long id) {
        log.debug ("REST program delete successfully{}:",id);
        addressRepository.deleteById (id);

    }
}
