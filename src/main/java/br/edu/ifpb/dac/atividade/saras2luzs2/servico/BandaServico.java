package br.edu.ifpb.dac.atividade.saras2luzs2.servico;

import java.util.List;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Banda;
import br.edu.ifpb.dac.atividade.saras2luzs2.repository.BandaPercistencia;

public class BandaServico {

	private BandaPercistencia bandas;
	
	public BandaServico() {
		bandas = new BandaPercistencia();
	}

	public void Add(Banda b) {
            if(b.getId()<1){
		bandas.addBanda(b);
            }
            else bandas.atualizar(b);
	}
	
	public List<Banda> lista(){
		return bandas.todas();
	}

    public void removeBanda(int id) {
        bandas.removeBanda(id);
	}
	
	public List<Banda> localizarLocalDeOrigem(String origem){
		return	bandas.localizarLocalDeOrigem(origem);
	}
}