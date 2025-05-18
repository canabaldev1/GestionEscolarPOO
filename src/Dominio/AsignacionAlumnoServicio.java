/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoAsignacionServicio;
import java.time.LocalDate;

/**
 *
 * @author lm-carlos
 */
public class AsignacionAlumnoServicio {

    private String id;
    private Alumno alumno;
    private ServicioComplementario servicioComplementario;
    private LocalDate fechaInicioAsignacion;
    private LocalDate fechaFinAsignacion;
    private EstadoAsignacionServicio estado;

    //CONSTRUCTORES
    public AsignacionAlumnoServicio() {
    }

    public AsignacionAlumnoServicio(
            String id,
            Alumno alumno,
            ServicioComplementario servicioComplementario) {
        this.id = id;
        this.alumno = alumno;
        this.servicioComplementario = servicioComplementario;
        this.estado = EstadoAsignacionServicio.ACTIVA;
    }
    
    //GETTERS Y SETTERS

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

    public ServicioComplementario getServicioComplementario() {
        return servicioComplementario;
    }

    public void setServicioComplementario(ServicioComplementario servicioComplementario) {
        if (servicioComplementario != null) {
            this.servicioComplementario = servicioComplementario;
        } else {
            throw new IllegalArgumentException("El servicio complementario no puede ser nulo.");
        }
    }

    public LocalDate getFechaInicioAsignacion() {
        return fechaInicioAsignacion;
    }

    public void setFechaInicioAsignacion(LocalDate fechaInicioAsignacion) {
        if (fechaInicioAsignacion != null) {
            this.fechaInicioAsignacion = fechaInicioAsignacion;
        } else {
            throw new IllegalArgumentException("La fecha de inicio de asignación no puede ser nula.");
        }
    }

    public LocalDate getFechaFinAsignacion() {
        return fechaFinAsignacion;
    }

    public void setFechaFinAsignacion(LocalDate fechaFinAsignacion) {
        if (fechaFinAsignacion != null) {
            if (fechaFinAsignacion.isAfter(fechaInicioAsignacion)) {
                this.fechaFinAsignacion = fechaFinAsignacion;
            } else {
                throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio.");
            }
        } else {
            throw new IllegalArgumentException("La fecha de fin de asignación no puede ser nula.");
        }
    }

    public EstadoAsignacionServicio getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsignacionServicio estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
    }

    @Override
    public String toString() {
        return ("Asignación Alumno a Servicio Complementario\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Servicio Complementario:      " + (servicioComplementario != null ? servicioComplementario.getNombre() : "Sin servicio complementario") + "\n"
                + "Fecha de Inicio Inscripción:  " + fechaInicioAsignacion + "\n"
                + "Fecha de Fin Inscripción:     " + fechaFinAsignacion + "\n"
                + "Estado:                       " + estado + "\n");
    }
}
