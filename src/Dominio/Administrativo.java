/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.AreaAdministrativa;
import java.time.LocalDate;

/**
 *
 * @author lm-carlos
 */
public class Administrativo extends Empleado {

    private AreaAdministrativa areaAdministrativa;

    // CONSTRUCTORES
    public Administrativo() {
        super();
    }

    public Administrativo(
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

    // SETTERS Y GETTERS
    public AreaAdministrativa getAreaAdministrativa() {
        return this.areaAdministrativa;
    }

    public void setAreaAdministrativa(AreaAdministrativa areaAdministrativa) {
        if (areaAdministrativa != null) {
            this.areaAdministrativa = areaAdministrativa;
        } else {
            throw new IllegalArgumentException("El area administrativa no puede ser nulo.");
        }
    }

    @Override
    public String toString() {
        return ("Administrativo\n" + "--------------------------\n"
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
                + "Área Administrativa:    " + areaAdministrativa + "\n");
    }
}
