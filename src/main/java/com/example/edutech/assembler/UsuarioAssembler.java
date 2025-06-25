package com.example.edutech.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.example.edutech.controller.UsuarioController;
import com.example.edutech.model.Usuario;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {

    @Override
    @NonNull
    public EntityModel<Usuario> toModel(@NonNull Usuario usuario) {
        return EntityModel.of(usuario,
            linkTo(methodOn(UsuarioController.class).buscarUsuario(usuario.getId())).withSelfRel(),
            linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios"),
            linkTo(methodOn(UsuarioController.class).agregarUsuario(null)).withRel("crear-usuario"),
            linkTo(methodOn(UsuarioController.class).actualizarUsuario(usuario.getId(), null)).withRel("actualizar"),
            linkTo(UsuarioController.class).slash(usuario.getId()).withRel("eliminar")
        );
    }
}