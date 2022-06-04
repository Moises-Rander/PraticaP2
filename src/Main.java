
import service.AlunoService;
import service.ProfessorService;
import service.TurmaService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Professor;
import entities.Turma;

public class Main {

	// scanner para entrada de dados
	private static Scanner entrada = new Scanner(System.in);

	// classe responsavel por manipular alunos
	private static AlunoService alunoService = new AlunoService();
	
	// classe responsavel por manipular professores
	private static ProfessorService professorService = new ProfessorService();
		
	// classe responsavel por manipular professores
	private static TurmaService turmaService = new TurmaService();

	public static void main(String[] args) throws SQLException {

		// flag que controla execucao do programa
		boolean continuar = true;

		while (continuar) {
			exibeMenu();

			switch (entrada.nextLine()) {
			case "1":
				limpaTela();
				adicionarTurma();
				pressioneQualquerTecla();
				break;
			case "2":
				limpaTela();
				adicionarProfessor();
				pressioneQualquerTecla();
				break;
			case "3":
				limpaTela();
				adicionarAluno();
				pressioneQualquerTecla();
				break;
			case "4":
				limpaTela();
				listarAlunos();
				pressioneQualquerTecla();
				break;
			case "5":
				limpaTela();
				buscarPorId();
				pressioneQualquerTecla();
				break;
			case "6":
				limpaTela();
				atualizarAluno();
				pressioneQualquerTecla();
				break;
			case "7":
				limpaTela();
				deletarAluno();
				entrada.nextLine();
				pressioneQualquerTecla();
				break;
			case "8":
				limpaTela();
				System.out.println("Tchau... :)");
				pressioneQualquerTecla();
				continuar = false;
				break;
			default:
				limpaTela();
				System.out.println("Por favor, selecione uma opção válida.");
				pressioneQualquerTecla();
				break;
			}
			
			limpaTela();
		}

		entrada.close();
	}

	private static void exibeMenu() {
		System.out.println("Bem vindo, por favor digite uma opção válida: ");
		System.out.println("1 - Cadastrar turma");
		System.out.println("2 - Cadastrar professor");
		System.out.println("3 - Cadastrar aluno");
		System.out.println("4 - Listar alunos");
		System.out.println("5 - Buscar aluno por id");
		System.out.println("6 - Atualizar aluno");
		System.out.println("7 - Deletar aluno");
		System.out.println("8 - Sair");
	}

	private static void adicionarAluno() {
		Aluno aluno = new Aluno();

		String resposta = entradaNome();
		aluno.setNome(resposta);

		resposta = entradaNomeMae();
		aluno.setNomeMae(resposta);
		
		resposta = entradaNomePai();
		aluno.setNomePai(resposta);

		resposta = entradaDataNascimento();
		aluno.setDataNascimento(resposta);
		
		int respostaIdProfessor = entradaIdProfessor();
		aluno.setIdProfessor(respostaIdProfessor);
		
		alunoService.validaAluno(aluno);
	}
	
	private static void adicionarProfessor() {
		Professor professor = new Professor();

		String resposta = entradaNomeProfessor();
		professor.setNomeProfessor(resposta);

		resposta = entradaFormacaoProfessor();
		professor.setFormacaoProfessor(resposta);
		
		int respostaIdTurma = entradaIdTurma();
		professor.setIdTurma(respostaIdTurma);
		
		professorService.validaProfessor(professor);
	}
	
	private static void adicionarTurma() {
		Turma turma = new Turma();
		
		String resposta = entradaNomeTurma();
		turma.setNomeTurma(resposta);
		
		turmaService.validaTurma(turma);
	}
	
	private static void atualizarAluno() {
		Aluno aluno = new Aluno();
		
		int resposta_id = entradaId();
		aluno.setId(resposta_id);
		
		entrada.nextLine();

		String resposta = entradaNome();
		aluno.setNome(resposta);

		resposta = entradaNomeMae();
		aluno.setNomeMae(resposta);
		
		resposta = entradaNomePai();
		aluno.setNomePai(resposta);

		resposta = entradaDataNascimento();
		aluno.setDataNascimento(resposta);

		alunoService.atualizarAluno(aluno);
	}
		
	private static void deletarAluno() {
		System.out.print("Informe o id do aluno: ");
		int idBusca_del = entrada.nextInt();
		
		alunoService.deletarAluno(idBusca_del);
	}

	private static void listarAlunos() {
		List<Aluno> listaAlunos = alunoService.listaAlunos();
		printaAlunos(listaAlunos);
	}

	private static void buscarPorId() {
		System.out.print("Informe o id do aluno: ");
		String idBusca = entrada.nextLine();
		List<Aluno> listaAlunos = alunoService.listaAlunoPorId(idBusca);
		printaAlunos(listaAlunos);
	}
	
	private static void printaAlunos(List<Aluno> listaAlunos) {
		Iterator<Aluno> it = listaAlunos.iterator();

		while(it.hasNext()) {
			Aluno aluno = it.next();

			System.out.printf("%-4s\t", aluno.getId());
			System.out.printf("%-20s\t", aluno.getNome());
			System.out.printf("%-10s\t", aluno.getDataNascimento());
			System.out.println();
		}
	}
	
	private static void limpaTela() {
		for (int i = 0; i < 100; i++) {
			System.out.println("\r\n");
		}
	}
	
	private static void pressioneQualquerTecla() {
		System.out.println("\n\nPressione qualquer tecla para continuar...");
		entrada.nextLine();
	}
	
	private static String entradaNome() {
		System.out.println("Informe o nome do aluno: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String entradaNomeProfessor() {
		System.out.println("Informe o nome do professor: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String entradaNomeTurma() {
		System.out.println("Informe o nome da turma: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String entradaFormacaoProfessor() {
		System.out.println("Informe a formação do professor: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String entradaNomeMae() {
		System.out.println("Informe o nome da Mae do Aluno: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String entradaNomePai() {
		System.out.println("Informe o nome do Pai do Aluno: ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static String entradaDataNascimento() {
		System.out.println("Informe a data de nascimento do aluno (Ex.: 22/02/2000): ");
		String resposta = entrada.nextLine();
		return resposta;
	}
	
	private static int entradaId() {
		System.out.println("Informe o id do aluno: ");
		int resposta = entrada.nextInt();
		return resposta;
	}
	
	private static int entradaIdProfessor() {
		System.out.println("Informe o id do professor deste aluno: ");
		int resposta = entrada.nextInt();
		return resposta;
	}
	
	private static int entradaIdTurma() {
		System.out.println("Informe o id da turma deste professor: ");
		int resposta = entrada.nextInt();
		return resposta;
	}
}