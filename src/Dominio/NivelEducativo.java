/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.TipoNivelEducativo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class NivelEducativo {

    private String id;
    private String nombre;
    private String descripcion;
    private TipoNivelEducativo tipo;
    private List<Curso> cursos;
    private List<Modalidad> modalidadesDisponibles;

    // CONSTRUCTORES
    public NivelEducativo() {
        this.descripcion = "";
        this.cursos = new ArrayList<>();
        this.modalidadesDisponibles = new ArrayList<>();
    }

    public NivelEducativo(
            String id,
            String nombre,
            TipoNivelEducativo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = "";
        this.tipo = tipo;
        this.cursos = new ArrayList<>();
        this.modalidadesDisponibles = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía.");
        }
    }

    public TipoNivelEducativo getTipo() {
        return tipo;
    }

    public void setTipo(TipoNivelEducativo tipo) {
        if (tipo != null) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("El tipo de nivel educativo no puede ser nulo.");
        }
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        if (cursos != null) {
            this.cursos = cursos;
        } else {
            throw new IllegalArgumentException("La lista de cursos no puede ser nula.");
        }
    }

    public List<Modalidad> getModalidadesDisponibles() {
        return modalidadesDisponibles;
    }

    public void setModalidadesDisponibles(List<Modalidad> modalidadesDisponibles) {
        if (modalidadesDisponibles != null) {
            this.modalidadesDisponibles = modalidadesDisponibles;
        } else {
            throw new IllegalArgumentException("La lista de modalidades disponibles no puede ser nula.");
        }
    }

    //OTROS METODOS 
    public void addCurso(Curso curso) {
        if (curso != null && !this.cursos.contains(curso)) {
            this.cursos.add(curso);
        } else {
            throw new IllegalArgumentException("El curso no puede ser nulo o ya existe en la lista.");
        }
    }
    //    private List<Modalidad> modalidadesDisponibles;
    public void addModalidad(Modalidad modalidad) {
        if (modalidad != null && !this.modalidadesDisponibles.contains(modalidad)) {
            this.modalidadesDisponibles.add(modalidad);
        } else {
            throw new IllegalArgumentException("La modalidad no puede ser nula o ya existe en la lista.");
        }
    }
    

    @Override
    public String toString() {
        return ("Nivel Educativo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Descripción:                  " + descripcion + "\n"
                + "Tipo:                         " + tipo + "\n"
                + "Cantidad de Cursos:           " + cursos.size() + "\n"
                + "Cantidad de Modalidades:      " + modalidadesDisponibles.size() + "\n");
    }

}
