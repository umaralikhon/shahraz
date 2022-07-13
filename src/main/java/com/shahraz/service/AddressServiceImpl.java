package com.shahraz.service;

import com.shahraz.model.Address;
import com.shahraz.service.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public void saveAll(List<Address> addresses) {
        addressRepository.saveAll(addresses);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(long id) {

        Address address = null;
        Optional<Address> optional = addressRepository.findById(id);
        if(optional.isPresent()){
            address = optional.get();
        }
        return address;
    }
}
