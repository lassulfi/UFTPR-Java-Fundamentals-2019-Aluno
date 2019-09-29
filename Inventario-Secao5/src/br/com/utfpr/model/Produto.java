package br.com.utfpr.model;

public class Produto {

	//Declaracoes de campo de instancia
	private int numeroDoItem;
	private String nomeDoProduto;
	private int unidadesEmEstoque;
	private float precoUnitario;
	private boolean ativo;
	
	//Construtor padrao sem parametros.
	public Produto() {
	}
	
	//Construtor com parametros
	public Produto(int numeroDoItem, String nomeDoProduto, int unidadesEmEstoque, float precoUnitario) {
		this.numeroDoItem = numeroDoItem;
		this.nomeDoProduto = nomeDoProduto;
		this.unidadesEmEstoque = unidadesEmEstoque;
		this.precoUnitario = precoUnitario;
	}
	
	public float getValorEstoque() {
		return this.unidadesEmEstoque * this.precoUnitario;
	}

	public int getNumeroDoItem() {
		return numeroDoItem;
	} //retorna o número do item

	public void setNumeroDoItem(int numeroDoItem) {
		this.numeroDoItem = numeroDoItem;
	} //define o número do item

	public String getNomeDoProduto() {
		return nomeDoProduto;
	} //retorna no nome do produto

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	} //define o nome do produto

	public int getUnidadesEmEstoque() {
		return unidadesEmEstoque;
	} //retorna o numero de unidades em estoque

	public void setUnidadesEmEstoque(int unidadesEmEstoque) {
		this.unidadesEmEstoque = unidadesEmEstoque;
	} //define o numero de unidades em estoque

	public float getPrecoUnitario() {
		return precoUnitario;
	} //retorna o preco unitario

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	} //define o preco unitario
	
	public boolean isAtivo() {
		return ativo;
	} //retorna true se o produto está ativo ou false se está inativo

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	} //define o status do produto (true para ativo e false para inativo) 

	@Override
	public String toString() {
		String description = "Número do Item       : " + this.numeroDoItem + "\n" + 
						     "Nome                 : " + this.nomeDoProduto + "\n" + 
						     "Quantidade em estoque: " + this.unidadesEmEstoque + "\n" +
						     "Preço                : " + this.precoUnitario + "\n" +
						     "Valor do Estoque     : " + this.getValorEstoque() + "\n" +
						     "Status do produto    : " + (this.ativo ? "Ativo" : "Descontinuado") + "\n";
		
		return description;
	}
	
}
