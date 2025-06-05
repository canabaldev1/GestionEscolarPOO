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
public class HorarioClase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Clase clase;

    @ManyToOne
    private BloqueHorario bloqueHorario;

    // CONSTRUCTORES
    public HorarioClase() {
    }

    public HorarioClase(Clase clase, BloqueHorario bloqueHorario) {
        this.clase = clase;
        this.bloqueHorario = bloqueHorario;
    }

    // SETTERS Y GETTERS
    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return ("Horario Clase\n" + "--------------------------\n"
                + "ID :                          " + id + "\n"
                + "Bloque Horario:               " + bloqueHorario.getId() + "\n"
                + "Clase:                        " + clase.getId() + "\n");
    }

}
