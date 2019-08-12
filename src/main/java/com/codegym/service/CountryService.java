package com.codegym.service;

import com.codegym.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {
    Country findById(Long id);
    Page<Country> findAll(Pageable pageable);
}
