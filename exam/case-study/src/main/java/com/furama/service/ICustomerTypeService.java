package com.furama.service;

import com.furama.model.person.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();
}
