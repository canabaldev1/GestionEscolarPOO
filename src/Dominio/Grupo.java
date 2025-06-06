/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    
    protected String nombre;

    @ManyToOne
    protected Curso curso;
    
    @OneToMany (mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<AsignacionAlumnoGrupo> alumnos;

    @ManyToOne
    protected Aula aula;    
    
    @ManyToOne
    protected CicloAcademico cicloAcademico;

    // CONSTRUCTORES
    public Grupo() {
        this.alumnos = new ArrayList<>();
    }

    public Grupo(
            String nombre,
            Curso curso,
            CicloAcademico cicloAcademico) {
        this.nombre = nombre;
        this.curso = curso;
        this.cicloAcademico = cicloAcademico;
        this.alumnos = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        if (curso != null) {
            this.curso = curso;
        } else {
            throw new IllegalArgumentException("El curso no puede ser nulo.");
        }
    }

    public List<AsignacionAlumnoGrupo> getAsignacionesDeAlumnos() {
        return alumnos;
    }

    public void setAsignacionesDeAlumnos(List<AsignacionAlumnoGrupo> asignacionesDeAlumnos) {
        if (asignacionesDeAlumnos != null) {
            this.alumnos = asignacionesDeAlumnos;
        } else {
            throw new IllegalArgumentException("La lista de asignaciones de alumnos no puede ser nula.");
        }
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        if (aula != null) {
            this.aula = aula;
        } else {
            throw new IllegalArgumentException("El aula no puede ser nula.");
        }
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        if (cicloAcademico != null) {
            this.cicloAcademico = cicloAcademico;
        } else {
            throw new IllegalArgumentException("El ciclo académico no puede ser nulo.");
        }
    }

    //OTROS METODOS
    public void addAlumno(AsignacionAlumnoGrupo alumno) {
        if (alumno != null && !this.alumnos.contains(alumno)) {
            this.alumnos.add(alumno);
        } else {
            throw new IllegalArgumentException("El desempeño del alumno no puede ser nulo o ya existe en la lista.");
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
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin ciclo") + "\n");
    }

}
