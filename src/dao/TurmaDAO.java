package dao;

import config.DataBase;
import entities.Aluno;
import entities.Professor;
import entities.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

	private Connection connection;

	public TurmaDAO() {
		this.connection = new DataBase().conect();
	}

	public void adicionarBanco(Turma turma) {
		String sql = "INSERT INTO turma(nome_turma) VALUES(?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, turma.getNomeTurma());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}