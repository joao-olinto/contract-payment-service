package domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.exception.DomainException;

//Classe que representa o contrato
public class Contract {

	private String number;
	private LocalDate date;
	private double totalValue;
	private List<Installment> installments = new ArrayList<>();

	// Construtor
	public Contract(String number, LocalDate date, Installment installment) {

		// Aplicando terminadas regras de negocio
		// O numero do pedido deve conter somente digitos numericos(4 digitos
		// especificamente)
		if (!number.trim().matches("^[\\d{4}$")) {
			throw new DomainException("Domain error: The contract number can only contain 4 numeric digits.");
		}

		// O valor total do contrato não pode ser inferior a zero
		if (totalValue < 0.0) {
			throw new DomainException("Domain error: the total value cannot be less than zero");
		}

		// A data de criação do contrato não pode ser posterior a atual
		if (date.isAfter(LocalDate.now())) {
			throw new DomainException(
					"Domain error: The date of signature of this contract cannot be earlier than the current date.");
		}
		this.number = number;
		this.date = date;
	}

	// getters e setters
	// Aplicamos as validações
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if (!number.trim().matches("^[\\d{4}$")) {
			throw new DomainException("Domain error: The contract number can only contain 4 numeric digits.");
		}

		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		if (date.isAfter(LocalDate.now())) {
			throw new DomainException(
					"Domain error: The date of signature of this contract cannot be earlier than the current date.");
		}

		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {

		if (totalValue < 0.0) {
			throw new DomainException("Domain error: the total value cannot be less than zero");
		}

		this.totalValue = totalValue;
	}
	
	
	//Metodo responsavel por adicionar as parcelas ao contrato
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}

}
