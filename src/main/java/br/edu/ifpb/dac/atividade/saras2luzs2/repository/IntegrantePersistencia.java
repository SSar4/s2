package br.edu.ifpb.dac.atividade.saras2luzs2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.Banda;
import br.edu.ifpb.dac.atividade.saras2luzs2.entidades.CPF;
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
	public void removeIntegrante(int id) {
		String SQL = "DELETE FROM integrante id where id=?";
		con = Conexao.abrirConexao();
		try {
			PreparedStatement stm = con.prepareStatement(SQL);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		Conexao.CloseConecxao(con);
	}

	public List<Integrante> localizarIntegranteComCPF(String cpf) {
		List<Integrante> integrante = new ArrayList<>();
		try {
			this.con = Conexao.abrirConexao();
			String consulta = "SELECT * FROM integrante WHERE cpf ilike '" + cpf + "%' ";
			PreparedStatement statement = con.prepareStatement(consulta);
			//  statement.setString(1, cpf);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				integrante.add(criarIntegrante(result));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		} finally {
			Conexao.CloseConecxao(con);
		}
		if (integrante.size() > 0) {
			return Collections.unmodifiableList(integrante);
		} else {
			return Collections.EMPTY_LIST;
		}
	}

	public Integrante buscarPorId(int id){
		StringBuffer sql = new StringBuffer("SELECT FROM integrante");
		sql.append("WHERE  id =");
		sql.append(id);
		return todas(sql.toString()).get(0);
	}

	public List<Integrante> todas(){
		StringBuffer sql = new StringBuffer("SELECT FROM integrante");
		return todas(sql.toString());
	}
	public List<Integrante> todas(String sql) {
		// TODO Auto-generated method stub
		con = Conexao.abrirConexao();
		List<Integrante> b = new ArrayList<>();
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resut = statement.executeQuery();
			while (resut.next()) {
				b.add(criarIntegrante(resut));
			}
		} catch (SQLException ex) {
			System.out.print(ex);
		} finally {
			Conexao.CloseConecxao(con);
		}
		if (b.size() > 0) {
			return Collections.unmodifiableList(b);
		} else {
			return Collections.EMPTY_LIST;
		}

	}



	private Integrante criarIntegrante(ResultSet result) {
		Integrante integrante = new Integrante();

		try {

			integrante.setId(result.getInt("id"));
			integrante.setNome(result.getString("nome"));
			integrante.setDataDeNascimento(result.getDate("dataDeNascimento").toLocalDate());
			CPF cpf = new CPF(result.getString("CPF"));
			integrante.setCpf(cpf);

		} catch (SQLException ex) {
			System.out.print(ex);

		}

		return integrante;
	}

}
