package com.cc.programacao3.banco;
import java.util.Scanner;

public class FormaConta {	

	public Conta criaConta() {
		Scanner in = new Scanner(System.in);
		System.out.print("Informe o numero da conta de 7 dígtos: ");
		String numero = in.nextLine();
		while(!validaNumero(numero)) {
			System.out.println("Numero inválido.");
			System.out.print("Informe o numero de 7 dígtos numericos: ");
			numero = in.nextLine();
		}
		System.out.print("Informe o dígtos da conta: ");
		char dig = in.next().charAt(0); in.nextLine();
		while(dig < '0' || dig > '9') {
			System.out.println("Digito inválido.");
			System.out.print("Informe o dígtos da conta: ");
			dig = in.next().charAt(0); in.nextLine();
		}
		System.out.print("Informe o tipo da conta: (010 - conta corrente | 013 - conta poupança) ");
		String tipo = in.nextLine();
		while(!validaTipo(tipo)) {
			System.out.println("Tipo inválido");
			System.out.print("Informe o tipo da conta: (010 - conta corrente | 013 - conta poupança) ");
			tipo = in.nextLine();
		}
		System.out.print("Informe a agência com 4 digitos: ");
		String agencia = in.nextLine();
		while(!validaAgencia(agencia)) {
			System.out.println("Agencia inválida.");
			System.out.print("Informe a agência com 4 digitos: ");
			agencia = in.nextLine();
		}
		System.out.print("Informe o nome do proprietário: ");
		String nome = in.nextLine();
		nome = nome.toUpperCase();
		while(!validaNome(nome)) {
			System.out.println("Nome inválido.");
			System.out.print("Informe o nome do proprietário: ");
			nome = in.nextLine();
			nome = nome.toUpperCase();
		}
		System.out.print("Informe o CPF: (Somente dígitos) ");
		String cpf = in.nextLine();
		while(!validaCpf(cpf)) {
			System.out.println("CPF inválido.");
			System.out.print("Informe o CPF: (Somente dígitos) ");
			cpf = in.nextLine();
		}
		System.out.print("Informe uma senha numerica de 6 digitos: ");
		String senha = in.nextLine();
		while(!validaSenha(senha)) {
			System.out.println("Senha inválida.");
			System.out.print("Informe uma senha numerica de 6 digitos: ");
			senha = in.nextLine();
		}
		Conta conta = new Conta(nome, cpf, agencia, numero, dig, tipo, senha);
		return conta;		
	}
	
	private boolean validaNumero(String numero) {
		boolean val = true;
		if(numero.length() != 7) {
			val = false;
		}
		else {
			for(int i = 0; i < numero.length(); i++) {
				if(numero.charAt(i) < '0' || numero.charAt(i) > '9') {
					val = false;
					break;
				}
			}
		}
		return val;
	}	

	private boolean validaTipo(String tipo) {
		boolean val = true;
		if(tipo.length() > 3) {
			val = false;
		}
		else {
			if(!tipo.equals("010") && !tipo.equals("013"))  {
				val = false;
			}
		}
		return val;
	}

	private boolean validaAgencia(String agencia) {
		boolean val = true;
		if(agencia.length() != 4) {
			val = false;
		}
		else {
			for(int i = 0; i < agencia.length(); i++) {
				if(agencia.charAt(i) < '0' || agencia.charAt(i) > '9') {
					val = false;
					break;
				}
			}
		}
		return val;
	}

	private boolean validaNome(String nome) {
		boolean val = true;
		for(int i = 0; i < nome.length(); i++) {
			if(!Character.isLetter(nome.charAt(i)) && !Character.isWhitespace(nome.charAt(i))) {
				val = false;
				break;
			}
		}
		return val;
	}
	
	private boolean validaCpf(String cpf) {
		boolean val = true;
		if(cpf.length() != 11) {
			val = false;
		}
		else {
			for(int i = 0; i < cpf.length(); i++) {
				if(!Character.isDigit(cpf.charAt(i))) {
					val = false;
					break;
				}
			}
			if(val) {
				int dig1 = 0;
				int cont = 10;
				
				for(int i = 0; i < 10; i++) {
					dig1 += cont * Character.getNumericValue(cpf.charAt(i));
					cont--;
				}
				
				dig1 = dig1 % 11;
				
				if(dig1 <= 1) {
					dig1 = 0;
				}
				else {
					dig1 = 11 - dig1;
				}
				
				if(dig1 != cpf.charAt(9)) {
					val = false;
				}
				else {
					int dig2 = 0;
					cont = 11;
					
					for(int j = 0; j < 11; j++) {
						dig2 += cont * Character.getNumericValue(cpf.charAt(j)); 
					}
					
					dig2 = dig2 % 11;
					
					if(dig2 <= 1) {
						dig2 = 0;
					}
					else {
						dig2 = 11 - dig2;
					}
					
					if(dig2 != cpf.charAt(10)) {
						val = false;
					}
				}
			}
		}
		return val;
	}
 
	private boolean validaSenha(String senha) {
		boolean val = true;
		if(senha.length() != 6) {
			val = false;
		}
		else {
			for(int i = 0; i < senha.length(); i++) {
				if(!Character.isDigit(senha.charAt(i))) {
					val = false;
					break;
				}
			}
		}
		return val;
	}
}
