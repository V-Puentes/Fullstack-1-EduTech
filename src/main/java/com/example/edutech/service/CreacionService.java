package com.example.edutech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.edutech.model.Creacion;
import com.example.edutech.repository.CreacionRepository;

@Service
public class CreacionService {

    @Autowired
    private CreacionRepository creacionRepository;

    public List<Creacion> obtenerCreaciones() {
        return creacionRepository.obtenerCreaciones();
    }

    public Creacion buscarPorId(int id) {
        return creacionRepository.buscarPorId(id);
    }

    public Creacion guardar(Creacion creacion) {
        return creacionRepository.guardar(creacion);
    }

    public Creacion actualizar(Creacion creacion) {
        return creacionRepository.actualizar(creacion);
    }

    public void eliminar(int id) {
        creacionRepository.eliminar(id);
    }


}
