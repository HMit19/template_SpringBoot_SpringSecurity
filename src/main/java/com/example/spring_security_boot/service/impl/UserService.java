package com.example.spring_security_boot.service.impl;

import com.example.spring_security_boot.model.User;
import com.example.spring_security_boot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("userDetailsService")
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setUserRole(user.USER);
        try {
            userRepository.save(user);
            return true;
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            System.out.println("Error duplicate username when save user!");
        } catch (Exception e) {
            System.out.println("Error another when save user!");
        }
        return false;
    }

    @Override
    public Boolean remove(Long id) {
        userRepository.deleteById(id);
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

}
