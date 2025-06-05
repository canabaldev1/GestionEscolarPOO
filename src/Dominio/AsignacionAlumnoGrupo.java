/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoAsignacionGrupo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lm-carlos
 */
@Entity
public class AsignacionAlumnoGrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
//    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private EstadoAsignacionGrupo estado;

    // CONSTRUCTORES
    public AsignacionAlumnoGrupo() {
    }

    public AsignacionAlumnoGrupo(
            Alumno alumno,
            Grupo grupo) {
        this.alumno = alumno;
        this.grupo = grupo;
    }

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        if (alumno != null) {
            this.alumno = alumno;
        } else {
            throw new IllegalArgumentException("El alumno no puede ser nulo.");
        }
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        if (grupo != null) {
            this.grupo = grupo;
        } else {
            throw new IllegalArgumentException("El grupo no puede ser nulo.");
        }
    }

    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
        if (fechaInicioInscripcion != null) {
            this.fechaInicioInscripcion = fechaInicioInscripcion;
        } else {
            throw new IllegalArgumentException("La fecha de inicio de inscripción no puede ser nula.");
        }
    }

    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
        if (fechaFinInscripcion != null) {
            if (fechaFinInscripcion.isAfter(fechaInicioInscripcion)) {
                this.fechaFinInscripcion = fechaFinInscripcion;
            } else {
                throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio.");
            }
        } else {
            throw new IllegalArgumentException("La fecha de fin de inscripción no puede ser nula.");
        }
    }

    public EstadoAsignacionGrupo getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsignacionGrupo estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
    }

    @Override
    public String toString() {
        return ("Asignación Alumno a Grupo\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Grupo:                        " + (grupo != null ? grupo.getNombre() : "Sin grupo") + "\n"
                + "Fecha de Inicio Inscripción:  " + fechaInicioInscripcion + "\n"
                + "Fecha de Fin Inscripción:     " + fechaFinInscripcion + "\n"
                + "Estado:                       " + estado + "\n");
    }
}
