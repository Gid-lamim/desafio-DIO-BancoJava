package pack1;

public class ContaPoupanca extends Conta  {

	@Override
	public void imprimirExtrato(){
		System.out.println("  ***  EXTRATO CONTA POUPAN�A  *** ");
		super.contaInfo();
	}
	

	
}
