package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.TurmaDAO;
import entities.Turma;

public class TurmaService {

	private TurmaDAO turmaDAO = new TurmaDAO();

	public Turma validaTurma(Turma turma) {
		if (
				turma.getNomeTurma() != null
				&& !turma.getNomeTurma().isEmpty()
			) {
				turmaDAO.adicionarBanco(turma);
			} else {
				System.out.println("Verifique os dados cadastrados. O nome do aluno, nome da mãe e data de nascimento são obrigatórios!");
			}

			return null;
	}
}