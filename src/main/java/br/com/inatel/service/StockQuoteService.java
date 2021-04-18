package br.com.inatel.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inatel.model.Quote;
import br.com.inatel.model.Stock;
import br.com.inatel.repository.StockQuoteMemoryRepository;

@Service
public class StockQuoteService {

	
	StockQuoteMemoryRepository stockQuoteMemoryRepository = new StockQuoteMemoryRepository();
	
	
	
	public void saveStockQuote(Stock stock) {
		stockQuoteMemoryRepository.save(stock);
	}
	
	public Iterable<Stock> getStockQuoteHistory() {
		return stockQuoteMemoryRepository.findAll();
	}
	
	public Quote[] getStockQuote(String id) {
		return stockQuoteMemoryRepository.findById(id);
	}
	
}
