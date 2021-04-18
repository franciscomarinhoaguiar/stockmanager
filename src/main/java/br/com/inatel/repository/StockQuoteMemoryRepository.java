package br.com.inatel.repository;

import java.util.ArrayList;

import br.com.inatel.model.Quote;
import br.com.inatel.model.Stock;

public class StockQuoteMemoryRepository {
	private ArrayList<Stock> list = new ArrayList<Stock>();
	
	public StockQuoteMemoryRepository() {
	
	}
	
	
	public void save(Stock stock) {
		int index = findStockById(stock.getId());
		if (index>=0 ) {
			list.get(index).setQuotes(stock.getQuotes());
		}else {
			list.add(stock);
		}
		   
	}
	
	public ArrayList<Stock> findAll() {
		return list;
	}
	
	public int findStockById(String id) {
		for (int i = 0; i < list.size(); i++) {
			 if (list.get(i).getId().equals(id)) {
				 return i;
			 }
		}
		return -1;
	}
	
	public Quote[] findById(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return list.get(i).getQuotes();
			}
			
		}
		return null;
	}
	
	
	

}
