package com.furama.service.impl;

import com.furama.model.customer.Customer;
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
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
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
