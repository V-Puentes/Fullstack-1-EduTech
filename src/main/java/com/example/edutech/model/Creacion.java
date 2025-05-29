package com.example.edutech.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Creacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length = 13, nullable=false)
    private int idPerfil;

    @Column(nullable=false)
    private String nombreUsuario;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = true)
    private String clave;

    @Column(nullable = true)
    private Date fechaCreacion;

}