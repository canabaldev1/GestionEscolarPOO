/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class Modalidad {

    private String id;
    private String nombre;
    private String descripcion;
    private NivelEducativo nivelEducativo;
    private List<Curso> cursos;

    // CONSTRUCTORES
    public Modalidad() {
        this.cursos = new ArrayList<>();
        this.descripcion = "";
    }

    public Modalidad(
            String id,
            String nombre,
            NivelEducativo nivelEducativo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = "";
        this.nivelEducativo = nivelEducativo;
        this.cursos = new ArrayList<>();
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
            throw new IllegalArgumentException("La descripcion no puede ser nulo o vacío.");
        }
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        if (nivelEducativo != null) {
            this.nivelEducativo = nivelEducativo;
        } else {
            throw new IllegalArgumentException("El nivel educativo no puede ser nulo.");
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

    //OTROS METODOS 
    public void addCurso(Curso curso) {
        if (curso != null && !this.cursos.contains(curso)) {
            this.cursos.add(curso);
        } else {
            throw new IllegalArgumentException("El curso no puede ser nulo o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Modalidad\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Descripción:                  " + descripcion + "\n"
                + "Nivel Educativo:              " + (nivelEducativo != null ? nivelEducativo.getNombre() : "Sin nivel educativo") + "\n"
                + "Cantidad de Cursos:           " + cursos.size() + "\n");
    }
}
