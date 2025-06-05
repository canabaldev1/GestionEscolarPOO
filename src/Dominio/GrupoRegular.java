/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class GrupoRegular extends Grupo {
    
    @ManyToOne
    private ProfesorRegular profesorEncargado;
    
    @OneToMany (mappedBy = "grupo")
    private List<Clase> clases;

    // CONSTRUCTORES
    public GrupoRegular() {
        super();
        this.clases = new ArrayList<>();
    }

    public GrupoRegular(
            String id,
            String nombre,
            Curso curso,
            CicloAcademico cicloAcademico) {
        super(id, nombre, curso, cicloAcademico);
        this.clases = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public ProfesorRegular getProfesorEncargado() {
        return profesorEncargado;
    }

    public void setProfesorEncargado(ProfesorRegular profesorEncargado) {
        if (profesorEncargado != null) {
            this.profesorEncargado = profesorEncargado;
        } else {
            throw new IllegalArgumentException("El profesor encargado no puede ser nulo.");
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
    
    //    private List<Clase> clases;

    @Override
    public String toString() {
        return ("Grupo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Curso:                        " + (curso != null ? curso.getNombre() : "Sin curso") + "\n"
                + "Cantidad de Alumnos:          " + alumnos.size() + "\n"
                + "Aula:                         " + (aula != null ? aula.getNombre() : "Sin aula") + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin ciclo") + "\n"
                + "Profesor Encargado:           " + (profesorEncargado != null ? profesorEncargado.getNombres() + " " + profesorEncargado.getApellidos() : "Sin profesor encargado") + "\n"
                + "Cantidad de Clases:           " + clases.size() + "\n");
    }
}
