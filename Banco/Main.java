package com.cc.programacao3.banco;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Banco banco = new Banco(200);
		FormaConta form = new FormaConta();
		int op;
		System.out.println("Vamos começar as operações do nosso banco.");
		do {
			exibeMenu();
			op = in.nextInt(); in.nextLine();
			switch(op) {
				case 1: banco.inserirConta(form.criaConta()); break;
				case 2: 
					System.out.print("informe o numero da conta: ");
					String numero = in.nextLine();
					banco.exibeConta(numero);
					break;
				case 3: banco.exibirContas(); break;
				case 4:
				    System.out.print("informe o numero da conta: ");
					numero = in.nextLine();
					Conta c = banco.resgataConta(numero);
					menu(c, banco);
					break;
				case 0: System.out.println("Obrigado e até logo."); break;
				default: System.out.println("Opção inválida.");
			}
		}while(op == 0);
	}
	
	private static void exibeMenu() {
		String menu = "Escolha uma das opções abaixo.\n"
				+ "1 - Adicionar uma conta;\n"
				+ "2 - Exibir uma conta;\n"
				+ "3 - Exibir todas as contas;\n"
				+ "4 - Opções de conta;\n"
				+ "0 - Encerrar caixa.\n"
				+ "Opção: ";
		System.out.print(menu);
	}
	
	private static void exibeMenuConta() {
		String menu = "Escolha uma das opções abaixo.\n"
				+ "1 - Saldo;\n"
				+ "2 - Deposito;\n"
				+ "3 - Saque;\n"
				+ "4 - Tranferência;\n"
				+ "0 - Encerrar operações.\n"
				+ "Opção: ";
		System.out.print(menu);
	}
	
	private static void menu(Conta c, Banco b) {
		Scanner in = new Scanner(System.in);
		int op;
		char resp;
		do {
			exibeMenuConta();
			op = in.nextInt();
			switch(op) {
				case 1: c.exibirSaldo(); break;
				case 2:
					System.out.print("Informe o valo a ser depositado: ");
					double valor = in.nextDouble(); in.nextLine();
					c.deposita(valor);
					break;
				case 3:
					System.out.print("Informe o valor a ser sacado: ");
					valor = in.nextDouble(); in.nextLine();
					c.saca(valor);
					break;
				case 4:
					System.out.print("Informe o valor a ser tranferido: ");
					valor = in.nextDouble(); in.nextLine();
					System.out.print("Informe a o número da conta para transferência: ");
					String numero = in.nextLine();
					Conta c1 = b.resgataConta(numero);
					if(c1 == null) {
						System.out.println("Conta não encontrada!");
					}
					else {
						c.transfere(valor, c1);
					}
					break;
				case 0: break;
				default: System.out.println("Opção inválida.");				
			}
		}while(op == 0);
	}
}
