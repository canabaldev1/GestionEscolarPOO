/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;

/**
 *
 * @author lm-carlos
 */
public class ProfesorInfantil extends Profesor {

    private GrupoInfantil grupo;

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
    public GrupoInfantil getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoInfantil grupo) {
        if (grupo != null) {
            this.grupo = grupo;
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
                + "Grupo Infantil:         " + (grupo != null ? grupo.getNombre() : "Sin grupo") + "\n");
    }
    
}
