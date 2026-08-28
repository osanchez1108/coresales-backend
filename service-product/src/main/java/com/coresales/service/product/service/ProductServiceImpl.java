package com.coresales.service.product.Service;

import com.coresales.service.product.Repository.ProductRepository;
import com.coresales.service.product.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements  ProductService{
    private final ProductRepository productRepository;
    //==========================================
    // CONSTRUCTOR
    //==========================================
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //==========================================
    // MÉTODOS
    //==========================================
    @Override
    @Transactional(readOnly = true)
    public List<Product> listar() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Product obtenerPorId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product crear(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    @Override
    public Product actualizar(Long id, Product product) {
        return null;
    }

    @Override
    public void eliminar(Long id) {
        productRepository.deleteById(id);
    }
}
