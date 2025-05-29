package com.example.edutech.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.edutech.model.Creacion;



@Repository

public class CreacionRepository {
    private List<Creacion> listaCreaciones = new ArrayList<>();

    public List<Creacion> obtenerCreaciones(){
        return listaCreaciones;
    }
    
    public Creacion buscarPorId(int id){
        for (Creacion creacion : listaCreaciones){
            if (creacion.getId() == id){
                return creacion;
            }
        }
        return null;
    }

    public Creacion guardar(Creacion cre){
        listaCreaciones.add(cre);
        return cre;
    }

    public Creacion actualizar(Creacion cre){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaCreaciones.size(); i++){
            if (listaCreaciones.get(i).getId() == cre.getId()){
                id = cre.getId();
                idPosicion = i;
            }
        }

        Creacion creacion1= new Creacion();
        creacion1.setId(id);
        creacion1.setIdPerfil(cre.getIdPerfil());
        creacion1.setNombreUsuario(cre.getNombreUsuario());
        creacion1.setCorreo(cre.getCorreo());
        creacion1.setClave(cre.getClave());
        creacion1.setFechaCreacion(cre.getFechaCreacion());

        listaCreaciones.set(idPosicion, creacion1);
        return creacion1;
    }

    public void eliminar(int id){
        Creacion creacion = buscarPorId(id);
        
        if (creacion != null){
            listaCreaciones.remove(creacion);
        }
    }
}