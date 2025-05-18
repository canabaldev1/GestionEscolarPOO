/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.ParentescoAcudiente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class Alumno extends Usuario {

    private String nombreAcudiente;
    private String apellidoAcudiente;
    private ParentescoAcudiente parentesco;
    private List<Matricula> matriculas;
    private List<AsignacionAlumnoGrupo> grupos;
    private List<AsistenciaSesion> sesiones;
    private List<DesempenoAlumno> clases;
    private List<AsignacionAlumnoServicio> serviciosComplementarios;

    // CONSTRUCTORES
    public Alumno() {
        super();
        this.matriculas = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.sesiones = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.serviciosComplementarios = new ArrayList<>();
    }

    public Alumno(
            String id,
            String nombres,
            String apellidos,
            String contrasena,
            String email) {
        super(id, nombres, apellidos, contrasena, email);
        this.matriculas = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.sesiones = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.serviciosComplementarios = new ArrayList<>();
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
        return grupos;
    }

    public void setAsignacionesAGrupos(List<AsignacionAlumnoGrupo> asignacionesAGrupos) {
        if (asignacionesAGrupos != null) {
            this.grupos = asignacionesAGrupos;
        } else {
            throw new IllegalArgumentException("La lista de asignaciones a grupos no puede ser nula.");
        }
    }

    public List<AsistenciaSesion> getAsistencias() {
        return sesiones;
    }

    public void setAsistencias(List<AsistenciaSesion> asistencias) {
        if (asistencias != null) {
            this.sesiones = asistencias;
        } else {
            throw new IllegalArgumentException("La lista de asistencias no puede ser nula.");
        }
    }

    public List<DesempenoAlumno> getDesempeno() {
        return clases;
    }

    public void setDesempeno(List<DesempenoAlumno> desempeno) {
        if (desempeno != null) {
            this.clases = desempeno;
        } else {
            throw new IllegalArgumentException("La lista de desempeño no puede ser nula.");
        }
    }

    public List<AsignacionAlumnoServicio> getAsignacionesDeServicios() {
        return serviciosComplementarios;
    }

    public void setAsignacionesDeServicios(List<AsignacionAlumnoServicio> asignacionesDeServicios) {
        if (asignacionesDeServicios != null) {
            this.serviciosComplementarios = asignacionesDeServicios;
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
        if (grupo != null && !this.grupos.contains(grupo)) {
            this.grupos.add(grupo);
        } else {
            throw new IllegalArgumentException("El grupo no puede ser nulo o ya existe en la lista.");
        }
    }

    public void addSesion(AsistenciaSesion sesion) {
        if (sesion != null && !this.sesiones.contains(sesion)) {
            this.sesiones.add(sesion);
        } else {
            throw new IllegalArgumentException("La sesión no puede ser nula o ya existe en la lista.");
        }
    }

    public void addClase(DesempenoAlumno clase) {
        if (clase != null && !this.clases.contains(clase)) {
            this.clases.add(clase);
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula o ya existe en la lista.");
        }
    }

    public void addServicioComplementario(AsignacionAlumnoServicio servicio) {
        if (servicio != null && !this.serviciosComplementarios.contains(servicio)) {
            this.serviciosComplementarios.add(servicio);
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
                + "Grupos:                 " + grupos.size() + "\n"
                + "Sesiones:               " + sesiones.size() + "\n"
                + "Clases:                 " + clases.size() + "\n"
                + "Servicios Complementarios: " + serviciosComplementarios.size() + "\n");
    }

}
