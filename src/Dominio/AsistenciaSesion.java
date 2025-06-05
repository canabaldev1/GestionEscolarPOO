/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
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
public class AsistenciaSesion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private Sesion sesion;
    private boolean presente;
    private String observaciones;

    // CONSTRUCTORES
    public AsistenciaSesion() {
    }

    public AsistenciaSesion(
            Alumno alumno,
            Sesion sesion,
            boolean presente) {
        this.alumno = alumno;
        this.sesion = sesion;
        this.presente = presente;
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

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        if (sesion != null) {
            this.sesion = sesion;
        } else {
            throw new IllegalArgumentException("La sesión no puede ser nula.");
        }
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        if (observaciones != null && !observaciones.trim().isEmpty()) {
            this.observaciones = observaciones;
        } else {
            throw new IllegalArgumentException("Las observaciones no pueden ser nulas o vacías.");
        }
    }

    @Override
    public String toString() {
        return ("Asistencia a Sesión\n" + "--------------------------\n"
                + "ID:                           " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Sesión:                       " + (sesion != null ? sesion.getId() : "Sin sesión") + "\n"
                + "Presente:                     " + (presente ? "Sí" : "No") + "\n"
                + "Observaciones:                " + observaciones + "\n");
    }

}
