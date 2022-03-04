public class ContaCorrente extends Conta {

		@Override
		public void imprimirExtrato(){
			System.out.println("  ***  EXTRATO CONTA CORRENTE  *** ");
			super.contaInfo();
		}
	
}
