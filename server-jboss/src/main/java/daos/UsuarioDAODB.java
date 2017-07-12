/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Usuario;

/**
 *
 * @author flavio
 */
@Stateless
//@TransactionManagement(TransactionManagementType.BEAN)
//@TransactionAttribute(value = TransactionAttributeType.NEVER)
public class UsuarioDAODB implements UsuarioDAO {

    @PersistenceContext
    private EntityManager entityMgr;

    @Override
    public void guardarUsuario(Usuario u) {
        entityMgr.persist(u);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return entityMgr.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> getUsuariosNoAdministradores() {
        return entityMgr
                .createQuery("from " + Usuario.class.getSimpleName() + " u where u.administrador = false")
                .getResultList();
    }

    @Override
    public Usuario getUsuarioByMail(String email) {
        return (Usuario) entityMgr
                .createQuery("from " + Usuario.class.getSimpleName() + " u where u.mail = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

}
