/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoMatricula;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author lm-carlos
 */
@Entity
public class Matricula implements Serializable {

    @Id
    private String id;
    private LocalDateTime fechaMatricula;
    
    @Enumerated (EnumType.STRING)
    private EstadoMatricula estado;
    private LocalDateTime fechaPago;
    private int valorMatricula;
    private int valorMensualidad;
    private String observaciones;
    
    @ManyToOne
    private Alumno alumno;
    
    @ManyToOne
    private CicloAcademico cicloAcademico;
    
    @ManyToOne
    private Curso curso;
    
    @OneToOne
    private Beca beca;

    // CONSTRUCTORES
    public Matricula() {
        this.observaciones = "";
        this.estado = EstadoMatricula.PENDIENTE;
    }

    public Matricula(
            String id,
            LocalDateTime fechaMatricula,
            Alumno alumno,
            CicloAcademico cicloAcademico) {
        this.id = id;
        this.fechaMatricula = fechaMatricula;
        this.observaciones = "";
        this.alumno = alumno;
        this.cicloAcademico = cicloAcademico;
        this.estado = EstadoMatricula.PENDIENTE;

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

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
        if (fechaMatricula != null) {
            this.fechaMatricula = fechaMatricula;
        } else {
            throw new IllegalArgumentException("La fecha de matrícula no puede ser nula.");
        }
    }

    public EstadoMatricula getEstado() {
        return estado;
    }

    public void setEstado(EstadoMatricula estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado de matrícula no puede ser nulo.");
        }
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        if (fechaPago != null) {
            this.fechaPago = fechaPago;
        } else {
            throw new IllegalArgumentException("La fecha de pago no puede ser nula.");
        }
    }

    public int getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(int valorMatricula) {
        if (valorMatricula >= 0) {
            this.valorMatricula = valorMatricula;
        } else {
            throw new IllegalArgumentException("El valor de la matrícula no puede ser negativo.");
        }
    }

    public int getValorMensualidad() {
        return valorMensualidad;
    }

    public void setValorMensualidad(int valorMensualidad) {
        if (valorMensualidad >= 0) {
            this.valorMensualidad = valorMensualidad;
        } else {
            throw new IllegalArgumentException("El valor de la mensualidad no puede ser negativo.");
        }
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        if (observaciones != null) {
            this.observaciones = observaciones;
        } else {
            throw new IllegalArgumentException("Las observaciones no pueden ser nulas.");
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

    public Beca getBeca() {
        return beca;
    }

    public void setBeca(Beca beca) {
        if (beca != null) {
            this.beca = beca;
        } else {
            throw new IllegalArgumentException("La beca no puede ser nula.");
        }
    }

    @Override
    public String toString() {
        return ("Matrícula\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Fecha de Matrícula:           " + fechaMatricula + "\n"
                + "Estado:                       " + estado + "\n"
                + "Fecha de Pago:                " + (fechaPago != null ? fechaPago : "Pago no realizado.") + "\n"
                + "Valor de Matrícula:           " + valorMatricula + "\n"
                + "Valor de Mensualidad:         " + valorMensualidad + "\n"
                + "Observaciones:                " + observaciones + "\n"
                + "Alumno:                       " + (alumno != null ? alumno.getNombres() + " " + alumno.getApellidos() : "Sin alumno") + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getAnio() : "Sin ciclo") + "\n"
                + "Curso:                        " + (curso != null ? curso.getNombre() : "Sin curso") + "\n"
                + "Beca:                         " + (beca != null ? beca.getNombre() : "Sin beca") + "\n");
    }

}
