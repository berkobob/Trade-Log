package tradeLog;

import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Trades implements Iterable<Trade>{
	
	ArrayList<Trade> trades;
	
	public Trades() {
		trades = new ArrayList<Trade>();
	}

	public Trades(String fileName) {
		
		trades = new ArrayList<Trade>();

		String line = null;
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			
			line = file.readLine();
			
			while ((line = file.readLine()) != null) {
				Trade trade = new Trade(line);
				trades.add(trade);
			}
			
			file.close();
			
		} catch (IOException e) {
			System.err.println("Unable to read the file");
		}	
	}

	@Override
	public Iterator<Trade> iterator() {
		return trades.iterator();
	}
	
}
