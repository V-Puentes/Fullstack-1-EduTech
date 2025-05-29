package com.example.edutech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.edutech.model.Perfil;
import com.example.edutech.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> obtenerPerfiles() {
        return perfilRepository.obtenerPerfiles();
    }

    public Perfil buscarPorId(int id) {
        return perfilRepository.buscarPorId(id);
    }

    public Perfil guardar(Perfil perfil) {
        return perfilRepository.guardar(perfil);
    }

    public Perfil actualizar(Perfil perfil) {
        return perfilRepository.actualizar(perfil);
    }

    public void eliminar(int id) {
        perfilRepository.eliminar(id);
    }

    public Perfil buscarPorRut(String rut) {
        return perfilRepository.buscarPorRut(rut);
    }
}
