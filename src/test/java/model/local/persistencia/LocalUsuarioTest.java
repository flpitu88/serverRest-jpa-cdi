/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.local.persistencia;

import java.time.LocalDate;
import java.time.Month;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Usuario;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author flpitu88
 */
public class LocalUsuarioTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void openDatabase() {
        emf = Persistence.createEntityManagerFactory("pUnitTest");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void closeDatabase() {
        em.close();
        emf.close();
    }

    @Test
    public void probarMailInvalidoDeUsuarioTest() {
        em.getTransaction().begin();
        Usuario u = new Usuario(
                "33442887",
                "Flavio",
                "Pietrolati",
                "@mail",
                LocalDate.of(1988, Month.JANUARY, 1),
                Boolean.FALSE,
                "flavito");
        em.persist(u);
        em.getTransaction().commit();
    }
}
