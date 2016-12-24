package tradeLog;

import tradeLogEnums.State;
import tradeLogEnums.Strategy;

/*
 * ALL THE TRADES FOR A SPECIFIC OPTION OR STOCK (TICKER)
 */

public class Position extends Trades{
	
	private Strategy strategy;
	private String symbol;
	private int quantity;
	private State state;

	public Position(Trade trade) {
		super();
		trades.add(trade);
		symbol = trade.getSymbol();
		quantity = trade.getQuantity();
		state = State.OPEN;
	}

	public boolean add(Trade trade) {
		// Search for a duplicate
		for (Trade t: trades) {
			if (trade.equals(t))
				return false;
		}
		trades.add(trade);
		quantity += trade.getQuantity();
		if (quantity == 0)
			state = State.CLOSE;
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
		return trades.size();
	}
}
