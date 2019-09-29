package br.com.utfpr;

import java.util.Scanner;

import br.com.utfpr.model.Produto;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
				
		System.out.println("== SISTEMA DE CADASTRO DE PRODUTOS ==\n");
		System.out.println("\nInsira o número de produtos que gostaria de adicionar.");
		System.out.print("Insira 0 (zero) se não quiser adicionar produtos: ");
		
		int maxSize, menuChoice;
		maxSize = getNumProducts(in);
					
		Produto[] produtos = null;
		
		if(maxSize == 0) {
			System.out.println("\nNão há produtos!");
		} else {
			produtos = new Produto[maxSize];
			
			addToInvetory(produtos, in);
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, produtos, in);
			} while(menuChoice != 0);
		}
				
		in.close();		
	}
	
	private static void addToInvetory(Produto[] produtos, Scanner in) {
		int tempNumber, tempQty;
		String tempName;
		float tempPrice;		
		
		for(int i = 0; i < produtos.length; i++) {
			
			in.nextLine();
			
			System.out.println("\n+ Cadastrar novo produto +");
			System.out.print("- Código do produto: ");
			tempNumber = in.nextInt();
			in.nextLine();
			System.out.print("- Nome do produto: ");
			tempName = in.nextLine();
			System.out.print("- Quantidade em estoque: ");
			tempQty = in.nextInt();
			System.out.print("- Preço unitário: ");
			tempPrice = in.nextFloat();
			
			produtos[i] = new Produto(tempNumber, tempName, tempQty, tempPrice);
		}
	}
	
	private static void displayInventory(Produto[] produtos) {
		for(Produto p : produtos) {
			System.out.println("\n= Informações do Produto =");
			System.out.println(p);
		}
	}
	
	private static int getNumProducts(Scanner in) {
		int maxSize = -1;
		
		do {
			try {
				maxSize = in.nextInt();
				if(maxSize < 0) {
					System.out.println("\nValor incorreto inserido.");
					System.out.print("Informe um novo valor: ");
				}
			} catch (Exception e) {
				System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
				in.nextLine();
			}
		} while (maxSize < 0);
		
		return maxSize;
	}
	
	private static int getMenuOption(Scanner in) {
		int option = -1;
		
		do {
			System.out.println("\n# Editar produto cadastrado");
			System.out.println("Escolha uma opção:");
			System.out.println("1. Exibir inventário");
			System.out.println("2. Adicionar estoque");
			System.out.println("3. Deduzir estoque");
			System.out.println("4. Descontinuar produto");
			System.out.println("0. Sair");
			System.out.print("Insira uma opção de menu: ");
			
			try {
				option = in.nextInt();
				if(option < 0 || option > 4) {
					System.out.println("\nValor incorreto inserido.");
					System.out.print("Informe um novo valor: ");
				}
			} catch (Exception e) {
				System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
				in.nextLine();
			}
		} while(option < 0 || option > 4);
		
		return option;
	}
	
	private static int getProductNumber(Produto[] produtos, Scanner in) {
		int productChoice = -1;
		
		System.out.println("Escolha o índice referente aos produtos listados ");
		for(int i = 0; i < produtos.length; i++) {
			System.out.println("| Índice: " + i + " | Produto: " + produtos[i].getNomeDoProduto() + " |");
		}
		do {
			System.out.print("Informe o índice desejado: ");
			try {
				productChoice = in.nextInt();
			} catch (Exception e) {
				System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
				in.nextLine();
			}
			if(productChoice < 0 || productChoice > produtos.length - 1) {
				System.out.print("Índice invalido. Informe um novo indice: ");
			}
		} while (productChoice < 0 || productChoice > produtos.length - 1);
		
		return productChoice;
	}
	
	private static void addInventory(Produto[] produtos, Scanner in) {
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(produtos, in);
		
		System.out.print("Quantos produtos deseja adicionar? ");
		do {
			try {
				updateValue = in.nextInt();
				if(updateValue < 0) {
					System.out.print("A quantidade de produtos informada é inválida. "
							+ "Informe um valor maior que 0 (zero): ");
				}
			} catch (Exception e) {
				System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
				in.nextLine();
			}
		} while(updateValue < 0);
		
		produtos[productChoice].addToInventory(updateValue);
	}
	
	private static void deductInventory(Produto[] produtos, Scanner in) {
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(produtos, in);
		
		System.out.print("Quantos produtos deseja retirar? ");
		do {
			try {
				updateValue = in.nextInt();
				if(updateValue < 0) {
					System.out.print("A quantidade de produtos informada é inválida. "
							+ "Informe um valor maior que 0 (zero): ");
				} else if (updateValue > produtos[productChoice].getUnidadesEmEstoque()) {
					System.out.print("A quantidade de produtos informada é inválida. "
							+ "Informe um valor inferior que a quantidade de unidades em estoque: ");
				}
			} catch (Exception e) {
				System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
				in.nextLine();
			}
		} while(updateValue < 0 || updateValue > produtos[productChoice].getUnidadesEmEstoque());
		
		produtos[productChoice].deductFromInventory(updateValue);
	}
	
	private static void discontinueInventory(Produto[] produtos, Scanner in) {
		int productChoice = getProductNumber(produtos, in);
		
		produtos[productChoice].setAtivo(false);		
	}
	
	private static void executeMenuChoice(int menuOption, Produto[] produtos, Scanner in) {
		switch (menuOption) {
		case 1:
			System.out.println("Exibir Lista de Produtos");
			displayInventory(produtos);
			break;
		case 2:
			System.out.println("Adicionar Estoque");
			addInventory(produtos, in);
			break;
		case 3:
			System.out.println("Deduzir estoque");
			deductInventory(produtos, in);
			break;
		case 4:
			System.out.println("Descontinuar produto");
			discontinueInventory(produtos, in);
		default:
			System.out.println("Saindo do menu de opções");
			break;
		}
	}
}
