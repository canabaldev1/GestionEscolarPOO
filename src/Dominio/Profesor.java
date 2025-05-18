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
public abstract class Profesor extends Empleado {

    protected String titulacionAcademica;

    //CONSTRUCTORES
    public Profesor() {
        super();
    }

    public Profesor(
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
    public String getTitulacionAcademica() {
        return titulacionAcademica;
    }

    public void setTitulacionAcademica(String titulacionAcademica) {
        if (titulacionAcademica != null && !titulacionAcademica.trim().isEmpty()) {
            this.titulacionAcademica = titulacionAcademica.trim();
        } else {
            throw new IllegalArgumentException("La titulación académica no puede estar vacía.");
        }
    }

    @Override
    public String toString() {
        return ("Profesor\n" + "--------------------------\n"
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
                + "Titulación Académica:   " + titulacionAcademica + "\n");
    }
}
