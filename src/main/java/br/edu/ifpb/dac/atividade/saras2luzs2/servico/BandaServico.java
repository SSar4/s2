package br.edu.ifpb.dac.atividade.saras2luzs2.servico;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Banda;
import br.edu.ifpb.dac.atividade.saras2luzs2.repository.BandaPercistencia;

public class BandaServico {

	private BandaPercistencia bandas;
	
	public BandaServico() {
		bandas = new BandaPercistencia();
	}

	public void Add(Banda b) {
		bandas.addBanda(b);
	}
}
