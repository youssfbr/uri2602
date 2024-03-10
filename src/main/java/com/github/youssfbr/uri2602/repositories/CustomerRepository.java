package com.github.youssfbr.uri2602.repositories;

import com.github.youssfbr.uri2602.dtos.CustomerMinDTO;
import com.github.youssfbr.uri2602.entities.Customer;
import com.github.youssfbr.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query( nativeQuery = true,
            value = "SELECT name "
            + "FROM customers "
            + "WHERE UPPER(state) = UPPER(:state)" )
    List<CustomerMinProjection> customerBySql(String state);

    @Query("SELECT new com.github.youssfbr.uri2602.dtos.CustomerMinDTO(obj.name) "
            + "FROM Customer obj "
            + "WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerMinDTO> customerByJpql(String state);

}
