package com.example.edutech.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.edutech.model.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Repository
public class UsuarioRepository {
    private List<Usuario> listaUsuarios = new ArrayList<>();

    @Operation(
        summary = "Obtener lista de usuarios",
        description = "Retorna una lista con todos los usuarios registrados")
    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }
    
    @Operation(summary = "Busqueda de usuario por ID",
    description = "Retorna el usuario correspondiente al Id ingresado")
    public Usuario buscarPorId(
        @Parameter(
        description = "ID del usuario solicitado",
        example = "1",
        required = true)
        int id
    ) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @Operation(
        summary = "Busqueda de usuario según RUN",
        description = "Retorna el usuario correspondiente al RUN ingresado")
    public Usuario buscarPorRun(
        @Parameter(
        description = "RUN del usuario solicitado",
        example = "12345678-9",
        required = true)
        String run
    ) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getRun().equals(run)) {
                return usuario;
            }
        }
        return null;
    }

    @Operation(
        summary = "Guardar nuevo usuario",
        description = "Agrega el nuevo usuario al repositorio")
    public Usuario guardar(
        @Parameter(
            description = "Usuario a guardar",
            required = true)
        Usuario usuario
    ) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    @Operation(
        summary = "Actualizar un usuario existente",
        description = "Actualiza los datos del usuario correspondiente al Id ingresado")
    public Usuario actualizar(
        @Parameter(
            description = "Usuario actualizado",
            required = true)
        Usuario usuario
    ) {
        int idPosicion = -1;
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == usuario.getId()) {
                idPosicion = i;
                break;
            }
        }

        if (idPosicion != -1) {
            Usuario usuarioActualizado = new Usuario();
            usuarioActualizado.setId(usuario.getId());
            usuarioActualizado.setRun(usuario.getRun());
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setApellido(usuario.getApellido());
            usuarioActualizado.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioActualizado.setRol(usuario.getRol());
            
            listaUsuarios.set(idPosicion, usuarioActualizado);
            return usuarioActualizado;
        }
        
        return null;
    }

    @Operation(
        summary = "Eliminar usuario",
        description = "Elimina un usuario al que corresponda el Id ingresado del repositorio")
    public void eliminar(
        @Parameter(
            description = "ID del usuario a eliminar",
            example = "1",
            required = true)
        int id
    ) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
        }
    }
}