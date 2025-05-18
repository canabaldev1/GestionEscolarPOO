/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class HorarioClase {

    private String id;
    private Clase clase;
    private BloqueHorario bloqueHorario;

    // CONSTRUCTORES
    public HorarioClase() {
    }

    public HorarioClase(String id, Clase clase, BloqueHorario bloqueHorario) {
        this.id = id;
        this.clase = clase;
        this.bloqueHorario = bloqueHorario;
    }

    // SETTERS Y GETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo.");
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
                + "Bloque Horario:               " + bloqueHorario.getId()+ "\n"
                + "Clase:                        " + clase.getId()+ "\n");
    }

}
