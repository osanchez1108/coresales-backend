package com.coresales.service.brand.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Marca")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MarcaId")
    Integer marcaId;
    @Column(name="Nombre", length = 100, nullable = false)
    String nombre;

    @Column(name="Activo", nullable = false)
    Boolean activo;

}
