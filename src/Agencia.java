package pack1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agencia {

	private static int sequencial = 1;
	
	private int numero; // numero da ag�ncia
	private HashMap<Integer, Cliente> clientes;
	
	/*Escolhi ter uma lista de clientes.
	 * Cada cliente poder� ter mais de uma conta no banco.
	 *  Imaginei q faria mais sentido acessar a conta dessa forma. 
	 */
	
	public Agencia() {
		super();
		this.numero = sequencial++;
		this.clientes = new HashMap<Integer, Cliente>();
	}
	
	public void addClient(Cliente cliente) {
		//cada cliente ser� adicionado atrav� de um m�todo na classe banco
		clientes.put(cliente.getId(), cliente);	
		System.out.println("Cliente " + cliente.getNome() + "adicionado com sucesso...");
	}
		
	public void depositar(int id, double valor) { //o deposito ser� feito na conta corrente do cliente pelo id
		if(clientes.containsKey(id)) {
			clientes.get(id).depositar(valor);
			System.out.println("deposito de " + valor + " na conta " + id + " realizado com sucesso");
		} else {
			System.out.println("n�o foi poss�vel realizar a opera��o");
		}
	}
	
	public void sacar(int id, double valor) { //o saque ser� feito da conta corrente do cliente pelo id
		if(clientes.containsKey(id)) {
			clientes.get(id).sacar(valor);
			System.out.println("saque de " + valor + " na conta " + id + " realizado com sucesso");
		}else {
			System.out.println("n�o foi poss�vel realizar a opera��o");
		}
	}
	
	public void transferir(Agencia agenciaSaida, int idSaida, Agencia agenciaDestino, int idDestino, double valor) { //transfer�ncias entre contas correntes
			agenciaSaida.sacar(idSaida, valor);
			agenciaDestino.depositar(idDestino, valor);
			
	}

	public void transferirPoupanca(int id, double valor) { //transfer�ncias entre contas corrente e poupan�a
		if(clientes.containsKey(id)) {
			clientes.get(id).sacar(valor);
			clientes.get(id).depositarPoupanca(valor);
			System.out.println("transfer�ncia do " + valor + " para a conta popan�a do id " + id + " realizada com sucesso");
		} else {
			System.out.println("n�o foi poss�vel realizar a opera��o");
		}
	}
	
	public void clienteExtrato(int id) {
		if(clientes.containsKey(id)) clientes.get(id).imprimeExtrato();
	}
	
	public int getTotalClientes() {//retorna o n�mero de clientes da ag�ncia
		return this.clientes.size();
	}
	
	private double getTotalDepositos() {//retorna o total de dinheiro na ag�ncia
		double total = 0;
		for (Map.Entry<Integer, Cliente> cliente : clientes.entrySet()) {
			total += cliente.getValue().valorTotal();
		}
		return total;
	}
	
	
	public void agenciaInfo() {
		System.out.println("\n");
		System.out.println("+---------------------------------------+");
		System.out.println("|        ***   BANCO AMISH  ***          ");
		System.out.println("|Agencia " + numero);
		System.out.println("|Clientes " + getTotalClientes());
		System.out.println("|Dinheiro total " + String.format("%.2f", getTotalDepositos()));
		System.out.println("+---------------------------------------+");
		System.out.println("");
		
	}
	
	public void getClients() {
		System.out.println("\n");
		System.out.println("+Clientes ag�ncia " + numero + "----------------------+");
		for (Map.Entry<Integer, Cliente>  cliente : clientes.entrySet()) {
			System.out.println("|--> " + cliente.getValue().getNome() + "  (id: " + cliente.getValue().getId() + ") ");
		}
		System.out.println("+---------------------------------------+");
		System.out.println("");
	}
	
	
	
}
