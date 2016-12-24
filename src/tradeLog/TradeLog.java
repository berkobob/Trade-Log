package tradeLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * A LIST OF STOCKS BEING TRADED!
 */

public class TradeLog {

	private Map<String, Stock> stocks;
	
	public TradeLog() {
		stocks = new TreeMap<String, Stock>();
	}

	public boolean add(Trade trade){
		if (stocks.containsKey(trade.getStock())) {
			if(!stocks.get(trade.getStock()).add(trade))
				return false;
		}
		else 
			stocks.put(trade.getStock(), new Stock(trade));
		return true;
	}

	public Set<String> getStocks() {
		return stocks.keySet();
	}
	
	public Set<String> getPositions(String s) {
		return stocks.get(s).getPositions();
	}
	
	public ArrayList<Set<String>> getPositions() {
		
		ArrayList<Set<String>> pos = new ArrayList<Set<String>>();
		
		for (String stock: stocks.keySet()){
			pos.add(stocks.get(stock).getPositions());
		}
		
		return pos;
		
	}

	public ArrayList<Trade> getTrades() {
		ArrayList<Trade> trades = new ArrayList<Trade>();
		
		for(String stock: stocks.keySet()){
			trades.addAll(stocks.get(stock).getTrades());
		}
		
		return trades;
	}
	
	public List<Trade> getTrades(String symbol) {
		
		for (String stock: stocks.keySet()) {
			if (stocks.get(stock).has(symbol))
				return stocks.get(stock).getTrades(symbol);
		}
		
		return null;
	}
}
