package com.codespeaks.hexagonal.service;

import java.util.List;
import java.util.Optional;

import com.codespeaks.hexagonal.domain.Customer;
import com.codespeaks.hexagonal.domain.MemeberStatus;
import com.codespeaks.hexagonal.exception.CustomerNotFoundException;
import com.codespeaks.hexagonal.repository.CustomerRepository;
import com.google.inject.Inject;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repo;

    @Inject
    public CustomerServiceImpl(CustomerRepository respository) {
        repo = respository;
    }

    public Customer registerCustomer(Customer customer) {

        return repo.CreateCustomer(customer);

    }

    public Customer upgradeCustomer(Customer customer) throws CustomerNotFoundException {

        if (customer.getStatus() == MemeberStatus.BRONZE) {
            customer.setStatus(MemeberStatus.SILVER);
        } else if (customer.getStatus() == MemeberStatus.SILVER) {
            customer.setStatus(MemeberStatus.GOLD);
        } else if (customer.getStatus() == MemeberStatus.GOLD) {
            customer.setStatus(MemeberStatus.GOLD);
        }

        return repo.UpdateCustomer(customer);

    }

    public Customer downgradeCustomer(Customer customer) throws CustomerNotFoundException {

        if (customer.getStatus() == MemeberStatus.BRONZE) {
            customer.setStatus(MemeberStatus.BRONZE);
        } else if (customer.getStatus() == MemeberStatus.SILVER) {
            customer.setStatus(MemeberStatus.BRONZE);
        } else if (customer.getStatus() == MemeberStatus.GOLD) {
            customer.setStatus(MemeberStatus.SILVER);
        }

        return repo.UpdateCustomer(customer);

    }

    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    public Optional<Customer> findCustomerById(int customerId) {
        // TODO Auto-generated method stub
        return repo.findCustomerById(customerId);
    }

}
