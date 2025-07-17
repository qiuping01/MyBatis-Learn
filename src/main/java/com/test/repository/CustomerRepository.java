package com.test.repository;

import com.test.entity.Customer;

public interface CustomerRepository {
    public Customer getById(Integer id);
}
