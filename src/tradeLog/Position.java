package tradeLog;

import java.util.ArrayList;

import tradeLogEnums.Strategy;

/*
 * ALL THE TRADES FOR A SPECIFIC OPTION OR STOCK (TICKER)
 */

public class Position {
	
	Strategy strategy;
	String symbol;
	int quantity;
	int count;
	
	ArrayList<Trade> trades;

	public Position(Trade trade) {
		trades = new ArrayList<Trade>();
		trades.add(trade);
		symbol = trade.getSymbol();
		quantity = trade.getQuantity();
		count = 1;
	}

	public boolean add(Trade trade) {
		// Should we search for a duplicate?
		for (Trade t: trades) {
			if (trade.equals(t))
				return false;
		}
		trades.add(trade);
		quantity += trade.getQuantity();
		count += 1;
		// Do something special if the quantity is zero !!
		return true;
	}
	
	public String toString() {
		String string = "";
		
		for (Trade trade: trades) {
			string += trade + "\n";
		} 
		
		return string;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getCount() {
		return count;
	}
	
	public ArrayList<Trade> getTrades() {
		return trades;
	}
}
