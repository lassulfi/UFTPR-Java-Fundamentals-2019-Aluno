package br.com.utfpr;

import java.util.Scanner;

import br.com.utfpr.model.CD;
import br.com.utfpr.model.DVD;
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
		int stockChoice = -1;	
		
		for(int i = 0; i < produtos.length; i++) {
			
			in.nextLine();
			
			System.out.println("\n+ Cadastrar novo produto +");
			System.out.println("Selecione uma das opções abaixo para cadastrar: ");
			System.out.println("1: CD");
			System.out.println("2: DVD");
			System.out.print("Insira o tipo de produto: ");
			do {
				try {
				stockChoice = in.nextInt();
					if(stockChoice < 1 || stockChoice > 2) {
						System.out.println("Somente os números 1 e 2 são permitidos.");
						System.out.print("informe um número válido: ");
					}
				} catch (Exception e) {
					System.out.print("\nTipo incorreto de dados inserido! Informe um novo valor: ");
					in.nextLine();
				}
			} while (stockChoice < 1 || stockChoice > 2);
			
			switch (stockChoice) {
			case 1:
				addCDToInvetory(produtos, in, i);
				break;
			case 2:
				addDVDToInvetory(produtos, in, i);
			default:
				break;
			}

		}
	}
	
	private static void addCDToInvetory(Produto[] produtos, Scanner in, int index) {
		int tempNumber, tempQty, tempSongs;
		String tempCDName, tempArtistName, tempRecorderName;
		float tempPrice;		
			
			in.nextLine();
			
			System.out.println("\n+ Cadastrar novo CD +");
			System.out.print("- Código do produto: ");
			tempNumber = in.nextInt();
			in.nextLine();
			System.out.print("- Nome do CD: ");
			tempCDName = in.nextLine();
			System.out.print("- Nome do artista: ");
			tempArtistName = in.nextLine();
			System.out.print("- Nome do selo de gravação: ");
			tempRecorderName = in.nextLine();
			System.out.print("- Número de músicas: ");
			tempSongs = in.nextInt();
			System.out.print("- Quantidade em estoque: ");
			tempQty = in.nextInt();
			System.out.print("- Preço unitário: ");
			tempPrice = in.nextFloat();
			
			produtos[index] = new CD(tempNumber, tempCDName, tempQty, tempPrice, 
					tempArtistName, tempSongs, tempRecorderName);
	}
	
	private static void addDVDToInvetory(Produto[] produtos, Scanner in, int index) {
		int tempNumber, tempQty, tempDuration, tempAgeLimit;
		String tempDVDName, tempStudioName;
		float tempPrice;		
			
			in.nextLine();
			
			System.out.println("\n+ Cadastrar novo DVD +");
			System.out.print("- Código do produto: ");
			tempNumber = in.nextInt();
			in.nextLine();
			System.out.print("- Nome do DVD: ");
			tempDVDName = in.nextLine();
			System.out.print("- Nome do estúdio cinematográfico: ");
			tempStudioName = in.nextLine();
			System.out.print("- Classificação etária: ");
			tempAgeLimit = in.nextInt();
			System.out.print("- Duração em minutos: ");
			tempDuration = in.nextInt();
			System.out.print("- Quantidade em estoque: ");
			tempQty = in.nextInt();
			System.out.print("- Preço unitário: ");
			tempPrice = in.nextFloat();
			
			produtos[index] = new DVD(tempNumber, tempDVDName, tempQty, tempPrice, 
					tempDuration, tempAgeLimit, tempStudioName);
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
			System.out.print("\nInsira uma opção de menu: ");
			
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
			System.out.print("\nInforme o índice desejado: ");
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
		
		if(!produtos[productChoice].isAtivo()) {
			System.out.println("Não é possível adicionar estoque de produto inativo.");
		} else {
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
	}
	
	private static void deductInventory(Produto[] produtos, Scanner in) {
		int productChoice;
		int updateValue = -1;
		
		productChoice = getProductNumber(produtos, in);
		
		System.out.print("\nQuantos produtos deseja retirar? ");
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
			System.out.println("\nExibir Lista de Produtos");
			displayInventory(produtos);
			break;
		case 2:
			System.out.println("\nAdicionar Estoque");
			addInventory(produtos, in);
			break;
		case 3:
			System.out.println("\nDeduzir estoque");
			deductInventory(produtos, in);
			break;
		case 4:
			System.out.println("\nDescontinuar produto");
			discontinueInventory(produtos, in);
		default:
			System.out.println("\nSaindo do menu de opções");
			break;
		}
	}
}
