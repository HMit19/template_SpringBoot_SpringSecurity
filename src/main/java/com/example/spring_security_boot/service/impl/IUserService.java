package com.example.spring_security_boot.service.impl;

import com.example.spring_security_boot.model.User;
import com.example.spring_security_boot.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService, IGeneralService<User> {
}
