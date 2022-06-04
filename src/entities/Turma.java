package entities;

import java.util.ArrayList;

public class Turma {
	
	private Integer idTurma;
	private ArrayList<Professor> professores;
	private String nomeTurma;
	
	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	
	public void adicionarProfessor(Professor professor){
        this.professores.add(professor);
    }
	
	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}
	
	public Integer getIdTurma() {
		return idTurma;
	}
	
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
}