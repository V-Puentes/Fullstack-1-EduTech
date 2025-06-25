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

@Schema(description = "Modelo del microservicio de creación de perfiles para un usuarios")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    @Schema(description = "ID asociado al perfil", example = "1")
    private Integer id;

    @Column(nullable=false)
    @Schema(
        description = "Nombre de usuario",
        example = "Pedro Perez",
        required = true)
    private String nombreUsuario;

    @Column(nullable = false)
    @Schema(
        description = "Correo electrónico",
        example = "usuario@example.com",
        required = true)
    private String correo;

    @Column(nullable = false)
    @Schema(
        description = "Contraseña de la cuenta",
        example = "$2a$10$N9qo8uLO",
        required = true)
    private String clave;

    @Column(nullable = false)
    @Schema(
        description = "Fecha de creación de la cuenta",
        example = "2023-12-12",
        type = "string",
        format = "date",
        required = true
    )
    private Date fechaCreacion;

    @OneToOne(mappedBy = "perfil", cascade = CascadeType.ALL)
    private Usuario usuario;
}