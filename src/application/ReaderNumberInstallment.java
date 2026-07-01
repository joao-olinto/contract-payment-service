package application;

import java.util.Scanner;

//Metodo que tem como objetivo ler o numero de parcelas
//Vamos evitar strings vazias no metodo main
public class ReaderNumberInstallment {
	
	public int readNumberInstallment(Scanner sc) {
		
		System.out.print("Entre com o numero de parcelas: ");
		int numberInstallment = sc.nextInt();
		
		return numberInstallment;
	}
	
	
	
}
