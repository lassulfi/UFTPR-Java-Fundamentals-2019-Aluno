package br.com.utfpr;

import java.util.Scanner;

import br.com.utfpr.model.Produto;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int tempNumber, tempQty;
		String tempName;
		float tempPrice;
		
		System.out.println("== SISTEMA DE CADASTRO DE PRODUTOS ==\n");
		System.out.println("+ Cadastrar produto p1 +");
		System.out.print("- Código do produto: ");
		tempNumber = in.nextInt();
		in.nextLine();
		System.out.print("- Nome do produto: ");
		tempName = in.nextLine();
		System.out.print("- Quantidade em estoque: ");
		tempQty = in.nextInt();
		System.out.print("- Preço unitário: ");
		tempPrice = in.nextFloat();
		
		Produto p1 = new Produto(tempNumber, tempName, tempQty, tempPrice);
		
		in.nextLine();
		
		System.out.println("\n+ Cadastrar produto p2 +");
		System.out.print("- Código do produto: ");
		tempNumber = in.nextInt();
		System.out.print("- Nome do produto: ");
		tempName = in.next();
		in.nextLine();
		System.out.print("- Quantidade em estoque: ");
		tempQty = in.nextInt();
		System.out.print("- Preço unitário: ");
		tempPrice = in.nextFloat();
		
		Produto p2 = new Produto(tempNumber, tempName, tempQty, tempPrice);
		p2.setAtivo(true);
		
		System.out.println("\n= Informações do Produto 1 =");
		System.out.println(p1);
		System.out.println("\n= Informações do Produto 2 =");
		System.out.println(p2);
		
		in.close();		
		
	}
}
