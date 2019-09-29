package br.com.utfpr;

import br.com.utfpr.model.Produto;

public class ProductTester {

	public static void main(String[] args) {
		
		Produto produto1 = new Produto();
		produto1.setNumeroDoItem(1);
		produto1.setNomeDoProduto("Notebook Dell Inspirion 14");
		produto1.setUnidadesEmEstoque(100);
		produto1.setPrecoUnitario(3500.0f);
		
		Produto produto2 = new Produto();
		produto2.setNumeroDoItem(2);
		produto2.setNomeDoProduto("Monitor LG 15\"");
		produto2.setUnidadesEmEstoque(50);
		produto2.setPrecoUnitario(450.0f);
		
		Produto produto3 = new Produto(3, "Teclado Mecânico Razor", 60, 850.0f);
		Produto produto4 = new Produto(4, "Mouse Óptico Microsoft", 150, 60.0f);
		Produto produto5 = new Produto(5, "Placa de Vídeo GeForce NVidia", 30, 2500.0f);
		Produto produto6 = new Produto(6, "Celular Samsung Galaxy S9", 20, 3450.0f);
		
		System.out.println("= Informações do Produto =");
		System.out.println(produto1);
		System.out.println("\n= Informações do Produto =");
		System.out.println(produto2);
		System.out.println("\n= Informações do Produto =");
		System.out.println(produto3);
		System.out.println("\n= Informações do Produto =");
		System.out.println(produto4);
		System.out.println("\n= Informações do Produto =");
		System.out.println(produto5);
		System.out.println("\n= Informações do Produto =");
		System.out.println(produto6);
		
	}
}
