/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoContrato;
import Dominio.Constantes.TipoContrato;
import java.time.LocalDate;

/**
 *
 * @author lm-carlos
 */
public class Contrato {

    private String id;
    private TipoContrato tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int valorSalario;
    private EstadoContrato estado;
    private String observaciones;
    private String cargo;
    private Empleado empleado;
    private CicloAcademico cicloAcademico;

    // CONSTRUCTORES
    public Contrato() {
        this.observaciones = "";
    }

    public Contrato(
            String id,
            TipoContrato tipo,
            LocalDate fechaInicio,
            LocalDate fechaFin,
            int valorSalario,
            Empleado empleado,
            CicloAcademico cicloAcademico) {
        this.id = id;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorSalario = valorSalario;
        this.estado = EstadoContrato.EN_PROYECCION;
        this.observaciones = "";
        this.empleado = empleado;
        this.cicloAcademico = cicloAcademico;
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

    public TipoContrato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContrato tipo) {
        if (tipo != null) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("El tipo de contrato no puede ser nulo.");
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

    public int getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(int valorSalario) {
        if (valorSalario > 0) {
            this.valorSalario = valorSalario;
        } else {
            throw new IllegalArgumentException("El valor del salario debe ser mayor que cero.");
        }
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public void setEstado(EstadoContrato estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado del contrato no puede ser nulo.");
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo != null && !cargo.trim().isEmpty()) {
            this.cargo = cargo;
        } else {
            throw new IllegalArgumentException("El cargo no puede ser nulo o vacío.");
        }
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        if (empleado != null) {
            this.empleado = empleado;
        } else {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
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

    @Override
    public String toString() {
        return ("Contrato\n" + "--------------------------\n"
                + "ID:                       " + id + "\n"
                + "Tipo:                     " + tipo + "\n"
                + "Fecha de Inicio:          " + fechaInicio + "\n"
                + "Fecha de Fin:             " + fechaFin + "\n"
                + "Valor del Salario:        " + valorSalario + "\n"
                + "Estado:                   " + estado + "\n"
                + "Observaciones:            " + observaciones + "\n"
                + "Cargo:                    " + cargo + "\n"
                + "Empleado:                 " + (empleado != null ? empleado.getNombres() + " " + empleado.getApellidos() : "Sin asignar") + "\n"
                + "Ciclo Académico:          " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin asignar") + "\n");
    }

}
