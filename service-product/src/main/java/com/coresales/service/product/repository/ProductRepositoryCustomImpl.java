package com.coresales.service.product.repository;

import com.coresales.service.product.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

public class ProductRepositoryCustomImpl implements  ProductRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> listarProducto() {
        StoredProcedureQuery query =entityManager.createStoredProcedureQuery("usp_Producto_Listar",Product.class);
        query.execute();
        return query.getResultList();
    }

    @Override
    public Product obtenerPorIdProducto(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Producto_ObtenerPorId",Product.class);
        query.registerStoredProcedureParameter("ProductId", Long.class, ParameterMode.IN);
        query.setParameter("ProductId", id);
        query.execute();
        List<Product> listProductos = query.getResultList();
        return listProductos.isEmpty() ? null : listProductos.get(0);
    }

    @Override
    public Product crearProducto(Product product) {
        return null;
    }

    @Override
    public Product actualziarProducto(Long id, Product product) {
        return null;
    }

    @Override
    public void eliminaProducto(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usp_Venta_Eliminar", Product.class);
        query.registerStoredProcedureParameter("ProductId", Long.class, ParameterMode.IN);
        query.setParameter("ProductId",id);
        query.execute();
    }
}
