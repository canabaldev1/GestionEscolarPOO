/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoDesempenoEstudiante;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lm-carlos
 */

@Entity
public class DesempenoAlumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;
    
    @ManyToOne
    private Clase clase;
    
    private String observaciones;
    private double notaPrimerTrimestre;
    private double notaSegundoTrimestre;
    private double notaTercerTrimestre;
    private double notaHabilitacion;
    
    @Enumerated (EnumType.STRING)
    private EstadoDesempenoEstudiante estado;

    //CONSTRUCTORES
    public DesempenoAlumno() {
        this.estado = EstadoDesempenoEstudiante.EN_CURSO;
    }

    ;
    
    public DesempenoAlumno(
            Alumno alumno,
            Clase clase) {
        this.alumno = alumno;
        this.clase = clase;
        this.estado = EstadoDesempenoEstudiante.EN_CURSO;
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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        if (clase != null) {
            this.clase = clase;
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula.");
        }
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

    public double getNotaPrimerTrimestre() {
        return notaPrimerTrimestre;
    }

    public void setNotaPrimerTrimestre(double notaPrimerTrimestre) {
        if (notaPrimerTrimestre >= 0 && notaPrimerTrimestre <= 10) {
            this.notaPrimerTrimestre = notaPrimerTrimestre;
        } else {
            throw new IllegalArgumentException("La nota del primer trimestre debe estar entre 0 y 10.");
        }
    }

    public double getNotaSegundoTrimestre() {
        return notaSegundoTrimestre;
    }

    public void setNotaSegundoTrimestre(double notaSegundoTrimestre) {
        if (notaSegundoTrimestre >= 0 && notaSegundoTrimestre <= 10) {
            this.notaSegundoTrimestre = notaSegundoTrimestre;
        } else {
            throw new IllegalArgumentException("La nota del segundo trimestre debe estar entre 0 y 10.");
        }
    }

    public double getNotaTercerTrimestre() {
        return notaTercerTrimestre;
    }

    public void setNotaTercerTrimestre(double notaTercerTrimestre) {
        if (notaTercerTrimestre >= 0 && notaTercerTrimestre <= 10) {
            this.notaTercerTrimestre = notaTercerTrimestre;
        } else {
            throw new IllegalArgumentException("La nota del tercer trimestre debe estar entre 0 y 10.");
        }
    }

    public double getNotaHabilitacion() {
        return notaHabilitacion;
    }

    public void setNotaHabilitacion(double notaHabilitacion) {
        if (notaHabilitacion >= 0 && notaHabilitacion <= 10) {
            this.notaHabilitacion = notaHabilitacion;
        } else {
            throw new IllegalArgumentException("La nota de habilitación debe estar entre 0 y 10.");
        }
    }

    public EstadoDesempenoEstudiante getEstado() {
        return estado;
    }

    public void setEstado(EstadoDesempenoEstudiante estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado del contrato no puede ser nulo.");
        }
    }

    @Override
    public String toString() {
        return ("DesempeñoAlumno\n" + "--------------------------\n"
                + "ID:                           " + id + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Clase:                        " + (clase != null ? clase.getId() : "Sin clase") + "\n"
                + "Observaciones:                " + observaciones + "\n"
                + "Nota Primer Trimestre:        " + notaPrimerTrimestre + "\n"
                + "Nota Segundo Trimestre:       " + notaSegundoTrimestre + "\n"
                + "Nota Tercer Trimestre:        " + notaTercerTrimestre + "\n"
                + "Nota de Habilitación:         " + notaHabilitacion + "\n"
                + "Estado:                       " + estado + "\n");
    }

}
