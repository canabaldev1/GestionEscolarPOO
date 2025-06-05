/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lm-carlos
 */
@Entity
public class ProfesorRegular extends Profesor {
    
    @OneToMany (mappedBy = "profesor")
    private List<Clase> clases;
    
    @OneToMany (mappedBy = "profesorEncargado")
    private List<GrupoRegular> grupo;

    // CONSTRUCTORES
    public ProfesorRegular() {
        super();
        this.clases = new ArrayList<>();
    }

    public ProfesorRegular(
            String id,
            String nombres,
            String apellidos,
            String contrasena,
            String email,
            LocalDate fechaIngreso) {
        super(
                id,
                nombres,
                apellidos,
                contrasena,
                email,
                fechaIngreso);
        this.clases = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        if (clases != null) {
            this.clases = clases;
        } else {
            throw new IllegalArgumentException("La lista de clases no puede ser nula.");
        }
    }

    public List<GrupoRegular> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<GrupoRegular> grupo) {
        if (grupo != null) {
            this.grupo = grupo;
        } else {
            throw new IllegalArgumentException("El grupo regular no puede ser nulo.");
        }
    }

    //OTROS METODOS
    public void addClase(Clase clase) {
        if (clase != null && !this.clases.contains(clase)) {
            this.clases.add(clase);
        } else {
            throw new IllegalArgumentException("La clase no puede ser nula o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Profesor Regular\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombres:                " + nombres + "\n"
                + "Apellidos:              " + apellidos + "\n"
                + "Fecha de Nacimiento:    " + fechaNacimiento + "\n"
                + "Contraseña:             " + contrasena + "\n"
                + "Dirección:              " + direccion + "\n"
                + "Email:                  " + email + "\n"
                + "Teléfono:               " + telefono + "\n"
                + "Profesión:              " + profesion + "\n"
                + "Numero de Cuenta:       " + numeroCuentaBancaria + "\n"
                + "Tipo de Cuenta:         " + tipoCuentaBancaria + "\n"
                + "Banco:                  " + bancoAsociado + "\n"
                + "Fecha de ingreso:       " + fechaIngreso + "\n"
                + "Estado:                 " + estado + "\n"
                + "Contratos:              " + contratos.size() + "\n"
                + "Titulación Académica:   " + titulacionAcademica + "\n"
                + "Grupo Regular:          " + grupo.size() + "\n"
                + "Cantidad de Clases:     " + clases.size() + "\n");
    }

}
