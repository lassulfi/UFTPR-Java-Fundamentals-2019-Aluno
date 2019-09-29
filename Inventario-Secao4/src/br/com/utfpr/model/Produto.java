package br.com.utfpr.model;

public class Produto {

	//Declaracoes de campo de instancia
	private int numeroDoItem;
	private String nomeDoProduto;
	private int unidadesEmEstoque;
	private float precoUnitario;
	
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

	@Override
	public String toString() {
		String description = "Número do Item       : " + this.numeroDoItem + "\n" + 
						     "Nome                 : " + this.nomeDoProduto + "\n" + 
						     "Quantidade em estoque: " + this.unidadesEmEstoque + "\n" +
						     "Preço                : " + this.precoUnitario;
		
		return description;
	}
	
}
