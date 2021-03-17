package br.edu.ifpb.dac.atividade.saras2luzs2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Banda;


public class BandaPercistencia {

	private Connection con;
	
	public BandaPercistencia() {
		// TODO Auto-generated constructor stub
	}

	public void addBanda(Banda b) {
		String SQL = "INSERT INTO banda (localDeOrigem,nomeFantasia) VALUES (?,?)";
		con = Conexao.abrirConexao();
		try {
			PreparedStatement stm = con.prepareStatement(SQL);
			stm.setString(1, b.getLocalDeOrigem());
			stm.setString(2, b.getNomeFantasia());
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
