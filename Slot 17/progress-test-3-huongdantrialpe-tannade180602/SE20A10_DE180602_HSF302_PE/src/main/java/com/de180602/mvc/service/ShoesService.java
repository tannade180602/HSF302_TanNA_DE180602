package com.de180602.mvc.service;

import com.de180602.mvc.dto.ShoesDTO;
import java.util.List;

public interface ShoesService {
    List<ShoesDTO> getAll();

    List<ShoesDTO> search(String name);
}
