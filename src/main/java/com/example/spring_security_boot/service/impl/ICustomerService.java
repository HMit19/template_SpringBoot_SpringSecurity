package com.example.spring_security_boot.service.impl;

import com.example.spring_security_boot.model.Customer;
import com.example.spring_security_boot.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    // giao diện này dùng để kế thừa các phương thức của giao diện IGeneralService
}
