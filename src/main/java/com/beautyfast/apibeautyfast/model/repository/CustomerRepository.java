package com.beautyfast.apibeautyfast.model.repository;

import com.beautyfast.apibeautyfast.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
