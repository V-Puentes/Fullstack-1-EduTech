package com.example.edutech.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.edutech.controller.PerfilController;
import com.example.edutech.model.Perfil;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

@Component
public class PerfilAssembler implements RepresentationModelAssembler<Perfil, EntityModel<Perfil>> {

    @Override
    @NonNull
    public EntityModel<Perfil> toModel(@NonNull Perfil perfil) {
        return EntityModel.of(perfil,

            linkTo(methodOn(PerfilController.class).buscarPerfil(perfil.getId())).withSelfRel(),
            linkTo(methodOn(PerfilController.class).listarPerfiles()).withRel("perfiles"),
            linkTo(methodOn(PerfilController.class).agregarPerfil(null)).withRel("crear-perfil"),
            linkTo(methodOn(PerfilController.class).actualizarPerfil(perfil.getId(), null)).withRel("actualizar-perfil"),
            linkTo(methodOn(PerfilController.class).eliminarPerfil(perfil.getId())).withRel("eliminar-perfil")
        );
    }
}