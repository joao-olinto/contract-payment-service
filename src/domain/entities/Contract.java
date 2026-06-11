package domain.entities;

import java.time.LocalDate;

//Classe que representa o contrato
public class Contract {

	private int number;
	private LocalDate date;
	private double totalValue;

	// Construtor
	public Contract(int number, LocalDate date, double totalValue) {

		this.number = number;
		this.date = date;
		this.totalValue = totalValue;

	}

	// getters e setters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {

		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {

		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}
