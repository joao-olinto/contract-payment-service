package domain.service;

//Interface responsavel por instabelecer os metodos abstratos.
//Que serão implementados pelas classes concretas
public interface OnlinePaymentService {
	
	//Metodo responsavel por calcular o valor da taxa.
	public double paymentFee(double amount);
	
	//Metodo responsavel por calcular os juros simples, baseados no valor e nos meses.
	public double interest(double amount, int months);
		
	
}
