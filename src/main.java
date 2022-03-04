import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class main {
    public static void main(String[] args) throws IOException {

    	
    	/*
    	 * ao invés de termos uma classe banco, achei mais interessante ter uma classe agência com um hashmap contendo os clientes com uma chave para cada cliente.
    	 *
    	 * as operações de depósito, transferência e saque serão feitas dentro do objeto agência.
    	 * 
    	 */
    	
    	
    	Agencia agencia1 = new Agencia(); // cria uma instância da classe agência. 
    	Agencia agencia2 = new Agencia(); // cria uma instância da classe agência. 
    	
    	
    	//criando os clientes    	
    	agencia1.addClient(new Cliente("Eric Smith"));
       	agencia1.addClient(new Cliente("Arivaldo Argue"));
    	agencia1.addClient(new Cliente("Maline Rigerio"));
    	agencia1.addClient(new Cliente("Manede Regola"));
   
    	agencia2.addClient(new Cliente("Verusya Yarik"));
    	
    	
    	
    	
    	// depositando em conta
    	agencia1.depositar(1, 113000);
    	agencia1.depositar(2, 21300);
    	agencia1.depositar(3, 41300);
    	agencia1.depositar(4, 55400);
    	agencia1.depositar(5, 400);
    	agencia2.depositar(5, 100);
    	
    	
    	
    	//transfer�ncias
    	agencia1.transferir(agencia1, 4, agencia1, 2, 4000);    //para transferência entre contas correntes,  inserimos o id e agência do cliente de saida e o id e agência do cliente que irá receber e o valor;
    	agencia1.transferir(agencia1, 4, agencia2, 5, 4000);    
    	
    	agencia1.transferirPoupanca(1, 110000); //para transferência para conta poupança, apenas inserimos o id do cliente e o valor    	
    	agencia1.transferirPoupanca(2, 14000); 	
    	
    	
    	
    	
    	//informações de agência
    	agencia1.agenciaInfo(); 
    	agencia1.getClients();
    	
    	agencia2.agenciaInfo(); 
    	agencia2.getClients();
    	
    	
    	
    	//extrato de cliente
    	agencia1.clienteExtrato(1); // imprime o extrato do cliente pelo id
    	
    	
    	}
}
