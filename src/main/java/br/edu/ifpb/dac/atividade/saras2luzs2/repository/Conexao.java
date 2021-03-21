package br.edu.ifpb.dac.atividade.saras2luzs2.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Conexao() {

	}

	public static Connection abrirConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://host-banco/docker",
                               "postgres",
                              "123456");
		//return DriverManager.getConnection("jdbc:postgresql://localhost:5432/docker","","");

		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public static void CloseConecxao(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.print(e);
			// TODO: handle exception
		}
	}
}
