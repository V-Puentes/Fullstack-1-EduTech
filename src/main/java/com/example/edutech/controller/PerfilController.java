package com.example.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.edutech.model.Perfil;
import com.example.edutech.service.PerfilService;
import com.example.edutech.assembler.PerfilAssembler;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/perfiles")
@Tag(name = "Gestión de Perfiles", description = "API para gestionar perfiles de usuario")
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PerfilAssembler perfilAssembler;

    @GetMapping
    @Operation(summary = "Generar lista con todos los perfiles registrados")
    public ResponseEntity<CollectionModel<EntityModel<Perfil>>> listarPerfiles() {
        List<EntityModel<Perfil>> perfiles = perfilService.obtenerPerfiles().stream()
            .map(perfilAssembler::toModel)
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(CollectionModel.of(perfiles,
            linkTo(methodOn(PerfilController.class).listarPerfiles()).withSelfRel()));
    }

    @GetMapping("/{id}")
@Operation(summary = "Buscar perfil según ID")
public ResponseEntity<EntityModel<Perfil>> obtenerPerfilPorId(
    @Parameter(description = "ID del perfil", example = "1", required = true)
    @PathVariable int id) {
    
    Perfil perfil = perfilService.buscarPorId(id);
    
    if (perfil != null) {
        return ResponseEntity.ok(perfilAssembler.toModel(perfil));
    } else {
        return ResponseEntity.notFound().build();
    }
}
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
    public ResponseEntity<Void> eliminarPerfil(
            @Parameter(
                description = "ID del perfil a eliminar",
                example = "1", required = true)
            @PathVariable int id) {
        perfilService.eliminar(id);
        return ResponseEntity.noContent().build();
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
    
}
    
