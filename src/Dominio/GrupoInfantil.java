/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author lm-carlos
 */
@Entity
public class GrupoInfantil extends Grupo implements Serializable {
    
    @ManyToOne
    private ProfesorInfantil profesorEncargado;
    
    @ManyToOne
    private ProfesorInfantil profesorAsistente;

    // CONSTRUCTORES
    public GrupoInfantil() {
        super();
    }

    public GrupoInfantil(
            String id,
            String nombre,
            Curso curso,
            CicloAcademico cicloAcademico) {
        super(id, nombre, curso, cicloAcademico);
    }

    // GETTERS Y SETTERS
    public ProfesorInfantil getProfesorEncargado() {
        return profesorEncargado;
    }

    public void setProfesorEncargado(ProfesorInfantil profesorEncargado) {
        if (profesorEncargado != null) {
            this.profesorEncargado = profesorEncargado;
        } else {
            throw new IllegalArgumentException("El profesor encargado no puede ser nulo.");
        }
    }

    public ProfesorInfantil getProfesorAsistente() {
        return profesorAsistente;
    }

    public void setProfesorAsistente(ProfesorInfantil profesorAsistente) {
        if (profesorAsistente != null) {
            this.profesorAsistente = profesorAsistente;
        } else {
            throw new IllegalArgumentException("El profesor asistente no puede ser nulo.");
        }
    }

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
                + "Profesor Asistente:           " + (profesorAsistente != null ? profesorAsistente.getNombres() + " " + profesorAsistente.getApellidos() : "Sin profesor asistente") + "\n");
    }
}
