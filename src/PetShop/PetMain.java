package PetShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import PetShop.model.Produto;
import PetShop.controller.PetController;
import PetShop.util.Cores;
import PetShop.model.ProdutoCarrinho;

public class PetMain {
	
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {      
				
		PetController petshop = new PetController();
		ArrayList<ProdutoCarrinho> carrinho = new ArrayList<ProdutoCarrinho>();
		ArrayList<ProdutoCarrinho> historico = new ArrayList<ProdutoCarrinho>();
		int opcao, id, quantidade, formaPagamento;
		String busca;
		
		petshop.inicializarEstoque();
		
		while (true) {
			
			System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD);
			System.out.println("\r"
					+ "     ___  ____________   ____ _   _________  ____  \r\n"
					+ "    / _ \\/ __/_  __/ /  / __ \\ | / / __/ _ \\/ __/  \r\n"
					+ "   / ___/ _/  / / / /__/ /_/ / |/ / _// , _/\\ \\    \r\n"
					+ "  /_/  /___/ /_/ /____/\\____/|___/___/_/|_/___/    \r\n"
					+ "                                                   ");
			System.out.println(" ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ ");
			System.out.println("                                                   ");
			System.out.println("           1 - Listar produtos                     ");
			System.out.println("           2 - Procurar produto                    ");
			System.out.println("           3 - Adicionar produto no carrinho       ");
			System.out.println("           4 - Excluir produto do carrinho         ");
			System.out.println("           5 - Visualizar carrinho de compras      ");
			System.out.println("           6 - Limpar carrinho                     ");
			System.out.println("           7 - Finalizar compra                    ");
			System.out.println("           8 - Sair do programa                    ");
			System.out.println("                                                   ");
			System.out.println(" ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ ");
			System.out.println("                                                   ");
			System.out.println("  Digite a opção desejada:                         ");
			System.out.println("                                                   "+Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nVocê deve escolher uma opção do Menu.");
				leia.nextLine();
				opcao = 0;
			}

			if(opcao == 8) {
				System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"\n❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️");
				System.out.println("                                                  ");
				System.out.println("PetLovers agradece a preferência! Volte sempre!   ");
				System.out.println("                                                  ");
				System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️"+Cores.TEXT_RESET);
				leia.close();
				System.exit(0);
			}

		switch(opcao) {
		case 1:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Produtos disponíveis no estoque:                   \n"+Cores.TEXT_RESET);
			petshop.listarProdutos();
			keyPress();
			break;
		case 2:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Procurar Produto:                                  \n"+Cores.TEXT_RESET);
			System.out.println("Qual produto está procurando? ");
			leia.nextLine();
			busca = leia.nextLine();
			petshop.procurarProduto(busca);
			keyPress();
			break;
		case 3:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Adicionar Produto no Carrinho:                     \n"+Cores.TEXT_RESET);
			System.out.println("Informe o código do produto: ");
			id = leia.nextInt();
			System.out.println("Informe a quantidade desejada: ");
			quantidade = leia.nextInt();
			carrinho = petshop.adicionarProduto(carrinho,id, quantidade);
			keyPress();
			break;
		case 4:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Excluir Produto do Carrinho:                       \n"+Cores.TEXT_RESET);
			System.out.println("Informe o código do produto que quer excluir: ");
			id = leia.nextInt();
			System.out.println("Informe a quantidade do produto que quer excluir: ");
			quantidade = leia.nextInt();
			carrinho = petshop.excluirProduto(carrinho,id, quantidade);
			keyPress();
			break;
		case 5:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Meu Carrinho de Compras:                           \n"+Cores.TEXT_RESET);
			petshop.listarCarrinho(carrinho);
			keyPress();
			break;
		case 6:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Limpar meu Carrinho de Compras:                    \n"+Cores.TEXT_RESET);
			petshop.limparCarrinho(carrinho);
			keyPress();
			break;
		case 7:
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"Finalizar a Compra:                                \n"+Cores.TEXT_RESET);
			System.out.println("Escolha o método de pagamento: ");
			System.out.println("[1] - Cartão de Crédito");
			System.out.println("[2] - Cartão de Débito");
			System.out.println("[3] - Pix");
			System.out.println("[4] - Boleto");
			System.out.println("[0] - Sair");
			System.out.println();
			formaPagamento = leia.nextInt();
			
			switch(formaPagamento) {
			case 0: {
				break;
			}
			case 1: {
				System.out.println("\nEscolha a quantidade de parcelas:"
						+ "\n[1] - 1x sem juros"
						+ "\n[2] - 2x sem juros");
				System.out.println();
			int parcelas = leia.nextInt();
				switch(parcelas) {
					case 1: {
						System.out.printf(Cores.TEXT_YELLOW+"\nValor Total: R$ %.2f - pago em 1x no Cartão de Crédito\n"+Cores.TEXT_RESET,petshop.valorTotalCarrinho(carrinho));
						petshop.concluirCompra(carrinho);
						petshop.continuarCompra();
						break;
					}
					case 2: {
						System.out.printf(Cores.TEXT_YELLOW+"\nValor Total: R$ %.2f - pago em 2x de R$ %.2f no Cartão de crédito\n"+Cores.TEXT_RESET,petshop.valorTotalCarrinho(carrinho), (petshop.valorTotalCarrinho(carrinho) / 2));
						petshop.concluirCompra(carrinho);
						petshop.continuarCompra();
						break;
					}
				}
			break;
			}
			case 2: {
				System.out.printf(Cores.TEXT_YELLOW+"\nValor Total: R$ %.2f - pago no Cartão de Débito\n"+Cores.TEXT_RESET,petshop.valorTotalCarrinho(carrinho));
				petshop.concluirCompra(carrinho);
				petshop.continuarCompra();
				break;
			}
			case 3: {
				System.out.printf(Cores.TEXT_YELLOW+"\nValor Total: R$ %.2f - pago no PIX\n"+Cores.TEXT_RESET,petshop.valorTotalCarrinho(carrinho));
				petshop.concluirCompra(carrinho);
				petshop.continuarCompra();
				break;
			}
			case 4: {
				System.out.printf(Cores.TEXT_YELLOW+"\nValor Total: R$ %.2f - pago no Boleto"+Cores.TEXT_RESET,petshop.valorTotalCarrinho(carrinho));
				petshop.concluirCompra(carrinho);
				petshop.continuarCompra();
				break;
			}
			default: System.out.println(Cores.TEXT_RED+"Opção inválida!"+Cores.TEXT_RESET);
			}
			keyPress();
			break;
		default:
			System.out.println(Cores.TEXT_WHITE_BRIGHT+"Digite uma opção válida!"+Cores.TEXT_RESET);
			keyPress();
			break;
		}
	  }	
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_CYAN_BOLD+"\nPressione Enter para continuar..."+Cores.TEXT_RESET);
			System.in.read();	
		} catch (IOException e) {
			System.out.println(Cores.TEXT_RED+"Você pressionou uma tecla diferente de enter!"+Cores.TEXT_RESET);
		}
	}
}
