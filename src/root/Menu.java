package root;
import interfaces.Input;
import utils.Utils;

public class Menu implements Input {
	
//Estrutura de menus (códigos)
	//0-Menu inicial
	//1-Acervo
		//1-1 Cadastro no acervo
		//1-2 Listar do acervo
		//1-3 Atualizar acervo
		//1-4 Deletar do acervo
	//2-Pessoas
		//2-1 Cadastro pessoas
		//2-2 Listar pessoas
		//2-3 Atualizar pessoas
		//2-4 Deletar pessoas
	
	
	//Render
	
	public static void renderizar(String menu, String opcaoAnterior) {
		
		switch(menu) {
		
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
	
	//Início
	
	public static void menuInicial(String opcaoAnterior) {
		
		String opcao;
		
		System.out.println("Sistema Biblioteca \n\n\n"+
						"\n 1 - Acervo"+
						"\n 2 - Pessoas"
				);
		
		opcao = s.next();
		
		renderizar(opcao, opcaoAnterior);
		
	}
	
	
	//Acervo
	
	public static void menuAcervo(String opcaoAnterior) {
				
		System.out.println("Menu Acervo \n\n\n"+
						"\n 1 - Cadastrar"+
						"\n 2 - Listar"+
						"\n 3 - Atualizar"+
						"\n 4 - Remover"+
						"\n\n [v] - Voltar"
				);
		
		String opcao = s.next();
		
		switch(opcao) {
		
		case "v":
				
				if(opcaoAnterior=="0") {
					opcao="0";
				}
			
				renderizar(opcao, opcaoAnterior);
				break;
					
		}
		
	}
	
	//Pessoas
	
	public static void menuPessoas(String opcaoAnterior) {
		
		System.out.println("Menu Pessoas \n\n\n"+
						"\n 1 - Cadastrar"+
						"\n 2 - Listar"+
						"\n 3 - Atualizar"+
						"\n 4 - Remover"+
						"\n\n [v] - Voltar"
				);
		
		String opcao = s.next();
		
		switch(opcao) {
		
		case "v":
				
				if(opcaoAnterior=="0") {
					opcao="0";
				}
			
				renderizar(opcao, opcaoAnterior);
				break;
					
		}
		
		
	}
	

}