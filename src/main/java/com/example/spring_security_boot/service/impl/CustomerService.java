package com.example.spring_security_boot.service.impl;

import com.example.spring_security_boot.model.Customer;
import com.example.spring_security_boot.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

// Các bước để tạo một class service
// 1. Khai báo class là một service
// 2. Thêm annotation @Service vào class service
// 3. Thêm annotation @Autowired vào các thuộc tính dùng để gọi các phương thức của giao diện khác
// 4. Tạo các phương thức để xử lý các request từ client
// 5. Thêm annotation @Transactional để đánh dấu các phương thức cần được quản lý bởi transaction

@Service
@Transactional
public class CustomerService implements ICustomerService {
    // class này dùng để implements các phương thức của giao diện ICustomerService và override lại các phương thức đó.
    // Ta có thể thêm các phương thức khác vào class này.

    @Autowired
    private ICustomerRepository customerRepository;
    // dùng để gọi các phương thức của giao diện ICustomerRepository để thao tác với database.

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Boolean save(Customer customer) {
        customerRepository.save(customer);
        return false;
    }

    @Override
    public Boolean remove(Long id) {
        customerRepository.deleteById(id);
        return false;
    }

}
