package com.de180602.mvc.service.impl;

import com.de180602.mvc.dto.ShoesDTO;
import com.de180602.mvc.entity.Shoes;
import com.de180602.mvc.entity.ShoesType;
import com.de180602.mvc.repository.ShoesRepository;
import com.de180602.mvc.repository.ShoesTypeRepository;
import com.de180602.mvc.service.ShoesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoesServiceImpl implements ShoesService {

    private final ShoesRepository shoesRepository;
    private final ShoesTypeRepository shoesTypeRepository;

    public ShoesServiceImpl(ShoesRepository shoesRepository, ShoesTypeRepository shoesTypeRepository) {
        this.shoesRepository = shoesRepository;
        this.shoesTypeRepository = shoesTypeRepository;
    }

    private ShoesDTO mapToDTO(Shoes shoes) {
        ShoesDTO dto = new ShoesDTO();
        dto.setShoesId(shoes.getShoesId());
        dto.setShoesNo(shoes.getShoesNo());
        dto.setShoesName(shoes.getShoesName());
        dto.setPrice(shoes.getPrice());
        dto.setTypeCode(shoes.getType());
        
        // Lookup type name
        shoesTypeRepository.findById(shoes.getType()).ifPresent(type -> {
            dto.setTypeName(type.getTypeName());
        });
        
        return dto;
    }

    @Override
    public List<ShoesDTO> getAll() {
        return shoesRepository.findAllByOrderByShoesNameAsc()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoesDTO> search(String name) {
        return shoesRepository.findByShoesNameContainingIgnoreCaseOrderByShoesNameAsc(name)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
