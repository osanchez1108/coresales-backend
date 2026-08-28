package com.coresales.service.product.Service;

import com.coresales.service.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listar();
    Product obtenerPorId(Long Id);
    Product crear(Product product);
    Product actualizar(Long id, Product product);
    void eliminar(Long id);
}
