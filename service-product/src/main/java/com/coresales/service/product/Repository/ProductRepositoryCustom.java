package com.coresales.service.product.Repository;

import com.coresales.service.product.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> listarProducto();
    Product obtenerPorIdProducto(Long id);
    Product crearProducto(Product product);
    Product actualziarProducto(Long id, Product product);
    void eliminaProducto(Long id);
}
