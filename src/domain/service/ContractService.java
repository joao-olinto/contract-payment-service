package domain.service;

import java.time.LocalDate;
import java.util.List;

import domain.entities.Contract;
import domain.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePay;
	
	
	public ContractService(OnlinePaymentService onlinePay) {
		this.onlinePay = onlinePay;
	}
	
	
	//Metodo para processar o contrato, gerando as parcelas do mesmo
	public void processContract(Contract contract, int months) {
				
		//Variavel que representa o valor da parcela base
		double installmentValue = 0.0;
		for(int i = 0; i < months; i++) {
			
			//Dividimos o valor pela quantidade de parcelas/meses
			installmentValue = contract.getTotalValue() / months;
			//chamada ao metodo responsavel por calcular o juros simples
			installmentValue += onlinePay.interest(installmentValue, i + 1);
			//Adiciona a taxa de 2%
			installmentValue += onlinePay.paymentFee(installmentValue);
			//adiciona a quantidade de mes com base no valor de i 
			LocalDate dueDate = contract.getDate().plusMonths(i+1);
			//Instancia e adiciona a lista de parcelas
			contract.addInstallment(new Installment(dueDate,installmentValue));
		}
	}
	
	public List<Installment> getInstallments(Contract contract){
		
		List<Installment> installments = contract.getInstallments();
		return installments;
	}


}
