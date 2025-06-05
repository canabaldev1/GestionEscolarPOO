/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lm-carlos
 */
@Entity

public class ProfesorInfantil extends Profesor {
    
    @OneToMany(mappedBy = "profesorEncargado")
    private List<GrupoInfantil> gruposEncargados;

    @OneToMany(mappedBy = "profesorAsistente")
    private List<GrupoInfantil> gruposAsistentes;

    // CONSTRUCTORES
    public ProfesorInfantil() {
        super();
    }

    public ProfesorInfantil(
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
    }

    // GETTERS Y SETTERS
    public List<GrupoInfantil> getGruposEncargados() {
        return gruposEncargados;
    }

    public void setGrupoEncargados(List<GrupoInfantil> gruposEncargados) {
        if (gruposEncargados != null) {
            this.gruposEncargados = gruposEncargados;
        } else {
            throw new IllegalArgumentException("El grupo infantil no puede ser nulo.");
        }
    }

    public List<GrupoInfantil> getGruposAsistentes() {
        return gruposAsistentes;
    }

    public void setGruposAsistentes(List<GrupoInfantil> gruposAsistentes) {
        if (gruposAsistentes != null) {
            this.gruposAsistentes = gruposAsistentes;
        } else {
            throw new IllegalArgumentException("El grupo infantil no puede ser nulo.");
        }
    }

        @Override
    public String toString() {
        return ("Profesor Infantil\n" + "--------------------------\n"
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
                + "Grupos Encargados:         " + gruposEncargados.size()  + "\n"
                + "Grupos Asistentes:         " + gruposAsistentes.size()  + "\n");
    }
    
}
