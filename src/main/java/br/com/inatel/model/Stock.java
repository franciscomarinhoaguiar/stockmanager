package br.com.inatel.model;

public class Stock {
	private String id;
	private Quote[] quotes;

	
	public String getId() {
		return id;
	}
	public void setId(String stockId) {
		this.id = stockId;
	}
	public Quote[] getQuotes() {
		return quotes;
	}
	public void setQuotes(Quote[] quotes) {
		this.quotes = quotes;
	}
	

}
