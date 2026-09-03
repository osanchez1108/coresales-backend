package com.coresales.service.brand.service;

import com.coresales.service.brand.model.Brand;
import com.coresales.service.brand.repository.BrandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BrandServiceImpl implements  BrandService{
    private final BrandRepository marcaRepository;

    public BrandServiceImpl(BrandRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Brand> listar() {
        return new ArrayList<>(marcaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Brand obtenerId(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public Brand crear(Brand marca) {
        Brand newMarca = marcaRepository.save(marca);
        return newMarca;
    }

    @Override
    public Brand actualizar(Integer id, Brand marca) {
        Brand buscarMarca = obtenerId(id);
        if (buscarMarca == null) return  null;
        Brand editMarca = marcaRepository.save(marca);
        return  editMarca;
    }

    @Override
    public void eliminar(Integer id) {
        marcaRepository.deleteById(id);
    }
}
