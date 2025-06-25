package com.example.edutech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.edutech.model.Perfil;
import com.example.edutech.repository.PerfilRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;

@Service
@Tag(name = "Servicio de Perfiles",
description = "Contiene la lógica para gestionar de perfiles de usuario")
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Operation(
        summary = "Obtener lista de perfiles",
        description = "Retorna una lista con los perfiles registrados")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de perfiles obtenida exitosamente",
        content = @Content(schema = @Schema(implementation = Perfil.class)))
    public List<Perfil> obtenerPerfiles() {
        return perfilRepository.obtenerPerfiles();
    }

    @Operation(
        summary = "Buscar perfil según ID",
        description = "Recupera el perfil correspondiente a la Id ingresada")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Perfil encontrado",
            content = @Content(schema = @Schema(implementation = Perfil.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Perfil no encontrado")
    })
    public Perfil buscarPorId(
        @Parameter(
            description = "ID del perfil",
            example = "1",
            required = true)
        int id
    ) {
        return perfilRepository.buscarPorId(id);
    }

    @Operation(summary = "Registrar nuevo perfil",
    description = "Crea y almacena un nuevo perfil en el sistema")
    @ApiResponses(value = {
        @ApiResponse(
        responseCode = "400",
        description = "Perfil creado exitosamente",
        content = @Content(schema = @Schema(implementation = Perfil.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Datos del perfil inválidos")
    })
    public Perfil guardar(
        @Parameter(
        description = "Datos del perfil a registrar",
        required = true)
        Perfil perfil
    ) {
        return perfilRepository.guardar(perfil);
    }

    @Operation(
        summary = "Actualizar perfil existente",
        description = "Modifica los datos de un perfil registrado")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "500",
            description = "Perfil actualizado exitosamente",
            content = @Content(schema = @Schema(implementation = Perfil.class))),
        @ApiResponse(responseCode = "404", description = "Perfil no encontrado")
    })
    public Perfil actualizar(
        @Parameter(
            description = "Datos actualizados del perfil",
            required = true)
        Perfil perfil
    ) {
        return perfilRepository.actualizar(perfil);
    }

    @Operation(
        summary = "Eliminar perfil",
        description = "Elimina el perfil correspondiente al Id ingresado")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "600",
            description = "Perfil eliminado exitosamente"),
        @ApiResponse(
            responseCode = "404",
            description = "Perfil no encontrado")
    })
    public void eliminar(
        @Parameter(
            description = "ID del perfil a eliminar",
            example = "1", required = true)
        int id
    ) {
        perfilRepository.eliminar(id);
    }
}