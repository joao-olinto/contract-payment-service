package application;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import domain.entities.Contract;
import domain.entities.Installment;
import domain.service.ContractService;
import domain.service.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		/*
		 * Instanciamos a classe de serviÇo passando como parametro a classe concreta
		 * que vai representar o serviÇo de pagamento online, que e uma interface
		 */
		ContractService service = new ContractService(new PayPalService());
		
		 // instanciamos a classe responsavel por criar a entidade de contrato
		 
		ReaderAndCreateContract create = new ReaderAndCreateContract();

		// Fazemos a chamada ao metodo responsavel por criar a entidade de contrato

		Contract contract = create.addContract(sc);

		// Instanciamos a classe responsavel por ler o numero de parcelas
		ReaderNumberInstallment reader = new ReaderNumberInstallment();

		//Fazemos a chamada ao metodo responsavel por ler o numero de parcelas.
		int numberInstallment = reader.readNumberInstallment(sc);
		
		/* Fazemos a chamada ao metodo principal de serviÇo
		 * que vai ser responsavel por fazer toda chamada aos metodos que vão ter como 
		 * funÇão criar as parcelas do contrato
		 */
		service.processContract(contract, numberInstallment);
		
	
		//mostra o resultado...
		showResult(contract);

	}
	
	//Mostra a saida desejada
	//Mostra a data com o valor das parcelas.
	public static void showResult(Contract contract) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Parcelas: ");
		List<Installment> installments = contract.getInstallments();
		
		for(Installment i: installments) {
			System.out.println(fmt.format(i.getDueDate()) + String.format(" - %.2f", i.getAmount()));
		}
	}

}
