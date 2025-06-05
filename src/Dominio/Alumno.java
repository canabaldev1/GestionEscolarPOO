/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.ParentescoAcudiente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class Alumno extends Usuario implements Serializable{

    private String nombreAcudiente;
    private String apellidoAcudiente;
    private ParentescoAcudiente parentesco;
    @OneToMany(mappedBy = "alumno")
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "alumno")
    private List<AsignacionAlumnoGrupo> asignacionesAlumnoGrupo;

    @OneToMany(mappedBy = "alumno")
    private List<AsistenciaSesion> asistenciaSesiones;

    @OneToMany(mappedBy = "alumno")
    private List<DesempenoAlumno> desempenoAlumno;

    @OneToMany(mappedBy = "alumno")
    private List<AsignacionAlumnoServicio> asignacionesAlumnoServicios;

    // CONSTRUCTORES
    public Alumno() {
        super();
        this.matriculas = new ArrayList<>();
        this.asignacionesAlumnoGrupo = new ArrayList<>();
        this.asistenciaSesiones = new ArrayList<>();
        this.desempenoAlumno = new ArrayList<>();
        this.asignacionesAlumnoServicios = new ArrayList<>();
    }

    public Alumno(
            String id,
            String nombres,
            String apellidos,
            String contrasena,
            String email) {
        super(id, nombres, apellidos, contrasena, email);
        this.matriculas = new ArrayList<>();
        this.asignacionesAlumnoGrupo = new ArrayList<>();
        this.asistenciaSesiones = new ArrayList<>();
        this.desempenoAlumno = new ArrayList<>();
        this.asignacionesAlumnoServicios = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        if (nombreAcudiente != null && nombreAcudiente.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$")) {
            this.nombreAcudiente = nombreAcudiente;
        } else {
            throw new IllegalArgumentException("El nombre del acudiente solo puede contener letras y espacios.");
        }
    }

    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }

    public void setApellidoAcudiente(String apellidoAcudiente) {
        if (apellidoAcudiente != null && apellidoAcudiente.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$")) {
            this.apellidoAcudiente = apellidoAcudiente;
        } else {
            throw new IllegalArgumentException("El apellido del acudiente solo puede contener letras y espacios.");
        }
    }

    public ParentescoAcudiente getParentesco() {
        return parentesco;
    }

    public void setParentesco(ParentescoAcudiente parentesco) {
        if (parentesco != null) {
            this.parentesco = parentesco;
        } else {
            throw new IllegalArgumentException("El parentesco no puede ser nulo.");
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

    public List<AsignacionAlumnoGrupo> getAsignacionesAGrupos() {
        return asignacionesAlumnoGrupo;
    }

    public void setAsignacionesAGrupos(List<AsignacionAlumnoGrupo> asignacionesAGrupos) {
        if (asignacionesAGrupos != null) {
            this.asignacionesAlumnoGrupo = asignacionesAGrupos;
        } else {
            throw new IllegalArgumentException("La lista de asignaciones a grupos no puede ser nula.");
        }
    }

    public List<AsistenciaSesion> getAsistencias() {
        return asistenciaSesiones;
    }

    public void setAsistencias(List<AsistenciaSesion> asistencias) {
        if (asistencias != null) {
            this.asistenciaSesiones = asistencias;
        } else {
            throw new IllegalArgumentException("La lista de asistencias no puede ser nula.");
        }
    }

    public List<DesempenoAlumno> getDesempeno() {
        return desempenoAlumno;
    }

    public void setDesempeno(List<DesempenoAlumno> desempeno) {
        if (desempeno != null) {
            this.desempenoAlumno = desempeno;
        } else {
            throw new IllegalArgumentException("La lista de desempeño no puede ser nula.");
        }
    }

    public List<AsignacionAlumnoServicio> getAsignacionesDeServicios() {
        return asignacionesAlumnoServicios;
    }

    public void setAsignacionesDeServicios(List<AsignacionAlumnoServicio> asignacionesDeServicios) {
        if (asignacionesDeServicios != null) {
            this.asignacionesAlumnoServicios = asignacionesDeServicios;
        } else {
            throw new IllegalArgumentException("La lista de asignaciones de servicios no puede ser nula.");
        }
    }

    //OTROS METODOS
    public void addMatricula(Matricula matricula) {
        if (matricula != null && !this.matriculas.contains(matricula)) {
            this.matriculas.add(matricula);
        } else {
            throw new IllegalArgumentException("La matrícula no puede ser nula o ya existe en la lista.");
        }
    }

    public void addGrupo(AsignacionAlumnoGrupo grupo) {
        if (grupo != null && !this.asignacionesAlumnoGrupo.contains(grupo)) {
            this.asignacionesAlumnoGrupo.add(grupo);
        } else {
            throw new IllegalArgumentException("El grupo no puede ser nulo o ya existe en la lista.");
        }
    }

    public void addSesion(AsistenciaSesion sesion) {
        if (sesion != null && !this.asistenciaSesiones.contains(sesion)) {
            this.asistenciaSesiones.add(sesion);
        } else {
            throw new IllegalArgumentException("La sesión no puede ser nula o ya existe en la lista.");
        }
    }

    public void addClase(DesempenoAlumno clase) {
        if (clase != null && !this.desempenoAlumno.contains(clase)) {
            this.desempenoAlumno.add(clase);
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula o ya existe en la lista.");
        }
    }

    public void addServicioComplementario(AsignacionAlumnoServicio servicio) {
        if (servicio != null && !this.asignacionesAlumnoServicios.contains(servicio)) {
            this.asignacionesAlumnoServicios.add(servicio);
        } else {
            throw new IllegalArgumentException("El servicio complementario no puede ser nulo o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Alumno\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombres:                " + nombres + "\n"
                + "Apellidos:              " + apellidos + "\n"
                + "Fecha de Nacimiento:    " + fechaNacimiento + "\n"
                + "Contraseña:             " + contrasena + "\n"
                + "Dirección:              " + direccion + "\n"
                + "Email:                  " + email + "\n"
                + "Teléfono:               " + telefono + "\n"
                + "Nombre Acudiente:       " + nombreAcudiente + "\n"
                + "Apellido Acudiente:     " + apellidoAcudiente + "\n"
                + "Parentesco Acudiente:   " + parentesco + "\n"
                + "Matriculas:             " + matriculas.size() + "\n"
                + "Grupos:                 " + asignacionesAlumnoGrupo.size() + "\n"
                + "Sesiones:               " + asistenciaSesiones.size() + "\n"
                + "Clases:                 " + desempenoAlumno.size() + "\n"
                + "Servicios Complementarios: " + asignacionesAlumnoServicios.size() + "\n");
    }

}
