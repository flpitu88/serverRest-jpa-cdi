/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.time.LocalDate;
import java.util.List;
import modelo.Turno;
import modelo.Usuario;

/**
 *
 * @author flavio
 */
public interface TurnosDAO {

    public void guardarTurno(Turno t);

    public void actualizarTurno(Turno t);

    public Turno getTurnoLibre(Turno t);

    public List<Turno> getTurnosRegistrados();

    public List<Turno> getDiasConTurnosDisponibles();

    public List<Turno> getTurnosDisponiblesDelDia(LocalDate ld);

    public List<Turno> obtenerTurnosDeUsuario(Usuario u);

    public Turno getTurnoPorId(Integer id);
}
