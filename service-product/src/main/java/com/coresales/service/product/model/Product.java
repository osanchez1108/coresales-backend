package com.coresales.service.product.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="Producto")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductoId", length = 30, nullable = false)
    private Long productId;

    @Column(name = "Codigo", length = 30, nullable = false)
    String codigo;

    @Column(name = "Nombre", length = 150, nullable = false)
    String nombre;

    @Column(name="Descripcion",length = 500, nullable = false)
    String descripcion;

    @Column(name="CategoriaProductoId", nullable = false)
    Integer categoriaProductoId;

    Integer marcaId;

    @Column(name="PrecioCompra", precision = 12, scale = 2)
    BigDecimal precioCompra;

    @Column(name="PrecioVenta", precision = 12, scale = 2)

    BigDecimal precioVenta;

    Integer stockMinimo;

    Boolean activo;
}
