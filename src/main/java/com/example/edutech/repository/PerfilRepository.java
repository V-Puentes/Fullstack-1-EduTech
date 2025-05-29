package com.example.edutech.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.edutech.model.Perfil;



@Repository

public class PerfilRepository {
    private List<Perfil> listaPerfiles = new ArrayList<>();

    public List<Perfil> obtenerPerfiles(){
        return listaPerfiles;
    }
    
    public Perfil buscarPorId(int id){
        for (Perfil perfil : listaPerfiles){
            if (perfil.getId() == id){
                return perfil;
            }
        }
        return null;
    }

    public Perfil buscarPorRut(String rut){
        for (Perfil perfil : listaPerfiles){
            if (perfil.getRun().equals(rut)){
                return perfil;
            }
        }
        return null;
    }

    public Perfil guardar(Perfil per){
        listaPerfiles.add(per);
        return per;
    }

    public Perfil actualizar(Perfil per){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPerfiles.size(); i++){
            if (listaPerfiles.get(i).getId() == per.getId()){
                id = per.getId();
                idPosicion = i;
            }
        }

        Perfil perfil1= new Perfil();
        perfil1.setId(id);
        perfil1.setRun(per.getRun());
        perfil1.setNombre(per.getNombre());
        perfil1.setApellido(per.getApellido());
        perfil1.setFechaNacimiento(per.getFechaNacimiento());
        perfil1.setRol(per.getRol());


        listaPerfiles.set(idPosicion, perfil1);
        return perfil1;
    }

    public void eliminar(int id){
        Perfil perfil = buscarPorId(id);
        
        if (perfil != null){
            listaPerfiles.remove(perfil);
        }
    }
}