package com.furama.service;

import com.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    Customer findCustomerById(int id);

    void saveCustomer(Customer customer);

    void removeCustomerById(int id);
}
