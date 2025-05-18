/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author lm-carlos
 */
public class AsistenciaSesion {

    private String id;
    private Alumno alumno;
    private Sesion sesion;
    private boolean presente;
    private String observaciones;

    // CONSTRUCTORES
    public AsistenciaSesion() {
    }

    public AsistenciaSesion(
            String id,
            Alumno alumno,
            Sesion sesion,
            boolean presente) {
        this.id = id;
        this.alumno = alumno;
        this.sesion = sesion;
        this.presente = presente;
    }

    //GETTERS Y SETTERS
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
