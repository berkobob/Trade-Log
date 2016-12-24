package tradeLog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Trades implements Iterable<Trade> {
	
	ArrayList<Trade> trades;

	public Trades() {
		trades = new ArrayList<Trade>();
	}
	
	public Trades(List<Trade> trades) {
		this.trades.addAll(trades);
	}

	public List<Trade> getTrades() {
		return trades;
	}
	
	@Override
	public Iterator<Trade> iterator() {
		return trades.iterator();
	}

}
