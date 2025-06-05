/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.DiaSemana;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class BloqueHorario implements Serializable {
    
    @Id 
    private String id;
    private DiaSemana dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    @OneToMany (mappedBy = "bloqueHorario")
    private List<HorarioClase> clases;
    
    @OneToMany (mappedBy = "bloqueHorario")
    private List<Sesion> sesiones;

    // CONSTRUCTORES
    public BloqueHorario() {
        this.clases = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    public BloqueHorario(
            String id,
            DiaSemana dia,
            LocalTime horaInicio,
            LocalTime horaFin) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.clases = new ArrayList<>();
        this.sesiones = new ArrayList<>();
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

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        if (dia != null) {
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("El día de la semana no puede ser nulo.");
        }
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        if (horaInicio != null) {
            if (this.horaFin != null && horaInicio.isAfter(this.horaFin)) {
                throw new IllegalArgumentException("La hora de inicio no puede ser posterior a la hora de fin.");
            }
            this.horaInicio = horaInicio;
        } else {
            throw new IllegalArgumentException("La hora de inicio no puede ser nula.");
        }
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        if (horaFin != null) {
            if (this.horaInicio != null && horaFin.isBefore(this.horaInicio)) {
                throw new IllegalArgumentException("La hora de fin no puede ser anterior a la hora de inicio.");
            }
            this.horaFin = horaFin;
        } else {
            throw new IllegalArgumentException("La hora de fin no puede ser nula.");
        }
    }

    public List<HorarioClase> getClases() {
        return clases;
    }

    public void setClases(List<HorarioClase> clases) {
        if (clases != null) {
            this.clases = clases;
        } else {
            throw new IllegalArgumentException("La lista de clases no puede ser nula.");
        }
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesion> sesiones) {
        if (sesiones != null) {
            this.sesiones = sesiones;
        } else {
            throw new IllegalArgumentException("La lista de sesiones no puede ser nula.");
        }
    }

    //OTROS METODOS
    public void addClase(HorarioClase clase) {
        if (clase != null && !this.clases.contains(clase)) {
            this.clases.add(clase);
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula o ya existe en la lista.");
        }
    }

    public void addSesion(Sesion sesion) {
        if (sesion != null && !this.sesiones.contains(sesion)) {
            this.sesiones.add(sesion);
        } else {
            throw new IllegalArgumentException("La sesión no puede ser nula o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("BloqueHorario\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Día:                    " + dia + "\n"
                + "Hora de Inicio:         " + horaInicio + "\n"
                + "Hora de Fin:            " + horaFin + "\n"
                + "Cantidad de Clases:     " + clases.size() + "\n"
                + "Cantidad de Sesiones:   " + sesiones.size() + "\n");
    }
}
