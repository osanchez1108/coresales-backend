package com.coresales.service.customer.Repository;

import com.coresales.service.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByNumeroDocumento(String  numeroDocumento);
    boolean existsByNumeroDocumento(String numeroDocumento);
}
