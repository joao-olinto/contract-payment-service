package domain.service;

public class PayPalService implements OnlinePaymentService {
	
	@Override
	//Metodo responsavel por calcular a taxa de 2% do pay Pal
	public double paymentFee(double amount) {
		//retorna o valor da taxa da parcela
		return  amount * 0.02;
	
	}

	@Override
	//Metodo que calcula o juros simples do valor
	public double interest(double amount, int months) {
		
		//Calculamos os juros simples com base n valor de 1%
		double installmentValue =  amount * 0.01 * months; 
		
		return installmentValue;
	}
}
