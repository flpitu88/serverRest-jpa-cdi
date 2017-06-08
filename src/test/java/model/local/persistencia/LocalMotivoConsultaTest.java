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
import modelo.MotivoConsulta;
import modelo.Usuario;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author flpitu88
 */
public class LocalMotivoConsultaTest {

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
        MotivoConsulta mc = new MotivoConsulta("este es un motivo");
        em.persist(mc);
        em.getTransaction().commit();
        System.out.println("Se guardó el objeto");
        MotivoConsulta _mc = em.find(MotivoConsulta.class, 1);
        Assert.assertNotNull(_mc.getId());
        System.out.println("Encontrado motivo consulta #1:  " + _mc.getMotivo());
    }

    @Test(expected = PersistenceException.class)
    public void probarNoNuloExceptionTest() {
        em.getTransaction().begin();
        MotivoConsulta mc = new MotivoConsulta();
        em.persist(mc);
        em.getTransaction().commit();
    }

}
