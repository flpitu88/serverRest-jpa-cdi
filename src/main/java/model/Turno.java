/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author flpitu88
 */
@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dia;
    
    @Temporal(value = TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime horario;
    
    @Column(nullable = true)
    @OneToOne
    private Usuario usuario;
    
    @Column(nullable = true)
    @OneToOne
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

}
