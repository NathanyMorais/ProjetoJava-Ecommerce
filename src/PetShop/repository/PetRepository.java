package PetShop.repository;

import java.util.ArrayList;
import PetShop.model.Produto;
import PetShop.model.ProdutoCarrinho;

public interface PetRepository {
	
	public void inicializarEstoque();
	public void listarProdutos();
	public void procurarProduto(String busca);
	public ProdutoCarrinho selecionarProduto(int id,int quantidade);
	public ArrayList<ProdutoCarrinho> adicionarProduto(ArrayList<ProdutoCarrinho> carrinho, int id,int quantidade);
	public void listarCarrinho(ArrayList<ProdutoCarrinho> carrinho);
	public ArrayList<ProdutoCarrinho> excluirProduto(ArrayList<ProdutoCarrinho> carrinho, int id,int quantidade);
	public ArrayList<ProdutoCarrinho> limparCarrinho(ArrayList<ProdutoCarrinho> carrinho);
	public float valorTotalCarrinho(ArrayList<ProdutoCarrinho> carrinho);
	public void concluirCompra(ArrayList<ProdutoCarrinho> carrinho);
	public void continuarCompra();
	
}
