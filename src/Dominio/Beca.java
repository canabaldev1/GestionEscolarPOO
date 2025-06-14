/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoBeca;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author lm-carlos
 */
@Entity
public class Beca implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String descripcion;
    private double valorDescuento;
    private String observaciones;
    private String otorgadaPor;
    
    @Enumerated (EnumType.STRING)
    private EstadoBeca estado;
    
    @OneToOne
    private Matricula matricula;

    // CONSTRUCTORES
    public Beca() {
    }

    public Beca(
            String id,
            String nombre,
            String otorgadaPor) {
        this.nombre = nombre;
        this.otorgadaPor = otorgadaPor;
        this.estado = EstadoBeca.DISPONIBLE;
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
        this.descripcion = descripcion;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        if (valorDescuento >= 0) {
            this.valorDescuento = valorDescuento;
        } else {
            throw new IllegalArgumentException("El valor de descuento no puede ser negativo.");
        }
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOtorgadaPor() {
        return otorgadaPor;
    }

    public void setOtorgadaPor(String otorgadaPor) {
        if (otorgadaPor != null && !otorgadaPor.trim().isEmpty()) {
            this.otorgadaPor = otorgadaPor;
        } else {
            throw new IllegalArgumentException("El otorgante no puede ser nulo o vacío.");
        }
    }

    public EstadoBeca getEstado() {
        return estado;
    }

    public void setEstado(EstadoBeca estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return ("Beca\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombre:                 " + nombre + "\n"
                + "Descripción:            " + descripcion + "\n"
                + "Valor Descuento:        " + valorDescuento + "\n"
                + "Observaciones:          " + observaciones + "\n"
                + "Otorgada Por:           " + otorgadaPor + "\n"
                + "Estado:                 " + estado + "\n"
                + "Matrícula Asociada:     " + (matricula != null ? matricula.getId() : "Ninguna") + "\n");
    }

}
