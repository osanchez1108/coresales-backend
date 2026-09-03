package com.coresales.service.brand.service;

import com.coresales.service.brand.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    List<Brand> listar();
    Brand obtenerId(Integer id);
    Brand crear(Brand marca);
    Brand actualizar(Integer id, Brand marca);
    void eliminar(Integer id);
}
