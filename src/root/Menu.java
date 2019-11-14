package root;

import collections.*;
import gestaoDeAcervo.*;
import gestaoDePessoa.*;
import interfaces.Input;
import utils.Utils;

public class Menu implements Input {

//Estrutura de menus (códigos)
	// 0-Menu inicial
	// 1-Acervo
	// 1-1 Cadastro no acervo
	// 1-2 Listar do acervo
	// 1-3 Atualizar acervo
	// 1-4 Deletar do acervo
	// 2-Pessoas
	// 2-1 Cadastro pessoas
	// 2-2 Listar pessoas
	// 2-3 Atualizar pessoas
	// 2-4 Deletar pessoas

	// Render -> Método público responsável por renderizar os menus

	public static void voltar(String opcaoAnterior) {

		System.out.println("\n Pressione [v] para voltar ao menu anterior");

		String voltar = s.next();
		if (voltar.equals("v")) {
			renderizar(opcaoAnterior, opcaoAnterior);
		}
		;
	}

	public static void renderizar(String menu, String opcaoAnterior) {

		switch (menu) {

		case "0":
			Utils.limparTela();
			menuInicial(opcaoAnterior);
			break;

		case "1":
			Utils.limparTela();
			menuAcervo(opcaoAnterior);
			break;

		case "2":
			Utils.limparTela();
			menuPessoas(opcaoAnterior);
			break;

		}

	}

// Início

	private static void menuInicial(String opcaoAnterior) {

		String opcao;

		System.out.println("Sistema Biblioteca \n\n\n" + "\n 1 - Acervo" + "\n 2 - Pessoas");

		opcao = s.next();

		renderizar(opcao, opcaoAnterior);

	}

// Acervo

	private static void menuAcervo(String opcaoAnterior) {

		System.out.println("Menu Acervo \n\n\n" + "\n 1 - Cadastrar" + "\n 2 - Listar" + "\n 3 - Atualizar"
				+ "\n 4 - Remover" + "\n\n [v] - Voltar");

		String opcao = s.next();

		switch (opcao) {

		// Cadastro de itens no acervo

		case "1": {

			System.out.println("Escolha o que cadastrar:" + "\n 1 - Jornal" + "\n 2 - Livro" + "\n 3 - Revista");

			String opcaoCadastro = s.next();

			switch (opcaoCadastro) {

			case "1": {

				System.out.println("Ano de publicação: ");
				int anoPublicacao = s.nextInt();

				System.out.println("Número de páginas: ");
				int numeroPaginas = s.nextInt();

				System.out.println("Volume: ");
				String volume = s.next();

				System.out.println("Nome do jornal: ");
				String nomeJornal = s.next();

				Jornal j = new Jornal(anoPublicacao, numeroPaginas, volume, nomeJornal);

				AcervoCollection.adicionarAcervo(j);

				Menu.renderizar("1", opcaoAnterior);

				break;
			}

			case "2": {

				System.out.println("Ano de publicação do livro: ");
				int anoPublicacao = s.nextInt();

				System.out.println("Número de páginas: ");
				int numeroPaginas = s.nextInt();

				System.out.println("Volume: ");
				String volume = s.next();

				System.out.println("Código do autor: ");
				int codigoAutor = s.nextInt();

				System.out.println("Nome do autor: ");
				String nomeAutor = s.next();

				System.out.println("Edição: ");
				int edicao = s.nextInt();

				System.out.println("Titulo do livro: ");
				String titulo = s.next();

				System.out.println("Editora: ");
				String editora = s.next();

				System.out.println("ISBN: ");
				String isbn = s.next();

				Livro l = new Livro(anoPublicacao, numeroPaginas, volume, codigoAutor, edicao, nomeAutor, titulo,
						editora, isbn);

				AcervoCollection.adicionarAcervo(l);

				Menu.renderizar("1", opcaoAnterior);

				break;

			}

			case "3": {

				System.out.println("Ano de publicação: ");
				int anoPublicacao = s.nextInt();
				System.out.println("Número de páginas: ");
				int numeroPaginas = s.nextInt();
				System.out.println("Volume: ");
				String volume = s.next();
				System.out.println("Número da edição: ");
				int edicao = s.nextInt();
				System.out.println("Nome da revista: ");
				String nomeRevista = s.next();

				Revista r = new Revista(anoPublicacao, numeroPaginas, volume, edicao, nomeRevista);

				AcervoCollection.adicionarAcervo(r);

				Menu.renderizar("1", opcaoAnterior);

				break;

			}

			}
		}

		// Listar itens do acervo

		case "2": {

			System.out.println(
					"\n 0 - Listar todos os itens \n 1 - Listar jornais \n 2 - Listar livros \n 3 - Listar revistas");

			int tipo = s.nextInt();
			AcervoCollection.listarAcervo(tipo);
			voltar(opcaoAnterior);
			break;

		}

		// Atualizar acervo

		case "3": {

			System.out.println("Selecione o item que quer atualizar: \n");

			AcervoCollection.listarAcervo(1);
			AcervoCollection.listarAcervo(2);
			AcervoCollection.listarAcervo(3);

			int codigo = s.nextInt();

			System.out.println("Alterando o seguinte registro: ");
			AcervoCollection.procurarAcervo(codigo);
			AcervoCollection.atualizar(AcervoCollection.retornoIndividual(codigo));

		}

		case "4": {

			System.out.println("Selecione o registro que deseja remover: ");

			AcervoCollection.listarAcervo(1);
			AcervoCollection.listarAcervo(2);
			AcervoCollection.listarAcervo(3);

			int codigo = s.nextInt();

			System.out.println("Removendo o seguinte registro: ");
			AcervoCollection.procurarAcervo(codigo);
			AcervoCollection.removerAcervo(AcervoCollection.retornoIndividual(codigo));

		}

		case "v": {

			if (opcaoAnterior == "0") {
				opcao = "0";
			}

			renderizar(opcao, opcaoAnterior);
			break;
		}

		}

	}

// Pessoas

