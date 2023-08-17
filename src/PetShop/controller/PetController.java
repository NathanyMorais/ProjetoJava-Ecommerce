package PetShop.controller;

import java.util.ArrayList;
import PetShop.model.Produto;
import PetShop.model.ProdutoCarrinho;
import PetShop.repository.PetRepository;
import PetShop.util.Cores;
import java.util.Scanner;

public class PetController implements PetRepository {
	
	public ArrayList<Produto> produtos; 
	
	@Override
	public void inicializarEstoque(){
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		lista.add(new Produto(11,"Alimentação","Ração Premier Pet","Cães Filhotes Raças Pequenas - 5kg",130.00f)); 
		lista.add(new Produto(21,"Alimentação","Ração Special Dog Premium","Ração seca para cães adultos - 10kg",199.00f));
		lista.add(new Produto(31,"Alimentação","Whiskas Sachê","Sachê para Gatos Sabor Carne ao Molho 85g ",4.60f));
		lista.add(new Produto(41,"Alimentação","Biscoito PetDog","Petisco Natural Veggie para Cães - 150g",15.00f));
		lista.add(new Produto(51,"Higiene e Limpeza","Tapete Higiênico Meau","Tapete higienico para cães - 30 unidades",92.90f));
		lista.add(new Produto(61,"Higiene e Limpeza","Areia Higiênica Chalesco","Areia Higiênica Sílica Para Gatos - 1,8 Kg",59.90f));
		lista.add(new Produto(71,"Higiene e Limpeza","Shampoo Dug's","Shampoo Anti-pulgas para Cães - 500ml",37.50f));
		lista.add(new Produto(81,"Higiene e Limpeza","Condicionador Matacura","Condicionador Matacura Sarnicida - 200ml",23.99f));
		lista.add(new Produto(91,"Remédios","Antipulgas e Carrapatos MSD","Remédio para Cães e Gatos de 4,5 a 10Kg - 250 mg",224.90f));
		lista.add(new Produto(13,"Remédios","Vermífugo Biovet Vermivet","Composto 600 mg para Cães - 4 comprimidos",12.90f));
		lista.add(new Produto(23,"Casinhas e Caminhas","Caminha Pet","Cama M Para Cachorro Gato - Lavável com Zíper",110.90f));
		lista.add(new Produto(33,"Casinhas e Caminhas","Casinha Iglu Ecológica","Casinha Natural para Cães e Gatos - Tam 04",196.90f));
		lista.add(new Produto(43,"Moda e Acessórios","Caixa de Transporte Cat Love","Feito especialmente para gatos - Tam 01",58.70f));
		lista.add(new Produto(53,"Moda e Acessórios","Comedouro e Bebedouro Meau","Comedouro duplo para cães e gatos - 500ml",80.00f));
		lista.add(new Produto(63,"Moda e Acessórios","Coleira Future Pet Nasa","Coleira para cães e gatos - Regulável",43.80f));
		lista.add(new Produto(73,"Brinquedos","Brinquedo Chalesco Varinha","Brinquedo para gatos - Tam único",36.90f));
		lista.add(new Produto(83,"Brinquedos","Brinquedo Galinha","Brinquedo de látex para cães - Tam único",26.90f));
		lista.add(new Produto(93,"Brinquedos","Bola Macaquinho","Brinquedo para cães e gatos - Tam P",17.90f));
		
		produtos = lista;
	}
	
	@Override
	public void listarProdutos() { //método que imprime na tela todos os produtos que estao no estoque
		for(Produto produto:produtos) {
			produto.infoProduto();
		}
	}
	
	@Override
	public void procurarProduto(String busca) { //método que procura (por nome, descrição ou categoria) o produto que o usuário digitar 
		boolean res = false;  
		for(Produto produto : produtos) {     
			if(produto.getNome().toLowerCase().contains(busca.toLowerCase())) {  
				produto.infoProduto();   
				res = true;
			} else if (produto.getCategoria().toLowerCase().contains(busca.toLowerCase())) { 
				produto.infoProduto();
				res = true;
			} else if (	produto.getDescricao().toLowerCase().contains(busca.toLowerCase())) {
				produto.infoProduto();
				res = true;
			} 	
		}
		if(res == false) {   
			System.out.println(Cores.TEXT_RED+"Produto não encontrado!"+Cores.TEXT_RESET);
		}		
	}
	
	@Override
	public ProdutoCarrinho selecionarProduto(int id,int quantidade) { //método que seleciona o produto através da id para adicionar ao carrinho
		for(Produto produto:produtos) {
			if(produto.getId() == id) {
				ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(produto.getId(), produto.getCategoria(),produto.getNome(),
						produto.getDescricao(),produto.getPreco(),quantidade);
				return produtoCarrinho;
			}
		}
		System.out.println(Cores.TEXT_RED+"O código do produto está incorreto!"+Cores.TEXT_RESET);
		return null;	
	}
	
	//MÉTODO AUXILIAR
	public ProdutoCarrinho selecionarProdutoCarrinho(ArrayList<ProdutoCarrinho> carrinho, int id ) { //método que seleciona um produto especifico dentro do carrinho
		for(ProdutoCarrinho produtoCarrinho:carrinho) {
			if(produtoCarrinho.getId() == id) {
				return produtoCarrinho;
			}
		}
		return null;	
	}
	
