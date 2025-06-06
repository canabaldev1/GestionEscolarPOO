/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Curso implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    @ManyToOne
    private NivelEducativo nivelEducativo;
    
    @OneToMany (mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> grupos;
    
    @ManyToOne
    private Modalidad modalidad;
    
    @OneToMany (mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas;

    // CONSTRUCTORES
    public Curso() {
        this.grupos = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    public Curso(
            String id,
            String nombre,
            NivelEducativo nivelEducativo) {
        this.nombre = nombre;
        this.nivelEducativo = nivelEducativo;
        this.grupos = new ArrayList<>();
        this.matriculas = new ArrayList<>();
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

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        if (nivelEducativo != null) {
            this.nivelEducativo = nivelEducativo;
        } else {
            throw new IllegalArgumentException("El nivel educativo no puede ser nulo.");
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

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        if (modalidad != null) {
            this.modalidad = modalidad;
        } else {
            throw new IllegalArgumentException("La modalidad no puede ser nula.");
        }
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        if (matriculas != null) {
            this.matriculas = matriculas;
        } else {
            throw new IllegalArgumentException("La lista de matrículas no puede ser nula.");
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

    public void addMatricula(Matricula matricula) {
        if (matricula != null && !this.matriculas.contains(matricula)) {
            this.matriculas.add(matricula);
        } else {
            throw new IllegalArgumentException("La matrícula no puede ser nula o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Curso\n" + "--------------------------\n"
                + "ID :                      " + id + "\n"
                + "Nombre:                   " + nombre + "\n"
                + "Nivel Educativo:          " + (nivelEducativo != null ? nivelEducativo.getNombre() : "Sin asignar") + "\n"
                + "Cantidad de Grupos:       " + grupos.size() + "\n"
                + "Modalidad:                " + (modalidad != null ? modalidad.getNombre() : "Sin asignar") + "\n"
                + "Cantidad de Matrículas:   " + matriculas.size() + "\n");
    }

}
