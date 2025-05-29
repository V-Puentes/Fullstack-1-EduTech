package com.example.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.edutech.model.Creacion;
import com.example.edutech.service.CreacionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/creaciones")
    
public class CreacionController {
    
    @Autowired
    private CreacionService creacionService;

    @GetMapping
    public List<Creacion> listarCreaciones() {
        return creacionService.obtenerCreaciones();
    }

    @PostMapping
    public Creacion agregarCreacion(@RequestBody Creacion creacion) {
        return creacionService.guardar(creacion);
    }
    
    @GetMapping("{id}")
    public Creacion buscarCreacion(@PathVariable int id) {
        return creacionService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public Creacion actualizarCreacion(@PathVariable int id, @RequestBody Creacion creacion) {
        return creacionService.actualizar(creacion);
    }

    @DeleteMapping("{id}")
    public void eliminarCreacion(@PathVariable int id){
        creacionService.eliminar(id);
    }
}