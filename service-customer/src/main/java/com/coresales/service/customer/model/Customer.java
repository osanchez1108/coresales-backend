package com.coresales.service.customer.model;
import  jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name="Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClienteId")
    private Long id;
    @Column(name="TipoDocumentoId", nullable = false, length =  20)
    private Integer tipoDocumento;
    @Column(name="NumeroDocumento", nullable = false, length = 20)
    private String numeroDocumento;
    @Column(nullable = true, length = 100)
    private String nombres;
    @Column(nullable = true, length = 100)
    private String apellidos;
    @Column(nullable = true, length = 150)
    private String razonSocial;
    @Column(length = 150)
    private String email;
    @Column(length = 20)
    private String telefono;
    @Column(length = 250)
    private String direccion;
    @Column(nullable = false)
    private Boolean activo = true;
    @Column(name="FechaRegistro", nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public  void prePersist(){
        fechaRegistro = LocalDateTime.now();
    }
}
