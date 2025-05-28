public class EdutechRepository {
    
}
/*ejemplo 1 libroRepository package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.bibliotecaduoc.model.Libro;



@Repository
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros(){
        return listaLibros;
    }
    
    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        
        if (libro != null){
            listaLibros.remove(libro);
        }
    }
}
 */

 /*ejemplo 2 prestamoRepository package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.model.Prestamo;


@Repository
public class PrestamoRepository {
    
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public List<Prestamo> obtenerPrestamos(){
        return listaPrestamos;
    }

    public Prestamo buscarPorId(int id){
        for (Prestamo prestamo : listaPrestamos){
            if (prestamo.getId() == id){
                return prestamo;
            }
        }
        return null;
    }

    public Prestamo guardar(Prestamo pres){
        listaPrestamos.add(pres);
        return pres;
    }

    public Prestamo actualizar(Prestamo pres){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPrestamos.size(); i++){
            if (listaPrestamos.get(i).getId() == pres.getId()){
                id = pres.getId();
                idPosicion = i;
            }
        }

        Prestamo prestamo1 = new Prestamo();
        prestamo1.setId(id);
        prestamo1.setIdLibro(pres.getIdLibro());
        prestamo1.setRunSolicitante(pres.getRunSolicitante());
        prestamo1.setFechaSolicitud(pres.getFechaSolicitud());
        prestamo1.setFechaEntrega(pres.getFechaEntrega());
        prestamo1.setCantidadDias(pres.getCantidadDias());
        prestamo1.setMultas(pres.getMultas());

        listaPrestamos.set(idPosicion, prestamo1);
        return prestamo1;
    }

    public void eliminar(int id){
        Prestamo prestamo = buscarPorId(id);
        
        if (prestamo != null){
            listaPrestamos.remove(prestamo);
        }
    }

}
*/