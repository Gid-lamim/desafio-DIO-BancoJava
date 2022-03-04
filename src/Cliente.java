package pack1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private static int sequencial = 1;
	
	private String nome;
	private int id;//tamb�m achei interessante que cada cliente tivesse um n�mero (id).
	private Conta contaCorrente; 
	private Conta contaPoupanca;
	
	public Cliente(String nome) {
		super();
		this.nome = nome;
		id = sequencial++;
				
		// ao ser criado, o cliente recebe duas contas
		contaCorrente = new ContaCorrente();
		contaPoupanca = new ContaPoupanca();
	}
	
	public String getNome() {
		return nome;
	}

	public void imprimeExtrato() {
		System.out.println(" *** Informa��es do cliente e saldo em conta ***");
		System.out.println("Nome: " + nome);
		System.out.println("Id: " + id);
		System.out.println(" *******************************************");
		
			contaCorrente.imprimirExtrato();
			contaPoupanca.imprimirExtrato();
		
		System.out.println(" *******************************************");
	}

	public int getId() {
		return id;
	}
	
	public double valorTotal() {
		return contaCorrente.getSaldo() + contaPoupanca.getSaldo(); 
	}
	
	public void depositarPoupanca(double valor) {
		contaPoupanca.depositar(valor);
	}
	
	public void depositar(double valor) {
		contaCorrente.depositar(valor);
	}
	public void sacar(double valor) {
		contaCorrente.sacar(valor);
	}	
	
}
