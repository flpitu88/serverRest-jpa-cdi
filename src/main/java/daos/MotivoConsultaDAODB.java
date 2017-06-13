/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.MotivoConsulta;

/**
 *
 * @author flavio
 */
@Stateless
public class MotivoConsultaDAODB implements MotivoConsultaDAO {

    @PersistenceContext(unitName = "h2-pu")
    EntityManager entityMgr;

    @Override
    public List<MotivoConsulta> getMotivosDeConsulta() {
        return entityMgr.createQuery("from " + MotivoConsulta.class.getSimpleName())
                .getResultList();
    }

    @Override
    public Integer guardarMotivo(MotivoConsulta motivo) {
        entityMgr.persist(motivo);
        return motivo.getId();
    }

}
