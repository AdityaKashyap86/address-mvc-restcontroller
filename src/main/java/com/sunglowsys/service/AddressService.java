package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    Address update(Address address);

    List<Address> findAll();

    Address findByID(Long id);

    void delete (Long id);

}
