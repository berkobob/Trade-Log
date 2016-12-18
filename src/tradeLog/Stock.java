package tradeLog;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * ALL THE POSITIONS FOR A SPECIFIC STOCK!
 */

public class Stock {

	Map<String, Position> positions;
	String stock;
	
	public Stock(Trade trade) {
		positions = new TreeMap<String, Position>();
		stock = trade.getStock();
		positions.put(trade.getSymbol(), new Position(trade));
	}
	
	public boolean add(Trade trade) {
		if (positions.containsKey(trade.getSymbol())) {
			if (!positions.get(trade.getSymbol()).add(trade))
				return false;
		}
		else 
			positions.put(trade.getSymbol(), new Position(trade));
		return true;
	}
	
	public String toString(){
		
		String string = "";
		for (String position: positions.keySet())
			string += "Here are the " + positions.get(position).getCount() + " positions for " + positions.get(position).getCount() 
			+ " trades for: " + position + ". Qty = " + positions.get(position).getQuantity() 
			+ "\n" + positions.get(position);
		return string;
	}

	public Set<String> getPositions() {
		return positions.keySet();
	}
	
	public ArrayList<Trade> getTrades() {
		ArrayList<Trade> trades = new ArrayList<Trade>();
		
		for (String position: positions.keySet()) {
			trades.addAll(positions.get(position).getTrades());
		}
		
		return trades;
	}

	public boolean has(String symbol) {
		if (positions.containsKey(symbol))
			return true;
		else
			return false;
	}

	public ArrayList<Trade> getTrades(String symbol) {
		return positions.get(symbol).getTrades();
	}

}
