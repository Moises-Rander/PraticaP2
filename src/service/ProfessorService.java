package service;

import dao.ProfessorDAO;
import entities.Professor;

public class ProfessorService {

	private ProfessorDAO professorDAO = new ProfessorDAO();

	public Professor validaProfessor(Professor professor) {
		if (
			professor.getIdProfessor() != null
			&& professor.getNomeProfessor() != null
			&& !professor.getNomeProfessor().isEmpty()
			&& professor.getFormacaoProfessor() != null
			&& !professor.getFormacaoProfessor().isEmpty()
		) {
			professorDAO.adicionarBanco(professor);
		} else {
			System.out.println("Verifique os dados cadastrados. O id e o nome do professor são obrigatórios!");
		}

		return null;
	}
}