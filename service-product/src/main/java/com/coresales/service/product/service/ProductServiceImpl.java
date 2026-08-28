package com.coresales.service.product.service;

import com.coresales.service.product.repository.ProductRepository;
import com.coresales.service.product.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
        return new ArrayList<>(productRepository.listarProducto());
    }

    @Override
    @Transactional(readOnly = true)
    public Product obtenerPorId(Long id) {
        return productRepository.obtenerPorIdProducto(id);
    }

    @Override
    public Product crear(Product producto) {
        return  productRepository.save(producto);
    }

    @Override
    public Product actualizar(Long id, Product producto) {
        Product productoBuscar = obtenerPorId(id);
        if(productoBuscar == null)  return null;

        producto.setFechaRegistro(productoBuscar.getFechaRegistro());
        Product actProducto = productRepository.save(producto);

        return actProducto;
    }

    @Override
    public void eliminar(Long id) {
        productRepository.eliminaProducto(id);
    }
}
