package com.codegym.repository;

import com.codegym.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean insertWithStoreProcedure(Customer customer) {
        String sql = "Call Insert_Customer(:firstName,:lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        return query.executeUpdate() == 0;
    }
}
