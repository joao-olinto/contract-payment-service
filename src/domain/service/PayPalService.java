package domain.service;

public class PayPalService implements OnlinePaymentService {
	
	@Override
	//Metodo responsavel por calcular a taxa de 2% do pay Pal
	public double paymentFee(double amount) {
		double fee = amount * 0.02;
		return  fee;
	
	}

	@Override
	//Metodo que calcula o juros simples do valor
	public double interest(double amount, int months) {
		double installmentValue = amount / months;
		installmentValue += installmentValue * 0.01 * months; 
		return installmentValue;
	}
	
	

}
