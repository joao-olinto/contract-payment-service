package domain.service;

import java.time.LocalDate;

import domain.entities.Contract;
import domain.entities.Installment;

public class ContractService {

	
	//Metodo para processar o contrato, gerando as parcelas do mesmo
	public void processContract(Contract contract, int months) {
		
		//Aqui instanciamos a classe responsavel pelo pagament online
		OnlinePaymentService onlinePay =  new PayPalService();
		
		//Variavel que representa o valor da parcela base
		double installmentValue = 0.0;
		for(int i = 0; i < months; i++) {
			
			//Dividimos o valor pela quantidade de parcelas/meses
			installmentValue = contract.getTotalValue() / months;
			//chamada ao metodo responsavel por calcular o juros simples
			installmentValue = onlinePay.interest(contract.getTotalValue(), i);
			//Adiciona a taxa de 2%
			installmentValue += onlinePay.paymentFee(installmentValue);
			//adiciona a quantidade de mes com base no valor de i 
			LocalDate dueDate = contract.getDate().plusMonths(i);
			//Instancia e adiciona a lista de parcelas
			contract.addInstallment(new Installment(dueDate,installmentValue));
		}
	}


}
