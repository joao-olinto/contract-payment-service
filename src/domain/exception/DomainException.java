package domain.exception;

//Classe para  poderemos lançar e instanciar  
public class DomainException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//construtor faz uma chamada ao construtor da superClasse RuntimeException
	//Passa como parametro uma messagem de erro
	public DomainException(String message) {
		super(message);
		
	}
	
	
}

