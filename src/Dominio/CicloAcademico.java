/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoCicloAcademico;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lm-carlos
 */
@Entity
public class CicloAcademico implements Serializable {
    
    @Id
    private String id;
    private int anio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    @Enumerated (value = EnumType.STRING)
    private EstadoCicloAcademico estado;
    
    private int cantidadSemanas;
    
    @OneToMany (mappedBy = "cicloAcademico")
    private List<Matricula> matriculas;
    
    @OneToMany (mappedBy = "cicloAcademico")
    private List<Contrato> contratos;
    
    @OneToMany (mappedBy = "cicloAcademico")
    private List<Grupo> grupos;
    
    @OneToMany (mappedBy = "cicloAcademico")
    private List<Clase> clases;
    
    @OneToMany (mappedBy = "cicloAcademico")
    private List<ServicioComplementario> serviciosComplementarios;

    // CONSTRUCTORES
    public CicloAcademico() {
        this.matriculas = new ArrayList<>();
        this.contratos = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.serviciosComplementarios = new ArrayList<>();
    }

    public CicloAcademico(
            String id,
            int anio,
            int cantidadSemanas) {
        this.id = id;
        this.anio = anio;
        this.estado = EstadoCicloAcademico.EN_PROYECCION;
        this.cantidadSemanas = cantidadSemanas;
        this.matriculas = new ArrayList<>();
        this.contratos = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.serviciosComplementarios = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío.");
        }
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio <= 0) {
            throw new IllegalArgumentException("El año debe ser mayor que cero.");
        }
        this.anio = anio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio != null) {
            if (this.fechaFin != null && fechaInicio.isAfter(this.fechaFin)) {
                throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
            }
            this.fechaInicio = fechaInicio;
        } else {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
        }
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;

        if (fechaFin != null) {
            if (this.fechaInicio != null && fechaFin.isBefore(this.fechaInicio)) {
                throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
            }
            this.fechaFin = fechaFin;
        } else {
            throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
        }
    }

    public EstadoCicloAcademico getEstado() {
        return estado;
    }

    public void setEstado(EstadoCicloAcademico estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
    }

    public int getCantidadSemanas() {
        return cantidadSemanas;
    }

    public void setCantidadSemanas(int cantidadSemanas) {
        if (cantidadSemanas <= 0 || cantidadSemanas > 52) {
            throw new IllegalArgumentException("La cantidad de semanas debe ser mayor que 0 y menor que 52.");
        }
        this.cantidadSemanas = cantidadSemanas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        if (matriculas == null) {
            throw new IllegalArgumentException("La lista de matrículas no puede ser nula.");
        }
        this.matriculas = matriculas;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        if (contratos == null) {
            throw new IllegalArgumentException("La lista de contratos no puede ser nula.");
        }
        this.contratos = contratos;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        if (grupos == null) {
            throw new IllegalArgumentException("La lista de grupos no puede ser nula.");
        }
        this.grupos = grupos;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        if (clases == null) {
            throw new IllegalArgumentException("La lista de clases no puede ser nula.");
        }
        this.clases = clases;
    }

    public List<ServicioComplementario> getServiciosComplementarios() {
        return serviciosComplementarios;
    }

    public void setServiciosComplementarios(List<ServicioComplementario> serviciosComplementarios) {
        if (serviciosComplementarios == null) {
            throw new IllegalArgumentException("La lista de servicios complementarios no puede ser nula.");
        }
        this.serviciosComplementarios = serviciosComplementarios;
    }

    //OTROS METODOS
    public void addMatricula(Matricula matricula) {
        if (matricula != null && !this.matriculas.contains(matricula)) {
            this.matriculas.add(matricula);
        } else {
            throw new IllegalArgumentException("La matrícula no puede ser nula o ya existe en la lista.");
        }
    }

    public void addContrato(Contrato contrato) {
        if (contrato != null && !this.contratos.contains(contrato)) {
            this.contratos.add(contrato);
        } else {
            throw new IllegalArgumentException("El contrato no puede ser nulo o ya existe en la lista.");
        }
    }

    public void addGrupo(Grupo grupo) {
        if (grupo != null && !this.grupos.contains(grupo)) {
            this.grupos.add(grupo);
        } else {
            throw new IllegalArgumentException("El grupo no puede ser nulo o ya existe en la lista.");
        }
    }

    public void addClase(Clase clase) {
        if (clase != null && !this.clases.contains(clase)) {
            this.clases.add(clase);
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula o ya existe en la lista.");
        }
    }

    public void addServicioComplementario(ServicioComplementario servicio) {
        if (servicio != null && !this.serviciosComplementarios.contains(servicio)) {
            this.serviciosComplementarios.add(servicio);
        } else {
            throw new IllegalArgumentException("El servicio complementario no puede ser nulo o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("CicloAcademico\n" + "--------------------------\n"
                + "ID :                            " + id + "\n"
                + "Año:                            " + anio + "\n"
                + "Fecha de Inicio:                " + fechaInicio + "\n"
                + "Fecha de Fin:                   " + fechaFin + "\n"
                + "Estado:                         " + estado + "\n"
                + "Cantidad de Semanas:           " + cantidadSemanas + "\n"
                + "Cantidad de Matrículas:        " + matriculas.size() + "\n"
                + "Cantidad de Contratos:         " + contratos.size() + "\n"
                + "Cantidad de Grupos:            " + grupos.size() + "\n"
                + "Cantidad de Clases:            " + clases.size() + "\n"
                + "Servicios Complementarios:     " + serviciosComplementarios.size() + "\n");
    }

}
