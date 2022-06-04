package dao;

import config.DataBase;
import entities.Aluno;
import entities.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

	private Connection connection;

	public ProfessorDAO() {
		this.connection = new DataBase().conect();
	}

	public void adicionarBanco(Professor professor) {
		String sql = "INSERT INTO professor(id_professor, nome, formacao, id_turma) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, professor.getIdProfessor());
			stmt.setString(2, professor.getNomeProfessor());
			stmt.setString(3, professor.getFormacaoProfessor());
			stmt.setInt(4, professor.getIdTurma());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}