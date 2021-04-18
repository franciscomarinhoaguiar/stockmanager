package br.com.inatel;

import org.springframework.boot.SpringApplication;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import br.com.inatel.rest.StockApi;

@SpringBootApplication
public class StockquotemanagerApplication {
	public static Map<String,StockApi > mapStocks ;

	public static void main(String[] args) {
		SpringApplication.run(StockquotemanagerApplication.class, args);
		getStocks();
	}
	
	private static void getStocks()
	{
	    final String uri = "http://localhost:8080/stock";
	    final RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<StockApi[]> responseEntity = 
	    	    restTemplate.getForEntity(uri, StockApi[].class); 
	    StockApi[] stocks = responseEntity.getBody();
	    mapStocks = new HashMap<String, StockApi>();
	    for (int i = 0; i < stocks.length; i++) {
	    	 System.out.println(stocks[i].getId());
	    	 System.out.println(stocks[i].getDescription());
	    	 mapStocks.put(stocks[i].getId(),stocks[i]);
	    	 
		}
       
	    
	}

}
