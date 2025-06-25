package com.example.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.edutech.model.Perfil;
import com.example.edutech.service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/v1/perfiles")
@Tag(
    name = "Gestión de Perfiles",
    description = "API para gestionar perfiles de usuario")
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @GetMapping
    @Operation(
        summary = "Generar lista con todos los perfiles registrados",
        description = "Obtiene los perfiles registrados en el sistema")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de perfiles obtenida exitosamente",
        content = @Content(schema = @Schema(implementation = Perfil.class, type = "array")))
    public List<Perfil> listarPerfiles() {
        return perfilService.obtenerPerfiles();
    }

    @PostMapping
    @Operation(
        summary = "Crear nuevo perfil",
        description = "Registra un nuevo perfil en el sistema")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Perfil creado exitosamente",
            content = @Content(schema = @Schema(implementation = Perfil.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Datos del perfil inválidos")
    })
    public Perfil agregarPerfil(
            @Parameter(
                description = "Perfil a crear",
                required = true,
                content = @Content(schema = @Schema(implementation = Perfil.class)))
            @RequestBody Perfil perfil) {
        return perfilService.guardar(perfil);
    }
    
    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar perfil según ID",
        description = "Obtiene el perfil correspondiente al Id ingresado")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Perfil encontrado",
                    content = @Content(schema = @Schema(implementation = Perfil.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Perfil no encontrado")
    })
    public Perfil buscarPerfil(
            @Parameter(
                description = "ID del perfil",
                example = "1",
                required = true)
            @PathVariable int id) {
        return perfilService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar perfil",
        description = "Modifica los datos de un perfil existente")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "500",
            description = "Perfil actualizado exitosamente",
            content = @Content(schema = @Schema(implementation = Perfil.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Perfil no encontrado"),
        @ApiResponse(
            responseCode = "404",
            description = "Datos del perfil inválidos")
    })
    public Perfil actualizarPerfil(
            @Parameter(
                description = "ID del perfil a actualizar",
                example = "1",
                required = true)
            @PathVariable int id,
            
            @Parameter(
                description = "Perfil Actualizado",
                required = true,
                content = @Content(schema = @Schema(implementation = Perfil.class)))
            @RequestBody Perfil perfil) {
        perfil.setId(id);
        return perfilService.actualizar(perfil);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar perfil",
        description = "Elimina el perfil correspondiente al id ingresado")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "600",
            description = "Perfil eliminado exitosamente"),
        @ApiResponse(
            responseCode = "404",
            description = "Perfil no encontrado")
    })
    public void eliminarPerfil(
            @Parameter(
                description = "ID del perfil a eliminar",
                example = "1", required = true)
            @PathVariable int id) {
        perfilService.eliminar(id);
    }
}