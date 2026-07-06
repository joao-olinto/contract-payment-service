package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import domain.entities.Contract;

public class ReaderAndCreateContract {

	//Metodo responsavel por ler e criar uma entidade do tipo contrato
	public Contract addContract(Scanner sc){
		
		//Fomtador de data no formato (dia/mes/ano)
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//Leitura dos dados
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		String number = sc.next();
		System.out.print("Data (dd/MM/yyyy): ");
		
		sc.nextLine();
		//passamos uma string para LocalDate utilizando o formatador
		LocalDate dateContract = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Valor do contrato: ");
		double totalValueContract = sc.nextDouble();
		
		//retornamos o objeto Contract
		return new Contract(number, dateContract , totalValueContract);
	}

}
