package com.codegym.service.impl;

import com.codegym.model.Country;
import com.codegym.repository.CountryRepository;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CountryImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Country findById(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }
}
