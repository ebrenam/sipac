package com.telmex.sipac.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telmex.sipac.backend.data.entity.Customer;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}
