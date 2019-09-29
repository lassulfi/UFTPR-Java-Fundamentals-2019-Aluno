package br.com.utfpr.model;

public class DVD extends Produto {
	
	private int duracao;
	private int classificacaoEtaria;
	private String estudioCinematografico;
	
	public DVD(int numeroDoItem, String nomeDoProduto, int unidadesEmEstoque, float precoUnitario, 
			int duracao, int classificacaoEtaria, String estudioCinematografico) {
		super(numeroDoItem, nomeDoProduto, unidadesEmEstoque, precoUnitario);
		this.duracao = duracao;
		this.classificacaoEtaria = classificacaoEtaria;
		this.estudioCinematografico = estudioCinematografico;
	}

	@Override
	public float getValorEstoque() {
		int unidades = super.getUnidadesEmEstoque();
		double precoUnitario = super.getPrecoUnitario();
		
		double taxaReposicao = 5 * unidades * precoUnitario / 100;
		
		return (float) ((unidades * precoUnitario) + taxaReposicao);
	}



	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	public void setClassificacaoEtaria(int classificacaoEtaria) {
		this.classificacaoEtaria = classificacaoEtaria;
	}

	public String getEstudioCinematografico() {
		return estudioCinematografico;
	}

	public void setEstudioCinematografico(String estudioCinematografico) {
		this.estudioCinematografico = estudioCinematografico;
	}

	@Override
	public String toString() {
		String description = "Número do Item       : " + super.getNumeroDoItem() + "\n" + 
			     "Nome                   : " + super.getNomeDoProduto() + "\n" + 
			     "Duração do filme       : " + this.duracao + "\n" +
			     "Classificação etária   : " + this.classificacaoEtaria + "\n" +
			     "Estúdio cinematográfico: " + this.estudioCinematografico + "\n" +
			     "Quantidade em estoque  : " + super.getUnidadesEmEstoque() + "\n" +
			     "Preço                  : " + super.getPrecoUnitario() + "\n" +
			     "Valor do Estoque       : " + this.getValorEstoque() + "\n" +
			     "Status do produto    : " + (super.isAtivo() ? "Ativo" : "Descontinuado") + "\n";

		return description;
	}	
}
