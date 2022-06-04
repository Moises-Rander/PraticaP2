package dao;

import config.DataBase;
import entities.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

	private Connection connection;

	public AlunoDAO() {
		this.connection = new DataBase().conect();
	}

	public void adicionarBanco(Aluno aluno) {
		String sql = "INSERT INTO aluno(nome, nome_mae, nome_pai, dt_nasc, dt_cadastro) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getNomeMae());
			stmt.setString(3, aluno.getNomePai());
			stmt.setString(4, aluno.getDataNascimento());
			stmt.setString(5, aluno.getDataCadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Aluno atualizarBanco(Aluno aluno) {
		String sql = "UPDATE aluno SET nome=?, nome_mae=?, nome_pai=?, dt_nasc=?, fk_id_professor=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getNomeMae());
			stmt.setString(3, aluno.getNomePai());
			stmt.setString(4, aluno.getDataNascimento());
			stmt.setInt(5, aluno.getIdProfessor());
			stmt.setInt(6, aluno.getId());
			stmt.execute();
			stmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletarBanco(int idAluno) {
		String sql = "DELETE FROM aluno WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idAluno);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Aluno> selectListaAlunos() {
		String sql = "SELECT * FROM aluno";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaAlunos(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Aluno> selectAlunoPorId(String idAluno) {
		String sql = "SELECT * FROM aluno WHERE id = " + idAluno;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return recuperaAlunos(stmt, rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Aluno> recuperaAlunos(Statement stmt, ResultSet rs) throws SQLException {
		List<Aluno> lista = new ArrayList<Aluno>();

		while (rs.next()) {
			Aluno aluno = new Aluno();

			aluno.setId(rs.getInt("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setNomeMae(rs.getString("nome_mae"));
			aluno.setNomePai(rs.getString("nome_pai"));
			aluno.setDataNascimento(rs.getString("dt_nasc"));
			aluno.setDataCadastro(rs.getString("dt_cadastro"));

			lista.add(aluno);
		}

		stmt.close();

		return lista;
	}
}