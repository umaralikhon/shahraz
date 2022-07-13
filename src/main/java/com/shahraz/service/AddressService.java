package com.shahraz.service;

import com.shahraz.model.Address;

import java.util.List;

public interface AddressService {

    void saveAll(List<Address> addresses);
    Address save(Address address);
    List<Address> findAll();
    Address findById(long id);
}
