public class Edutech {
    
}
/*Ejemplo 1 del profe libro.java
 * 
 * package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}

 */

/*ejemplo 2 del profe prestamo.java
 *package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {
    
    private int id;
    private int idLibro;
    private String runSolicitante;
    private String fechaSolicitud;
    private String fechaEntrega;
    private int cantidadDias;
    private int multas;

}

 */

 /*Ejemplo 3 del profe paciente.javapackage com.hospital_vm.cl.hospital_vm.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "paciente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, length = 13, nullable=false)
    private String run;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = true)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String correo;
}
 */