	private static void menuPessoas(String opcaoAnterior) {

		System.out.println("Menu Pessoas \n\n\n" + "\n 1 - Cadastrar" + "\n 2 - Listar" + "\n 3 - Atualizar"
				+ "\n 4 - Remover" + "\n\n [v] - Voltar");

		String opcao = s.next();

		switch (opcao) {

		case "1": {

			// Cadastro de pessoas
			menuCadastroPessoas(opcaoAnterior);
			break;

		}

		case "2": {

			PessoaCollection.listarNomeId();
			break;

		}

		case "3": {

			// Atualizar pessoas

			System.out.println("Digite o ID da pessoa que deseja alterar:");
			PessoaCollection.listarNomeId();

			int id = s.nextInt();

			Pessoa p = PessoaCollection.buscaIndividual(id);

			switch (p.getTipo()) {

			case 1: {

				System.out.println("Digite o nome da pessoa:");
				String nome = s.next();
				p.setNome(nome);

				System.out.println("Digite o CPF:");
				String cpf = s.next();
				p.setCpf(cpf);

				System.out.println("Digite o telefone:");
				String fone = s.next();
				p.setFone(fone);

				System.out.println("Digite o endereço:");
				String endereco = s.next();
				p.setEndereco(endereco);

				System.out.println("Digite o CEP:");
				String cep = s.next();
				p.setCep(cep);

				System.out.println("Digite o e-mail:");
				String email = s.next();
				p.setEmail(email);

				System.out.println("Digite o identificador:");
				int identificador = s.nextInt();
				((Atendente) p).setIdentificador(identificador);

				break;
			}

			case 2: {

				System.out.println("Digite o nome do usuário:");
				String nome = s.next();
				p.setNome(nome);
				
				System.out.println("Digite o CPF do usuário:");
				String cpf = s.next();
				p.setCpf(cpf);

				System.out.println("Digite o telefone do usuário:");
				String fone = s.next();
				p.setFone(fone);

				System.out.println("Digite o endereço do usuário:");
				String endereco = s.next();
				p.setEndereco(endereco);

				System.out.println("Qual o CEP?");
				String cep = s.next();
				p.setCep(cep);

				System.out.println("E-mail:");
				String email = s.next();
				p.setEmail(email);

				System.out.println("Matricula:");
				String matricula = s.next();
				((Usuario) p).setMatricula(matricula);
				
				System.out.println("Qual o curso?");
				String curso = s.next();
				((Usuario) p).setCurso(curso);

				break;
			}

			}

		}

		case "4": {

			// Remover
			
			System.out.println("Digite o ID da pessoa que deseja remover:");
			
			PessoaCollection.listarNomeId();

			int id = s.nextInt();

			PessoaCollection.remover(id);

		}

		case "v":

			if (opcaoAnterior == "0") {
				opcao = "0";
			}

			renderizar(opcao, opcaoAnterior);
			break;

		}

	}

	// Cadastro de pessoas
	private static void menuCadastroPessoas(String opcaoAnterior) {

		System.out.println("Cadastro de pessoas \n\n\n" + "Escolha o tipo de pessoa: " + "\n 1 - Antendente"
				+ "\n 2 - Usuário" + "\n\n [v] - Voltar");

		String opcao = s.next();

		switch (opcao) {

		// Atendente
		case "1": {

			System.out.println("Digite o nome da pessoa:");
			String nome = s.next();

			System.out.println("Digite o CPF:");
			String cpf = s.next();

			System.out.println("Digite o telefone:");
			String fone = s.next();

			System.out.println("Digite o endereço:");
			String endereco = s.next();

			System.out.println("Digite o CEP:");
			String cep = s.next();

			System.out.println("Digite o e-mail:");
			String email = s.next();

			System.out.println("Digite o identificador:");
			int identificador = s.nextInt();

			Atendente a = new Atendente(nome, cpf, fone, endereco, cep, email, identificador);

			PessoaCollection.inserir(a);

			System.out.println("Cadastrado com sucesso!");

		}

		case "2": {

			System.out.println("Digite o nome do usuário:");
			String nome = s.next();

			System.out.println("Digite o CPF do usuário:");
			String cpf = s.next();

			System.out.println("Digite o telefone do usuário:");
			String fone = s.next();

			System.out.println("Digite o endereço do usuário:");
			String endereco = s.next();

			System.out.println("Qual o CEP?");
			String cep = s.next();

			System.out.println("E-mail:");
			String email = s.next();

			System.out.println("Matricula:");
			String matricula = s.next();

			System.out.println("Qual o curso?");
			String curso = s.next();

			Usuario u = new Usuario(nome, cpf, fone, endereco, cep, email, matricula, curso);

			PessoaCollection.inserir(u);

			System.out.println("Cadastrado com sucesso!");

		}

		case "v":

			if (opcaoAnterior == "0") {
				opcao = "0";
			}
			renderizar(opcao, opcaoAnterior);
			break;

		}

	}

	// Listar pessoas

}
