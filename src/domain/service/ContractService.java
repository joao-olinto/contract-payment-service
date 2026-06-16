package domain.service;

import java.time.LocalDate;

import domain.entities.Contract;
import domain.entities.Installment;

public class ContractService {

	
	//Metodo para processar o contrato, gerando as parcelas do mesmo
	public void processContract(Contract contract, int months) {
		//Aqui instanciamos a classe responsavel pelo pagament online
		OnlinePaymentService onlinePay =  new PayPalService();
		
		double installmentValue = 0.0;
		for(int i = 0; i < months; i++) {
			
			installmentValue = onlinePay.interest(contract.getTotalValue(), i);
			installmentValue += onlinePay.paymentFee(installmentValue);
			LocalDate dueDate = contract.getDate().plusMonths(i);
			contract.addInstallment(new Installment(dueDate,installmentValue));
		}
	}


}
