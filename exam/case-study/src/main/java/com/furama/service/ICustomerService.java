package com.furama.service;

import com.furama.model.person.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllCustomer(String name, String phone, String email, Pageable pageable);

    Customer findCustomerById(int id);

    void saveCustomer(Customer customer);

    void removeCustomerById(int id);
}
