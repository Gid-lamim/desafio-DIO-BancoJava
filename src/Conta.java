package pack1;

public class Conta {
	//esta classe pode ser chamada de supreclass.
	//o uso de herança evita a repetição de código.
	
	private static int sequencial = 1;
	
	private int agencia;	
	private int numero;
	private double saldo;
	
		
	public Conta() {
		super();
		this.agencia = 1;
		this.numero = sequencial++;
	}
	

	public void sacar(double valor) {
		saldo -= valor;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public void imprimirExtrato() {
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
		
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}
	
	protected void contaInfo() {
		System.out.println(String.format("Agência %d", agencia));
		System.out.println(String.format("Numero %d", numero));
		System.out.println(String.format("Saldo %.2f", saldo));
	}
}
