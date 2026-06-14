package domain.entities;

import java.time.LocalDate;
import domain.exception.DomainException;

//Classe que tem como função representar uma parcela, possuindo  valor e data.
public class Installment {

	private LocalDate dueDate;
	private double amount;

	// Construtor onde aplicamos a injeção de dependencia
	public Installment(LocalDate dueDate, double amount) {

		if (amount < 0.0) {
			throw new DomainException("Domain error: ");
		}

		this.dueDate = dueDate;
		this.amount = amount;

	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getAmount() {

		return amount;
	}

	public void setAmount(double amount) {
		if (amount < 0.0) {
			throw new DomainException("Domain error: ");
		}

		this.amount = amount;
	}

}
