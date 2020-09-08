package com.cc.programacao3.banco;

public class Banco {
	private Conta[] contas;
	private int qtd;
	
	public Banco (int qtdContas) {
		contas = new Conta[qtdContas];
	}
	
	public void inserirConta(Conta conta) {
		if(qtd == contas.length) {
			System.out.println("O banco pode armazenar no máximo " + contas.length + " contas.");
		}
		else {
			if(qtd == 0) {
				this.contas[0] = conta;
				this.qtd++;
			}
			else {
				if(this.procuraConta(conta.getNumero()) != -1){
					System.out.println("Conta já existente.");
				}
				else {
					this.insercaoOrdenada(conta);
					this.qtd++;
				}
			}
		}
	}
	
	private int procuraConta(String numero) {
		int index = -1;
		int inicio = 0;
		int fim = this.qtd - 1;
		int meio;
		while(inicio <= fim) {
			meio = (inicio + fim)/2;
			if(contas[meio].getNumero().compareToIgnoreCase(numero) < 0) {
				inicio = meio + 1;
			}
			else if (contas[meio].getNumero().compareToIgnoreCase(numero) > 0){
				fim = meio - 1;
			}
			else {
				index = meio;
				break;
			}
		}
		return index;
	}
	
	private void insercaoOrdenada(Conta conta) {
		int index =  this.qtd;
		for(int i = 0; i < this.qtd; i++) {
			if(this.contas[i].compareTo(conta) > 0) {
				for(int j = this.qtd; j > i; j--) {
					contas[j] = contas[j-1];
				}
				index = i;
				break;
			}
		}
		contas[index] = conta;
	}
	
	public void exibirContas() {
		for(int i = 0; i < this.qtd; i++) {
			System.out.print(contas[i]);
		}
	}
	
	public void exibeConta(String numero) {
		int index = this.procuraConta(numero);
		if(index == -1) {
			System.out.println("Conta não encontrada.");
		}
		else {
			System.out.print(contas[index]);			
		}
	}
	public Conta resgataConta(String numero) {
		int index = this.procuraConta(numero);
		if(index == -1) {
			return null;
		}
		else {
			return contas[index];
		}
	}
}
