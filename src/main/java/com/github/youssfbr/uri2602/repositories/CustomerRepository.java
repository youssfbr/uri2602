package com.github.youssfbr.uri2602.repositories;

import com.github.youssfbr.uri2602.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
