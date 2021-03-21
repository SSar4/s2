package br.edu.ifpb.dac.atividade.saras2luzs2.servico;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;
import br.edu.ifpb.dac.atividade.saras2luzs2.repository.IntegrantePersistencia;
import java.util.List;

public class IntegranteServico {
 private IntegrantePersistencia integrantePersistencia;
    
    public IntegranteServico() {
        integrantePersistencia = new IntegrantePersistencia();
    }
    
    public void add(Integrante integrante) {
        if(integrante.getId()<1)
        integrantePersistencia.AddIntegrante(integrante);
        else integrantePersistencia.atualizar(integrante);
    }
    
    public Integrante buscarPorId(int id) {
        return integrantePersistencia.buscarPorId(id);
    }

    public List<Integrante> todas() {
        return integrantePersistencia.todas();
    }

    public void removeIntegrante(int id) {
        integrantePersistencia.removeIntegrante(id);
    }

    public List<Integrante> localizarintegranteCPF(String cpf) {
        return integrantePersistencia.localizarintegranteCPF(cpf);
    }

   
	

}
