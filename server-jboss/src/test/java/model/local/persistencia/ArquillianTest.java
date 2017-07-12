/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.local.persistencia;

import daos.UsuarioDAO;
import java.io.File;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import modelo.Usuario;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author hernan
 */
//@RunWith(Arquillian.class)
//public class ArquillianTest {
//
//    @Inject
//    private UsuarioDAO usuarioDAO;
//
//    @Deployment
//    public static JavaArchive createDeployment() {
//        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
//                .addPackages(true, "daos")
//                .addPackages(true, "modelo")
//                .addAsManifestResource(new File("src/main/resources/META-INF", "persistence.xml"));
//        System.out.println(jar.toString(true));
//        return jar;
//    }
//
//    @Test
//    public void testUsuarioDAO() {
//        Usuario u = new Usuario(
//                "25444154",
//                "ABCV",
//                "SDG",
//                "mail@mail",
//                LocalDate.now(),
//                true,
//                "123");
//        usuarioDAO.guardarUsuario(u);
//    }
//}
