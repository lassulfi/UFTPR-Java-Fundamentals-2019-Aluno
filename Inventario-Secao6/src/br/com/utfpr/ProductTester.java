package br.com.utfpr;

import java.util.Scanner;

import br.com.utfpr.model.Produto;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int maxSize = -1;
		
		System.out.println("== SISTEMA DE CADASTRO DE PRODUTOS ==\n");
		System.out.println("\nInsira o número de produtos que gostaria de adicionar.");
		System.out.print("Insira 0 (zero) se não quiser adicionar produtos: ");
				
		do {
			try {
				maxSize = in.nextInt();
				if(maxSize < 0) {
					System.out.println("\nValor incorreto inserido.");
					System.out.print("Informe um novo valor: ");
				}
			} catch (Exception e) {
				System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
				in.next();
			}
		} while (maxSize < 0);
		
		int tempNumber, tempQty;
		String tempName;
		float tempPrice;
		
		Produto[] produtos = null;
		
		if(maxSize == 0) {
			System.out.println("\nNão há produtos!");
		} else {
			produtos = new Produto[maxSize];
			for(int i = 0; i < maxSize; i++) {
				
				in.nextLine();
				
				System.out.println("\n+ Cadastrar novo produto +");
				System.out.print("- Código do produto: ");
				tempNumber = in.nextInt();
				in.hasNextLine();
				System.out.print("- Nome do produto: ");
				tempName = in.nextLine();
				System.out.print("- Quantidade em estoque: ");
				tempQty = in.nextInt();
				System.out.print("- Preço unitário: ");
				tempPrice = in.nextFloat();
				
				produtos[i] = new Produto(tempNumber, tempName, tempQty, tempPrice);
			}
		}
		
		for(Produto p : produtos) {
			System.out.println("\n= Informações do Produto =");
			System.out.println(p);
		}
		
		in.close();		
		
	}
}
