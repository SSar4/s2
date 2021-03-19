package br.edu.ifpb.dac.atividade.saras2luzs2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public List<Banda> todas() {
		// TODO Auto-generated method stub
		con = Conexao.abrirConexao();
		List<Banda> b = new ArrayList<>();
		try {
			String sql = "SELECT * FROM banda";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resut = statement.executeQuery();
			while (resut.next()) {
				b.add(criarBanda(resut));
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

	private Banda criarBanda(ResultSet result) {
		Banda b = new Banda();

		try {

			b.setId(result.getInt("id"));
			b.setNomeFantasia(result.getString("nomeFantasia"));
			b.setLocalDeOrigem(result.getString("localdeorigem"));

		} catch (SQLException ex) {
			System.out.print(ex);
		}

		return b;
	}
}
