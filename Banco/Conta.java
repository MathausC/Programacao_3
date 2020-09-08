package com.cc.programacao3.banco;
import java.util.Scanner;

public class Conta implements Comparable<Conta>{
	private String numero;
	private char dig;
	private String agencia;
	private String tipo;
	private double saldo;
	private String nome;
	private String cpf;
	private String senha;
	
	private void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumero() {
		return this.numero;
	}
	
	private void setDig(char dig) {
		this.dig = dig;
	}
	public char getDig() {
		return this.dig;
	}
	
	private void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getAgencia() {
		return this.agencia;
	}
	
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}
	
	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf(String cpf) {
		return this.cpf;
	}
	
	public Conta(String nome, String cpf,String agencia, String numero, char dig, String tipo, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setAgencia(agencia);
		this.setNumero(numero);
		this.setDig(dig);
		this.setTipo(tipo);
		this.setSaldo(0);
		this.senha = senha;
	}
	
	public void deposita(double valor) {
		if(valor <= 0) {
			System.out.println("O valor a se depositado deve ser maior que zero (0)");
		}
		else {
			this.setSaldo(this.getSaldo() + valor);
			System.out.println("Deposito de R$" + valor +" realizado com sucesso.");
		}
	}
	
	public void saca(double valor) {
		if(verificaSenha()) {
			if(valor > this.getSaldo()) {
				System.out.println("Saldo insuficiente.");
			}
			else {
				this.setSaldo(this.getSaldo() - valor);
				System.out.println("Saque de R$" + valor +" realizado com sucesso.");
			}
		}
		else {
			System.out.println("Senha incorreta");
		}
	}
	
	public void transfere(double valor, Conta conta) {
		if(verificaSenha()) {
			if(valor <= 0) {
				System.out.println("Não é possível transferir valores menores ou iguais a zero (0).");
			}
			else {
				if(this.getSaldo() < valor) {
					System.out.println("Saldi insuficiente para a transferencia");
				}
				else {
					this.saca(valor);
					conta.deposita(valor);
					System.out.println("Transferencia de R$" + valor + "realizada com sucesso.");
				}
			}
		}
	}
	
	private boolean verificaSenha() {
		Scanner in = new Scanner(System.in);
		System.out.print("Informe a senha: ");
		String senha = in.nextLine();
		return this.senha.equals(senha);
	}
	
	public void exibirSaldo() {
		if(!verificaSenha()) {
			System.out.println("Senha incorreta.");
		}
		else {
			System.out.println("Seu saldo é: R$" + this.getSaldo());
		}
	}

	public int compareTo(Conta obj) {
		return this.getNumero().compareToIgnoreCase(obj.getNumero());
	}
	
	public String toString() {
		String mensagem = "Nome: " + this.getNome() + "\n"
				+ "CPF: " + this.getCpf(cpf) + "\n"
				+ "Agencia: " + this.getAgencia() + "\n"
				+ "Numero: " + this.getNumero() + "\n"
				+ "Dígito: " + this.getDig() + "\n"
				+ "Saldo: " + this.getSaldo() + "\n";
		return mensagem;
	}
}
