/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author lm-carlos
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected String nombres;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    protected String contrasena;
    protected String direccion;
    protected String email;
    protected String telefono;

    // CONSTRUCTORES
    public Usuario() {
    }

    ;
  
  public Usuario(
            String nombres,
            String apellidos,
            String contrasena,
            String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres != null && nombres.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$")) {
            this.nombres = nombres;
        } else {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos != null && apellidos.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]+$")) {
            this.apellidos = apellidos;
        } else {
            throw new IllegalArgumentException("El apellido solo puede contener letras y espacios.");
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento != null && !fechaNacimiento.isAfter(LocalDate.now())) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar en el futuro.");
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena != null && contrasena.length() >= 6) {
            this.contrasena = contrasena;
        } else {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.trim().isEmpty()) {
            this.direccion = direccion;
        } else {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{7,15}")) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("El teléfono debe contener solo números (mínimo 7 dígitos).");
        }
    }
    
    @Override
    public String toString() {
        return ("Usuario\n" + "--------------------------\n"
                + "ID :                    " + id + "\n"
                + "Nombres:                " + nombres + "\n"
                + "Apellidos:              " + apellidos + "\n"
                + "Fecha de Nacimiento:    " + fechaNacimiento + "\n"
                + "Contraseña:             " + contrasena + "\n"
                + "Dirección:              " + direccion + "\n"
                + "Email:                  " + email + "\n"
                + "Teléfono:               " + telefono + "\n");
    }
}
