/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class Aula {

    private String id;
    private String nombre;
    private int capacidad;
    private String ubicacion;
    private List<Grupo> grupos;
    private List<Sesion> sesiones;

    // CONSTRUCTORES
    public Aula() {
        this.grupos = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    public Aula(
            String id,
            String nombre,
            int capacidad,
            String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.grupos = new ArrayList<>();
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
            throw new IllegalArgumentException("El ID del aula no puede ser nulo o vacío.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre del aula no puede ser nulo o vacío.");
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            throw new IllegalArgumentException("La capacidad del aula debe ser mayor a cero.");
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion != null && !ubicacion.trim().isEmpty()) {
            this.ubicacion = ubicacion;
        } else {
            throw new IllegalArgumentException("La ubicación del aula no puede ser nula o vacía.");
        }
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        if (grupos != null) {
            this.grupos = grupos;
        } else {
            throw new IllegalArgumentException("La lista de grupos no puede ser nula.");
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
    public void addGrupo(Grupo grupo) {
        if (grupo != null && !this.grupos.contains(grupo)) {
            this.grupos.add(grupo);
        } else {
            throw new IllegalArgumentException("El grupo no puede ser nulo o ya existe en la lista.");
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
        return ("Aula\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombre:                 " + nombre + "\n"
                + "Capacidad:              " + capacidad + "\n"
                + "Ubicación:              " + ubicacion + "\n"
                + "Grupos:                 " + grupos.size() + "\n"
                + "Sesiones:               " + sesiones.size() + "\n");
    }

}
