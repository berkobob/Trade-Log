package tradeLog;

import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.IOException;

public class NewTrades extends Trades{
	
	public NewTrades(String fileName) {

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
}
