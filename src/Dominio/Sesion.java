/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class Sesion implements Serializable {
    
    @Id
    private String id;
    private LocalDate fecha;
    private int semana;

    @ManyToOne
    private BloqueHorario bloqueHorario;

    @OneToMany
    private List<AsistenciaSesion> alumnos;

    @ManyToOne
    private Aula aula;

    @ManyToOne
    private Clase clase;

    // CONSTRUCTORES
    public Sesion() {
        this.alumnos = new ArrayList<>();
    }

    public Sesion(
            String id,
            LocalDate fecha,
            int semana,
            BloqueHorario bloqueHorario,
            Aula aula,
            Clase clase) {
        this.id = id;
        this.fecha = fecha;
        this.semana = semana;
        this.bloqueHorario = bloqueHorario;
        this.aula = aula;
        this.clase = clase;
        this.alumnos = new ArrayList<>();
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha != null) {
            this.fecha = fecha;
        } else {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        if (semana > 0) {
            this.semana = semana;
        } else {
            throw new IllegalArgumentException("La semana debe ser un valor positivo.");
        }
    }

    public BloqueHorario getBloqueHorario() {
        return bloqueHorario;
    }

    public void setBloqueHorario(BloqueHorario bloqueHorario) {
        if (bloqueHorario != null) {
            this.bloqueHorario = bloqueHorario;
        } else {
            throw new IllegalArgumentException("El bloque horario no puede ser nulo.");
        }
    }

    public List<AsistenciaSesion> getAsistencias() {
        return alumnos;
    }

    public void setAsistencias(List<AsistenciaSesion> asistencias) {
        if (asistencias != null) {
            this.alumnos = asistencias;
        } else {
            throw new IllegalArgumentException("La lista de asistencias no puede ser nula.");
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

    //OTROS METODOS
    public void addAlumno(AsistenciaSesion alumno) {
        if (alumno != null && !this.alumnos.contains(alumno)) {
            this.alumnos.add(alumno);
        } else {
            throw new IllegalArgumentException("La asistencia no puede ser nula o ya está registrada.");
        }
    }

    @Override
    public String toString() {
        return ("Sesión\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Fecha:                        " + fecha + "\n"
                + "Semana:                       " + semana + "\n"
                + "Bloque Horario:               " + (bloqueHorario != null ? bloqueHorario.getId() : "Sin bloque horario") + "\n"
                + "Cantidad de Alumnos:          " + alumnos.size() + "\n"
                + "Aula:                         " + (aula != null ? aula.getNombre() : "Sin aula asignada") + "\n"
                + "Clase:                        " + (clase != null ? clase.getId() : "Sin clase asignada") + "\n");
    }

}
