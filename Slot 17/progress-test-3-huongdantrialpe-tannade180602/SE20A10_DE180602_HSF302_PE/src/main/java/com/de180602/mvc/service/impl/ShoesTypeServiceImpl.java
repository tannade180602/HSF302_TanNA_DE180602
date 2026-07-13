package com.de180602.mvc.service.impl;

import com.de180602.mvc.entity.ShoesType;
import com.de180602.mvc.repository.ShoesTypeRepository;
import com.de180602.mvc.service.ShoesTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoesTypeServiceImpl implements ShoesTypeService {

    private final ShoesTypeRepository shoesTypeRepository;

    public ShoesTypeServiceImpl(ShoesTypeRepository shoesTypeRepository) {
        this.shoesTypeRepository = shoesTypeRepository;
    }

    @Override
    public List<ShoesType> getAll() {
        return shoesTypeRepository.findAll();
    }
}
