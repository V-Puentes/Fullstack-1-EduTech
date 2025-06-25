package com.example.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.edutech.assembler.UsuarioAssembler;
import com.example.edutech.model.Usuario;
import com.example.edutech.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(
    name = "Gestión API Usuarios",
    description = "API para gestionar la API de usuarios con la página")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioAssembler usuarioAssembler;

    @GetMapping
    @Operation(
        summary = "Se listan todos los usuarios",
        description = "Se obtiene una lista completa de todos los usuarios registrados")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de usuarios obtenida exitosamente",
        content = @Content(schema = @Schema(implementation = Usuario.class)))
    public ResponseEntity<CollectionModel<EntityModel<Usuario>>> listarUsuarios() {
        List<EntityModel<Usuario>> usuarios = usuarioService.obtenerUsuarios().stream()
            .map(usuarioAssembler::toModel)
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(
            CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withSelfRel())
        );
    }

    @PostMapping
    @Operation(
        summary = "Se crea un nuevo usuario",
        description = "Se registra un nuevo usuario en el sistema")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Usuario creado exitosamente",
            content = @Content(schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Datos de usuario inválidos")
    })
    public Usuario agregarUsuario(
            @Parameter(
                description = "Datos del nuevo usuario",
                required = true,
                content = @Content(schema = @Schema(implementation = Usuario.class)))
            @RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }
    
    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar usuario por ID",
        description = "Se obtienen los datos del un usuario correspondiente a la Id ingresada")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Usuario encontrado",
            content = @Content(schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado")
    })
    public ResponseEntity<EntityModel<Usuario>> buscarUsuario(
            @Parameter(
                description = "ID del usuario a buscar",
                example = "1", required = true)
            @PathVariable int id) {
                Usuario usuario = usuarioService.buscarPorId(id);
                if (usuario != null) {
                    return ResponseEntity.ok(usuarioAssembler.toModel(usuario));
                }
                return ResponseEntity.notFound().build();
            }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar usuario",
        description = "Actualiza los datos de un usuario")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "600",
            description = "Usuario actualizado exitosamente",
            content = @Content(schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado"),
        @ApiResponse(
            responseCode = "405",
            description = "Datos de usuario inválidos")
    })
    public Usuario actualizarUsuario(
            @Parameter(
                description = "ID del usuario a actualizar",
                example = "1",
                required = true)
            @PathVariable int id,
            
            @Parameter(
                description = "Datos actualizados",
                required = true,
                content = @Content(schema = @Schema(implementation = Usuario.class)))
            @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.actualizar(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar usuario",
        description = "Elimina un usuario del sistema")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "700",
            description = "Usuario eliminado exitosamente"),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado")
    })
    public void eliminarUsuario(
            @Parameter(
                description = "ID del usuario a eliminar",
                example = "1",
                required = true)
            @PathVariable int id) {
        usuarioService.eliminar(id);
    }
}
