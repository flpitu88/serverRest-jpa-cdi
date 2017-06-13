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
import javax.persistence.PersistenceException;
import modelo.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author flpitu88
 */
public class LocalUsuarioTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @Before
    public void openDatabase() {
        emf = Persistence.createEntityManagerFactory("pUnitTest");
        em = emf.createEntityManager();
    }

    @After
    public void closeDatabase() {
        em.close();
        emf.close();
    }

    @Test
    public void probarMailInvalidoDeUsuarioTest() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
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

    @Test(expected = PersistenceException.class)
    public void probarUsuarioSinNombreTest() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        Usuario u = new Usuario(
                "33442887",
                null,
                "Pietrolati",
                "@mail",
                LocalDate.of(1988, Month.JANUARY, 1),
                Boolean.FALSE,
                "flavito");
        em.persist(u);
        em.getTransaction().commit();
    }
}
