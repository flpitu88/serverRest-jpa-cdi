/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author flpitu88
 */
@Entity
@Table(uniqueConstraints
        = @UniqueConstraint(columnNames = {"dia", "horario"}))
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @NotNull
    private LocalDate dia;

    @Column(nullable = false, updatable = false)
    @NotNull
    private LocalTime horario;

    @Column(nullable = true)
    private Usuario usuario;

    @Column(nullable = true)
    private MotivoConsulta motivo;

    public Turno() {
    }

    public Turno(Integer id, LocalDate dia, LocalTime horario,
            Usuario usuario, MotivoConsulta motivo) {
        this.id = id;
        this.dia = dia;
        this.horario = horario;
        this.usuario = usuario;
        this.motivo = motivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MotivoConsulta getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoConsulta motivo) {
        this.motivo = motivo;
    }

    /**
     * Si dos turnos refieren al mismo dia y horario, ya corresponden
     * al mismo turno.
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) obj;
        if (this.dia != other.getDia() || this.horario != other.getHorario()) {
            return true;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.dia);
        hash = 29 * hash + Objects.hashCode(this.horario);
        return hash;
    }

}
