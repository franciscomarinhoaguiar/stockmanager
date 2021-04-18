package br.com.inatel.controllers;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.StockquotemanagerApplication;
import br.com.inatel.exceptions.InvalidStockReferenceException;
import br.com.inatel.model.Quote;
import br.com.inatel.model.Stock;
import br.com.inatel.service.StockQuoteService;

@RestController
public class StockQuoteManagerController {
	
	
	StockQuoteService stockQuoteService = new StockQuoteService();
	
	
	@PostMapping("/quote")
	public Stock createTransaction(@RequestBody Stock stock) {
		System.out.println("stock:"+ stock.getId());
		Quote[] array = stock.getQuotes();
		for (int i = 0; i < array.length; i++) {
			System.out.println("stock-date:"+ array[i].getDate());	
			System.out.println("stock-price:"+ array[i].getPrice());	
			
		}
		if (StockquotemanagerApplication.mapStocks.containsKey(stock.getId())) {
			stockQuoteService.saveStockQuote(stock);
		}else {
			throw new InvalidStockReferenceException("Invalid Stock Id");
		}
		
		return stock;
	}
	
	@GetMapping("/quote")
	public Iterable<Stock> viewAllQuotes() {
		System.out.println("listall");
		Iterable<Stock> values = stockQuoteService.getStockQuoteHistory();
		System.out.println("values:"+ values);
		return values;
	}
	
	@GetMapping("/quote/{id}")
	public Quote[] getQuoteById(@PathVariable ("id") String id) {
		 Quote[] quotes = stockQuoteService.getStockQuote(id);
		if(quotes!=null) {
			return quotes;
		}
		
		throw new InvalidStockReferenceException("Invalid Stock Id - Find quotes");
	}

	
	
}
