package entities;

import java.util.ArrayList;

public class Professor {
	
	private int idProfessor;
	private String nomeProfessor;
	private String formacaoProfessor;
	private ArrayList<Aluno> alunos;
	private int idTurma;
	
	public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }
	
	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setId(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	public String getFormacaoProfessor() {
			return formacaoProfessor;
	}
	
	public void setFormacaoProfessor(String formacaoProfessor) {
		this.formacaoProfessor = formacaoProfessor;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
}