package br.com.utfpr.model;

public class CD extends Produto {
	
	private String artista;
	private int numeroDeMusicas;
	private String selo;
		
	public CD(int numeroDoItem, String nomeDoProduto, int unidadesEmEstoque, float precoUnitario,
			String artista, int numeroDeMusicas, String selo) {
		super(numeroDoItem, nomeDoProduto, unidadesEmEstoque, precoUnitario);
		this.artista = artista;
		this.numeroDeMusicas = numeroDeMusicas;
		this.selo = selo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getNumeroDeMusicas() {
		return numeroDeMusicas;
	}

	public void setNumeroDeMusicas(int numeroDeMusicas) {
		this.numeroDeMusicas = numeroDeMusicas;
	}

	public String getSelo() {
		return selo;
	}

	public void setSelo(String selo) {
		this.selo = selo;
	}
	
	@Override
	public String toString() {
		String description = "Número do Item       : " + super.getNumeroDoItem() + "\n" + 
			     "Nome                   : " + super.getNomeDoProduto() + "\n" + 
			     "Artista                : " + this.artista + "\n" +
			     "Músicas do Álbum       : " + this.numeroDeMusicas + "\n" +
			     "Selo de Gravação       : " + this.selo + "\n" +
			     "Quantidade em estoque  : " + super.getUnidadesEmEstoque() + "\n" +
			     "Preço                  : " + super.getPrecoUnitario() + "\n" +
			     "Valor do Estoque       : " + this.getValorEstoque() + "\n" +
			     "Status do produto    : " + (super.isAtivo() ? "Ativo" : "Descontinuado") + "\n";

		return description;
	}	
}
