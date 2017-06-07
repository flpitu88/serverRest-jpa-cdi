/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author flpitu88
 */
public class LocalPersonaTest {

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
    public void crudTest() {
        em.getTransaction().begin();
        Persona p = new Persona("Flavio", "Pietrolati", Date.valueOf(LocalDate.of(1988, Month.JANUARY, 1)));
        em.persist(p);
        em.getTransaction().commit();
        System.out.println("Se guardó el objeto");
        Persona _p = em.find(Persona.class, 1);
        Assert.assertNotNull(p.getId());
        System.out.println("Encontrada persona #1:  " + _p.getNombre() + " " + _p.getApellido());        
    }

}
