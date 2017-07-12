/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author flavio
 */
public interface UsuarioDAO {

    public void guardarUsuario(Usuario u);

    public Usuario getUsuarioById(Integer id);

    public List<Usuario> getUsuariosNoAdministradores();

    public Usuario getUsuarioByMail(String email);
}
