/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Constantes.EstadoEmpleado;
import Dominio.Constantes.TipoCuenta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public abstract class Empleado extends Usuario {

    protected String profesion;
    protected String numeroCuentaBancaria;
    protected TipoCuenta tipoCuentaBancaria;
    protected String bancoAsociado;
    protected LocalDate fechaIngreso;
    protected EstadoEmpleado estado;
    protected List<Contrato> contratos;

    // CONSTRUCTORES
    public Empleado() {
        super();
        this.contratos = new ArrayList<>();
    }

    public Empleado(
            String id,
            String nombres,
            String apellidos,
            String contrasena,
            String email,
            LocalDate fechaIngreso) {
        super(id, nombres, apellidos, contrasena, email);
        this.fechaIngreso = fechaIngreso;
        this.contratos = new ArrayList<>();
    }

    // GETTERS Y SETTERS
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        if (profesion != null && !profesion.isBlank()) {
            this.profesion = profesion;
        } else {
            throw new IllegalArgumentException("La profesión no puede estar vacía.");
        }
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        if (numeroCuentaBancaria != null && numeroCuentaBancaria.matches("\\d{6,20}")) {
            this.numeroCuentaBancaria = numeroCuentaBancaria;
        } else {
            throw new IllegalArgumentException("Número de cuenta inválido. Debe tener entre 6 y 20 dígitos.");
        }
    }

    public TipoCuenta getTipoCuentaBancaria() {
        return tipoCuentaBancaria;
    }

    public void setTipoCuentaBancaria(TipoCuenta tipoCuentaBancaria) {
        if (tipoCuentaBancaria != null) {
            this.tipoCuentaBancaria = tipoCuentaBancaria;
        } else {
            throw new IllegalArgumentException("El tipo de cuenta no puede ser nulo.");
        }
    }

    public String getBancoAsociado() {
        return bancoAsociado;
    }

    public void setBancoAsociado(String bancoAsociado) {
        if (bancoAsociado != null && !bancoAsociado.isBlank()) {
            this.bancoAsociado = bancoAsociado;
        } else {
            throw new IllegalArgumentException("El nombre del banco no puede estar vacío.");
        }
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        if (fechaIngreso != null && !fechaIngreso.isAfter(LocalDate.now())) {
            this.fechaIngreso = fechaIngreso;
        } else {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser futura ni nula.");
        }
    }

    public EstadoEmpleado getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleado estado) {
        if (estado != null) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado del empleado no puede ser nulo.");
        }
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        if (contratos != null) {
            this.contratos = contratos;
        } else {
            throw new IllegalArgumentException("La lista de contratos no puede ser nula.");
        }
    }

    //OTROS METODOS
    public void addContrato(Contrato contrato) {
        if (contrato != null && !this.contratos.contains(contrato)) {
            this.contratos.add(contrato);
        } else {
            throw new IllegalArgumentException("El contrato no puede ser nulo o ya existe en la lista.");
        }
    }

    @Override
    public String toString() {
        return ("Empleado\n" + "--------------------------\n"
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
                + "Contratos:              " + contratos.size() + "\n");
    }

}
