package com.example.edutech.model;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo del microservicio que almacena los datos de cada usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID asociado al usuario", example = "1")
    private Integer id;

    @Column(unique=true, nullable=true)
    @Schema(
        description = "RUN del usuario con guión y sin puntos",
        example = "12345678-9",
        minLength = 8,
        maxLength = 10,
        required = true
    )
    private String run;

    @Column(nullable=false)
    @Schema(
        description = "Nombre(s) del usuario", 
        example = "Pedro Pablo",
        required = true
    )
    private String nombre;

    @Column(nullable = false)
    @Schema(
        description = "Apellido(s) del usuario", 
        example = "Perez Paredes",
        required = true
    )
    private String apellido;

    @Column(nullable = true)
    @Schema(
        description = "Fecha de nacimiento", 
        example = "1990-05-15",
        type = "string",
        format = "date"
    )
    private Date fechaNacimiento;

    @Column(nullable = false)
    @Schema(
        description = "Rol del usuario en el sistema",
        example = "ESTUDIANTE",
        allowableValues = {"ADMINISTRADOR", "PROFESOR", "ESTUDIANTE","GERENTE","SOPORTE"},
        required = true
    )
    private String rol;
}