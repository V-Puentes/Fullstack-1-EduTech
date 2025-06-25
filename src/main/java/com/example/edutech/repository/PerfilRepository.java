package com.example.edutech.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.edutech.model.Perfil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Repository
public class PerfilRepository {
    private List<Perfil> listaPerfiles = new ArrayList<>();

    @Operation(
        summary = "Lista de los perfiles",
        description = "Genera una lista de todos los perfiles registrados")
    public List<Perfil> obtenerPerfiles() {
        return listaPerfiles;
    }
    
    @Operation(
        summary = "Buscar perfil según ID",
        description = "Recupera el perfil correspondiente al ID indicado")
    public Perfil buscarPorId(
        @Parameter(
            description = "ID del perfil",
            example = "1",
            required = true)
        int id
    ) {
        for (Perfil perfil : listaPerfiles) {
            if (perfil.getId() == id) {
                return perfil;
            }
        }
        return null;
    }

    @Operation(
        summary = "Se añade un nuevo perfil",
        description = "Guarda un nuevo perfil en el sistema")
    public Perfil guardar(
        @Parameter(
            description = "Nuevo Perfil que se desea añadir",
            required = true)
        Perfil perfil
    ) {
        listaPerfiles.add(perfil);
        return perfil;
    }

    @Operation(
        summary = "Actualizar perfil existente",
        description = "Modifica los datos de un perfil")
    public Perfil actualizar(
        @Parameter(
            description = "Perfil actualizado",
            required = true)
        Perfil perfil
    ) {
        int idPosicion = -1;
        
        for (int i = 0; i < listaPerfiles.size(); i++) {
            if (listaPerfiles.get(i).getId() == perfil.getId()) {
                idPosicion = i;
                break;
            }
        }

        if (idPosicion != -1) {
            Perfil perfilActualizado = new Perfil();
            perfilActualizado.setId(perfil.getId());
            perfilActualizado.setNombreUsuario(perfil.getNombreUsuario());
            perfilActualizado.setCorreo(perfil.getCorreo());
            perfilActualizado.setClave(perfil.getClave());
            perfilActualizado.setFechaCreacion(perfil.getFechaCreacion());
            
            listaPerfiles.set(idPosicion, perfilActualizado);
            return perfilActualizado;
        }
        
        return null;
    }

    @Operation(
        summary = "Eliminar perfil",
        description = "Elimina el perfil correspondiente al Id ingresado")
    public void eliminar(
        @Parameter(
            description = "ID del perfil a eliminar",
            example = "1",
            required = true)
        int id
    ) {
        Perfil perfil = buscarPorId(id);
        if (perfil != null) {
            listaPerfiles.remove(perfil);
        }
    }
}
