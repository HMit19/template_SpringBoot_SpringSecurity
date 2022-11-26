package com.example.spring_security_boot.repository;

import com.example.spring_security_boot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    // giao diện này có sẵn các phương thức CRUD để thao tác với database, ta chỉ cần khai báo interface này là xong.
}
