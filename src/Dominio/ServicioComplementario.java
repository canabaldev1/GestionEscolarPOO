/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoServicioComplementario;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class ServicioComplementario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String descripcion;
    private double valor;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    @Enumerated(EnumType.STRING)
    private EstadoServicioComplementario estado;
    
    @OneToMany (mappedBy = "servicioComplementario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AsignacionAlumnoServicio> alumnosBeneficiados;
    
    @ManyToOne
    private CicloAcademico cicloAcademico;

    // CONSTRUCTORES
    public ServicioComplementario() {
        this.descripcion = "";
        this.alumnosBeneficiados = new ArrayList<>();
    }

    public ServicioComplementario(
            String nombre,
            CicloAcademico cicloAcademico) {
        this.nombre = nombre;
        this.cicloAcademico = cicloAcademico;
        this.alumnosBeneficiados = new ArrayList<>();
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor >= 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio != null) {
            if (this.fechaFin != null && fechaInicio.isAfter(this.fechaFin)) {
                throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
            }
            this.fechaInicio = fechaInicio;
        } else {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
        }
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        if (fechaFin != null) {
            if (this.fechaInicio != null && fechaFin.isBefore(this.fechaInicio)) {
                throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
            }
            this.fechaFin = fechaFin;
        } else {
            throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
        }
    }

    public EstadoServicioComplementario getEstado() {
        return estado;
    }

    public void setEstado(EstadoServicioComplementario estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
    }

    public List<AsignacionAlumnoServicio> getAsignacionesDeAlumnos() {
        return alumnosBeneficiados;
    }

    public void setAsignacionesDeAlumnos(List<AsignacionAlumnoServicio> asignacionesDeAlumnos) {
        if (asignacionesDeAlumnos != null) {
            this.alumnosBeneficiados = asignacionesDeAlumnos;
        } else {
            throw new IllegalArgumentException("La lista de asignaciones de alumnos no puede ser nula.");
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
    public void addAlumno(AsignacionAlumnoServicio alumno) {
        if (alumno != null && !this.alumnosBeneficiados.contains(alumno)) {
            this.alumnosBeneficiados.add(alumno);
        } else {
            throw new IllegalArgumentException("El alumno no puede ser nulo o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Servicio Complementario\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Nombre:                       " + nombre + "\n"
                + "Descripción:                  " + descripcion + "\n"
                + "Valor:                        " + valor + "\n"
                + "Fecha de Inicio:              " + fechaInicio + "\n"
                + "Fecha de Fin:                 " + fechaFin + "\n"
                + "Estado:                       " + estado + "\n"
                + "Cantidad de Alumnos:          " + alumnosBeneficiados.size() + "\n"
                + "Ciclo Académico:              " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin estado") + "\n");
    }

}
