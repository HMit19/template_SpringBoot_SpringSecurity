package com.example.spring_security_boot.service;

import java.util.Optional;

public interface IGeneralService<T> {
    // giao diện này có tác dụng là chung cho các service khác,
    // Ta chỉ cần khai báo interface này và implements vào các service khác rồi override lại các phương thức.
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    Boolean save(T t);

    Boolean remove(Long id);
}
