package com.furama.repository;

import com.furama.model.person.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContainingOrPhoneOrEmail(String name, String phone, String email, Pageable pageable);
}
