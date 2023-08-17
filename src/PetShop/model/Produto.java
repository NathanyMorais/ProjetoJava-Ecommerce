package PetShop.model;

public class Produto {
	
	private int id;
	private String categoria;
	private String nome;
	private String descricao;
	private float preco;

	public Produto(int id, String categoria, String nome, String descricao, float preco) {
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Produto() {
		
	}

	//Getters e Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	//MÉTODOS
	public void infoProduto() { //método que imprime as informações de cada produto
		System.out.println("-----------------------------------------------------------");
		System.out.println("Código: " + this.getId());
		System.out.println("Categoria: " + this.getCategoria());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Descrição: "+this.getDescricao());
		System.out.printf("Valor: R$ %.2f",this.getPreco());
		System.out.println("\n");
	}
}