	@Override
	public ArrayList<ProdutoCarrinho> adicionarProduto(ArrayList<ProdutoCarrinho> carrinho, int id,int quantidade){ //método para adicionar o produto no carrinho
		ProdutoCarrinho produtoCarrinho = selecionarProduto(id, quantidade);
		if(produtoCarrinho != null) {
			ProdutoCarrinho produtoExistenteCarrinho = selecionarProdutoCarrinho(carrinho, id);
			if(produtoExistenteCarrinho != null) { //verifica se o produto selecionado já existe dentro do carrinho e atualiza apenas a quantidade
				int indiceProdutoExistente = carrinho.indexOf(produtoExistenteCarrinho);
				int quantidadeAtual = produtoExistenteCarrinho.getQuantidade() + quantidade;
				produtoExistenteCarrinho.setQuantidade(quantidadeAtual);
				carrinho.set(indiceProdutoExistente, produtoExistenteCarrinho);
				System.out.println("Quantidade do produto atualizada com sucesso!");
			}else {
				carrinho.add(produtoCarrinho);
				System.out.println("Produto adicionado no carrinho com sucesso!");
			}
		}	
		return carrinho;
	}
	
	@Override 
	public void listarCarrinho(ArrayList<ProdutoCarrinho> carrinho) { //método que imprime na tela os produtos adicionados no carrinho e o valor total 
		if(carrinho.isEmpty() == true)
			System.out.println("Seu carrinho está vazio!");
		
		for(ProdutoCarrinho produtoCarrinho: carrinho) {
			
			System.out.println("---------------------------------------");
			System.out.println("Código: "+produtoCarrinho.getId());
			System.out.println("Produto: "+produtoCarrinho.getNome());
			System.out.printf("Valor unitário: R$ %.2f",produtoCarrinho.getPreco());
			System.out.println("\nQuantidade: "+produtoCarrinho.getQuantidade());
			System.out.printf("Total: R$ %.2f",produtoCarrinho.getTotal());
			System.out.println("\n---------------------------------------");
			System.out.println();
		}
		System.out.printf("Valor total: R$ %.2f", valorTotalCarrinho(carrinho));
		System.out.println("\n---------------------------------------");
		System.out.println();
	}
	
	@Override
	public float valorTotalCarrinho(ArrayList<ProdutoCarrinho> carrinho) { //método que calcula o valor total dos itens no carrinho
		float totalCarrinho = 0;
		for(ProdutoCarrinho produtoCarrinho: carrinho) {
			totalCarrinho += produtoCarrinho.getTotal();
		}    
		return totalCarrinho;
	}
	
	@Override
	public ArrayList<ProdutoCarrinho> excluirProduto(ArrayList<ProdutoCarrinho> carrinho, int id,int quantidade){ //método para excluir um produto do carrinho ou apenas diminuir a quantidade
		ProdutoCarrinho produtoCarrinho = selecionarProduto(id, quantidade);
		if(produtoCarrinho != null) {
			ProdutoCarrinho produtoExistenteCarrinho = selecionarProdutoCarrinho(carrinho, id);
			if(produtoExistenteCarrinho != null) { 
				int indiceProdutoExistente = carrinho.indexOf(produtoExistenteCarrinho);
				int quantidadeAtual = produtoExistenteCarrinho.getQuantidade() - quantidade;
				if(quantidadeAtual <= 0) {
					carrinho.remove(produtoExistenteCarrinho);
					System.out.println("Produto excluído com sucesso!");
				}else {
					produtoExistenteCarrinho.setQuantidade(quantidadeAtual);
					carrinho.set(indiceProdutoExistente, produtoExistenteCarrinho);
					System.out.println("Quantidade do produto atualizada com sucesso!");
				}
			}
		}
		return carrinho;
	}
	
	@Override
	public ArrayList<ProdutoCarrinho> limparCarrinho(ArrayList<ProdutoCarrinho> carrinho){ //método para limpar o carrinho e excluir todos os itens de uma vez
		carrinho.clear();
		System.out.println("Seu carrinho está vazio!");
		return carrinho;
	}
	
	//MÉTODO AUXILIAR
	public void emitirRecibo(ArrayList<ProdutoCarrinho> carrinho) {
		if(carrinho.isEmpty() == true)
			System.out.println("Seu carrinho está vazio!");
		
		System.out.println("---------------------------------------");
		for(ProdutoCarrinho produtoCarrinho: carrinho) {
			System.out.println("Produto: "+produtoCarrinho.getNome()+" -> "+produtoCarrinho.getQuantidade()+" unidade(s)");
			System.out.println();
		}
		System.out.printf("Valor total: R$ %.2f",valorTotalCarrinho(carrinho));
		System.out.println("\n---------------------------------------");
		System.out.println();
	}
	
	@Override
	public void concluirCompra(ArrayList<ProdutoCarrinho> carrinho) {
		System.out.println(Cores.TEXT_YELLOW+"\nCompra efetuada com sucesso! \n"+Cores.TEXT_RESET);
		emitirRecibo(carrinho);
		limparCarrinho(carrinho);
	}
	
	@Override
	public void continuarCompra() {
		Scanner leia = new Scanner(System.in);
		char resposta = 'S';
		System.out.println(Cores.ANSI_BLACK_BACKGROUND+Cores.TEXT_CYAN_BOLD+"\nDeseja continuar comprando? [S/N]:                 \n"+Cores.TEXT_RESET);
		resposta = leia.next().toUpperCase().charAt(0);
		if(resposta == 'N') {
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_BLACK_BOLD+"\n❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️");
			System.out.println("                                                  ");
			System.out.println("PetLovers agradece a preferência! Volte sempre!   ");
			System.out.println("                                                  ");
			System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️"+Cores.TEXT_RESET);
			leia.close();
			System.exit(0);
		}
	}
	
}
