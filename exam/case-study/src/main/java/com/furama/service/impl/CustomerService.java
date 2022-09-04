package com.furama.service.impl;

import com.furama.model.person.Customer;
import com.furama.repository.ICustomerRepository;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomer(String name, String phone, String email, Pageable pageable) {
        return iCustomerRepository.findAllByNameContainingOrPhoneOrEmail(name, phone, email, pageable);
    }

    @Override
    public Customer findCustomerById(int id) {
        return iCustomerRepository.findById(id).orElse(new Customer());
    }

    @Override
    public void saveCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void removeCustomerById(int id) {
        iCustomerRepository.deleteById(id);
    }
}
