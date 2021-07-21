package com.codegym.repository;

import com.codegym.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoreProcedure(Customer customer);
}
