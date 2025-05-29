package com.example.edutech.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length = 13, nullable=false)
    private String run;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = true)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String rol;

}