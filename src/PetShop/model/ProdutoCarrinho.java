package PetShop.model;

public class ProdutoCarrinho extends Produto {
	
	private int quantidade;
	private float total;

	public ProdutoCarrinho(int id, String categoria, String nome, String descricao, float preco, int quantidade) {
		super(id, categoria, nome, descricao, preco);
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getTotal() {
		return this.getPreco()*quantidade;
	}

}
