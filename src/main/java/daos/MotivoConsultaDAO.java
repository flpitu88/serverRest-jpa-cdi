/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import modelo.MotivoConsulta;

/**
 *
 * @author flavio
 */
public interface MotivoConsultaDAO {

    public List<MotivoConsulta> getMotivosDeConsulta();

    public Integer guardarMotivo(MotivoConsulta motivo);
}
