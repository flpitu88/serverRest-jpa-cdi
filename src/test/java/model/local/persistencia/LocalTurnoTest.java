/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.local.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author flpitu88
 */
public class LocalTurnoTest {
    
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

    
}
