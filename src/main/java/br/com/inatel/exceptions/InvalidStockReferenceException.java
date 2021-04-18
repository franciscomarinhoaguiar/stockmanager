package br.com.inatel.exceptions;



public class InvalidStockReferenceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public InvalidStockReferenceException(String error) {
		super(error);
	}

}
