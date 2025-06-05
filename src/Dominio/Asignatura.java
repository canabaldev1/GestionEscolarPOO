/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.PrioridadAsignatura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class Asignatura implements Serializable {
    
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    
    @Enumerated (EnumType.STRING)
    private PrioridadAsignatura prioridad;
    
    @OneToMany (mappedBy = "asignatura")
    private List<Clase> clases;

    // CONSTRUCTORES
    public Asignatura() {
        this.clases = new ArrayList<>();
    }

    public Asignatura(
            String id,
            String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.clases = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El ID de la asignatura no puede estar vacío.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre de la asignatura no puede estar vacío.");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
    }

    public PrioridadAsignatura getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadAsignatura prioridad) {
        if (prioridad != null) {
            this.prioridad = prioridad;
        } else {
            throw new IllegalArgumentException("La prioridad no puede ser nula.");
        }
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        if (clases != null) {
            this.clases = clases;
        } else {
            throw new IllegalArgumentException("La lista de clases no puede ser nula.");
        }
    }

    //OTROS METODOS
    public void addClase(Clase clase) {
        if (clase != null && !this.clases.contains(clase)) {
            this.clases.add(clase);
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Asignatura\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombre:                 " + nombre + "\n"
                + "Descripción:            " + descripcion + "\n"
                + "Prioridad:              " + prioridad + "\n"
                + "Clases:                 " + clases.size() + "\n");
    }

}
