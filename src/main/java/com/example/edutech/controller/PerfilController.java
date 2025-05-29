package com.example.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.edutech.model.Perfil;
import com.example.edutech.service.PerfilService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/perfiles")
    
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> listarPerfiles() {
        return perfilService.obtenerPerfiles();
    }

    @PostMapping
    public Perfil agregarPerfil(@RequestBody Perfil perfil) {
        return perfilService.guardar(perfil);
    }
    
    @GetMapping("{id}")
    public Perfil buscarPerfil(@PathVariable int id) {
        return perfilService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public Perfil actualizarPerfil(@PathVariable int id, @RequestBody Perfil perfil) {
        return perfilService.actualizar(perfil);
    }

    @DeleteMapping("{id}")
    public void eliminarPerfil(@PathVariable int id){
        perfilService.eliminar(id);
    }
}