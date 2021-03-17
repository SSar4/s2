package br.edu.ifpb.dac.atividade.saras2luzs2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Integrante;

public class IntegrantePersistencia {

	private Connection con;
	
	public IntegrantePersistencia() {
		// TODO Auto-generated constructor stub
	}
	
	public void AddIntegrante(Integrante i) {
		String SQL = "INSERT INTO banda (localDeOrigem,nomeFantasia) VALUES (?,?)";
		con = Conexao.abrirConexao();
		try {
			PreparedStatement stm = con.prepareStatement(SQL);
			stm.setString(1, i.getNome());
			
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
