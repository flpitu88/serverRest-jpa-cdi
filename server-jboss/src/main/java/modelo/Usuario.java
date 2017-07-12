/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 *
 * @author flpitu88
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"mail"})})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 9, nullable = false)
    @NotNull(message = "El DNI es obligatorio")
    private String dni;

    @Column(length = 45, nullable = false)
    @NotNull(message = "El Nombre es obligatorio")
    private String nombre;

    @Column(length = 60, nullable = false)
    @NotNull(message = "El Apellido es obligatorio")
    private String apellido;

    @Column(length = 100, nullable = false)
    /*@Pattern(
            regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;",
            message = "No se corresponde a un mail válido")*/
    @NotNull(message = "El Mail es obligatorio")
    private String mail;

    @Column(nullable = true)
    //@NotNull(message = "La Fecha de Nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    @NotNull
    private Boolean administrador;

    @Column(length = 60, nullable = false)
    @NotNull(message = "La contraseña es obligatoria")
    private String password;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellido,
            String mail, LocalDate fechaNacimiento, Boolean administrador, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.fechaNacimiento = fechaNacimiento;
        this.administrador = administrador;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String crearNombreCompleto() {
        return this.getNombre() + " " + this.getApellido();
    }
}
