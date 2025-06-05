/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
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
public class Clase implements Serializable {

    @Id
    private String id;

    @ManyToOne
    private GrupoRegular grupo;
    
    @ManyToOne
    private ProfesorRegular profesor;

    @OneToMany(mappedBy = "clase")
    private List<HorarioClase> bloquesHorarios;
    
    @ManyToOne
    private Asignatura asignatura;

    @OneToMany(mappedBy = "clase")
    private List<Sesion> sesiones;

    @ManyToOne
    private CicloAcademico cicloAcademico;

    @OneToMany(mappedBy = "clase")
    private List<DesempenoAlumno> alumnos;

    // CONSTRUCTORES
    public Clase() {
        this.bloquesHorarios = new ArrayList<>();
        this.sesiones = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public Clase(
            String id,
            GrupoRegular grupo,
            Asignatura asignatura,
            CicloAcademico cicloAcademico) {
        this.id = id;
        this.grupo = grupo;
        this.asignatura = asignatura;
        this.cicloAcademico = cicloAcademico;
        this.bloquesHorarios = new ArrayList<>();
        this.sesiones = new ArrayList<>();
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

    public GrupoRegular getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoRegular grupo) {
        if (grupo != null) {
            this.grupo = grupo;
        } else {
            throw new IllegalArgumentException("El grupo no puede ser nulo.");
        }
    }

    public ProfesorRegular getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorRegular profesor) {
        if (profesor != null) {
            this.profesor = profesor;
        } else {
            throw new IllegalArgumentException("El profesor no puede ser nulo.");
        }
    }

    public List<HorarioClase> getBloquesHorario() {
        return bloquesHorarios;
    }

    public void setBloquesHorario(List<HorarioClase> bloquesHorario) {
        if (bloquesHorario != null) {
            this.bloquesHorarios = bloquesHorario;
        } else {
            throw new IllegalArgumentException("La lista de bloques de horario no puede ser nula.");
        }
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        if (asignatura != null) {
            this.asignatura = asignatura;
        } else {
            throw new IllegalArgumentException("La asignatura no puede ser nula.");
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

    public List<DesempenoAlumno> getDesempeno() {
        return alumnos;
    }

    public void setDesempeno(List<DesempenoAlumno> desempeno) {
        if (desempeno != null) {
            this.alumnos = desempeno;
        } else {
            throw new IllegalArgumentException("La lista de desempeño no puede ser nula.");
        }
    }

    //OTROS METODOS
    public void addBloqueHorario(HorarioClase bloqueHorario) {
        if (bloqueHorario != null && !this.bloquesHorarios.contains(bloqueHorario)) {
            this.bloquesHorarios.add(bloqueHorario);
        } else {
            throw new IllegalArgumentException("El bloque horario no puede ser nulo o ya existe en la lista.");
        }
    }

    public void addSesion(Sesion sesion) {
        if (sesion != null && !this.sesiones.contains(sesion)) {
            this.sesiones.add(sesion);
        } else {
            throw new IllegalArgumentException("La sesión no puede ser nula o ya existe en la lista.");
        }
    }

    public void addAlumno(DesempenoAlumno alumno) {
        if (alumno != null && !this.alumnos.contains(alumno)) {
            this.alumnos.add(alumno);
        } else {
            throw new IllegalArgumentException("El desempeño del alumno no puede ser nulo o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Clase\n" + "--------------------------\n"
                + "ID :                            " + id + "\n"
                + "Grupo:                          " + (grupo != null ? grupo.getNombre() : "Sin asignar") + "\n"
                + "Profesor:                       " + (profesor != null ? profesor.getNombres() + " " + profesor.getApellidos() : "Sin asignar") + "\n"
                + "Cantidad de Bloques Horario:    " + bloquesHorarios.size() + "\n"
                + "Asignatura:                     " + (asignatura != null ? asignatura.getNombre() : "Sin asignar") + "\n"
                + "Cantidad de Sesiones:           " + sesiones.size() + "\n"
                + "Ciclo Académico:                " + (cicloAcademico != null ? cicloAcademico.getId() : "Sin asignar") + "\n"
                + "Cantidad de Alumnos:            " + alumnos.size() + "\n");
    }

}
