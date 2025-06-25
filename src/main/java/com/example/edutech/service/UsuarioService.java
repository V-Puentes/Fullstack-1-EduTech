package com.example.edutech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.edutech.model.Usuario;
import com.example.edutech.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Service
@Schema(description = "Contiene la lógica para gestionar los usuarios")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Operation(
        summary = "Lista de usuarios",
        description = "Genera una lista con todos los usuarios registrados")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de usuarios generada")
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }
    @Operation(
        summary = "Buscar usuario según RUN",
        description = "Recupera el usuario correspondiente al RUN ingresado")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Usuario encontrado"),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado")
    })
    public Usuario buscarPorRun(
        @Parameter(description = "RUN del usuario (sin puntos, con guión)",
        example = "12345678-9",
        required = true)
        String run
    ) {
        return usuarioRepository.buscarPorRun(run);
    }
    @Operation(
        summary = "Buscar usuario según ID",
        description = "Recupera el usuario correspondiente a la Id ingresada")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "400",
            description = "Usuario encontrado"),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado")
    })
    public Usuario buscarPorId(
        @Parameter(
            description = "ID del usuario",
            example = "1",
            required = true)
        int id
    ) {
        return usuarioRepository.buscarPorId(id);
    }

    @Operation(
        summary = "Añadir nuevo usuario",
        description = "Añade un nuevo usuario al sistema")
    @ApiResponse(
        responseCode = "500",
        description = "Usuario creado exitosamente")
    public Usuario guardar(
        @Parameter(
            description = "Datos del nuevo usuario",
            required = true)
        Usuario usuario
    ) {
        return usuarioRepository.guardar(usuario);
    }

    @Operation(
        summary = "Actualizar usuario",
        description = "Actualiza los datos de un usuario")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "600",
            description = "Usuario actualizado exitosamente"),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado")
    })
    public Usuario actualizar(
        @Parameter(
            description = "Datos actualizados del usuario",
            required = true)
        Usuario usuario
    ) {
        return usuarioRepository.actualizar(usuario);
    }

    @Operation(
        summary = "Eliminar usuario por Id",
        description = "Elimina un usuario del sistema ingresando su ID")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "700",
            description = "Usuario eliminado exitosamente"),
        @ApiResponse(
            responseCode = "404",
            description = "Usuario no encontrado")
    })
    public void eliminar(
        @Parameter(
            description = "ID del usuario a eliminar",
            example = "1",
            required = true)
        int id
    ) {
        usuarioRepository.eliminar(id);
    }
}