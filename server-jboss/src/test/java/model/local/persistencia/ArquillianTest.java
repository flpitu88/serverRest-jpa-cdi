/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.local.persistencia;

import daos.MotivoConsultaDAO;
import daos.UsuarioDAO;
import java.io.File;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolationException;
import modelo.MotivoConsulta;
import modelo.Usuario;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author hernan
 */
@RunWith(Arquillian.class)
public class ArquillianTest {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private MotivoConsultaDAO motivoConsultaDAO;

    @Inject
    private UserTransaction userTransaction;

    @PersistenceContext
    private EntityManager entityManager;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "daos")
                .addPackages(true, "modelo")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource(new File("src/main/resources/META-INF", "persistence.xml"));
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void testUsuarioDAO() {
        Usuario u = new Usuario(
                "25444154",
                "ABCV",
                "SDG",
                "mail@mail",
                LocalDate.now(),
                true,
                "123");
        usuarioDAO.guardarUsuario(u);

        Usuario otroUsuario = usuarioDAO.getUsuarioById(u.getId());

        Assert.assertEquals(u.getNombre(), otroUsuario.getNombre());
    }

    @Test
    public void probarNoNuloExceptionMotivoConsulta() throws Exception {
        try {
//            userTransaction.begin();
//            entityManager.persist(new MotivoConsulta());
//            userTransaction.commit();
            motivoConsultaDAO.guardarMotivo(new MotivoConsulta());
        } catch (Throwable ex) {
            Assert.assertEquals(ConstraintViolationException.class, ex.getCause().getClass());
//            userTransaction.rollback();
        }
    }
}
