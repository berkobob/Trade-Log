package tradeLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import tradeLogEnums.Asset;
import tradeLogEnums.Notes;
import tradeLogEnums.State;
import tradeLogEnums.TradeSpec;

public class Trade {

		private Map<TradeSpec, Object> trade;
		
		public Trade(String importedTrade) {
			
			trade = new HashMap<TradeSpec, Object>();
			String[] iTrade = importedTrade.split(",");
		
			// 0. Trade date
			try {
				trade.put(TradeSpec.TRADEDATE, new SimpleDateFormat("yyyyMMdd").parse(iTrade[TradeSpec.TRADEDATE.key]));
			} catch (ParseException e) {
				System.err.println(e.getLocalizedMessage() + "\t" + iTrade[TradeSpec.SYMBOL.key]);
			}
			
			// 1. Quantity
			trade.put(TradeSpec.QUANTITY, Integer.parseInt(iTrade[TradeSpec.QUANTITY.key]));
			
			// 2. Symbol
			trade.put(TradeSpec.SYMBOL, iTrade[TradeSpec.SYMBOL.key]);
			trade.put(TradeSpec.STOCK, calcSymbol(iTrade[TradeSpec.SYMBOL.key]));
			
			// 3. Expiry
			try {
				trade.put(TradeSpec.EXPIRY, new SimpleDateFormat("dd/MM/yyyy").parse(iTrade[TradeSpec.EXPIRY.key]));
			} catch (Exception e) {
				//trade.put(null);
			}
			
			// 4. Strike
			try {
				trade.put(TradeSpec.STRIKE, Double.parseDouble(iTrade[TradeSpec.STRIKE.key]));
			} catch (Exception e){
				//trade.put(null);
			}
			
			// 5. Asset class 
			switch (iTrade[TradeSpec.ASSET.key]) {
			case "P": trade.put(TradeSpec.ASSET, Asset.PUT);  break;
			case "C": trade.put(TradeSpec.ASSET, Asset.CALL); break;
			default:  trade.put(TradeSpec.ASSET, Asset.STOCK);
			}
			
			// 6. Price
			trade.put(TradeSpec.PRICE, Double.parseDouble(iTrade[TradeSpec.PRICE.key]));
			
			// 7. Proceeds
			trade.put(TradeSpec.PROCEEDS, Double.parseDouble(iTrade[TradeSpec.PROCEEDS.key]));
			
			 // 8. Commission
			trade.put(TradeSpec.COMMISSION, Double.parseDouble(iTrade[TradeSpec.COMMISSION.key]));
			
			 // 9. Net Cash
			trade.put(TradeSpec.NETCASH, Double.parseDouble(iTrade[TradeSpec.NETCASH.key]));
			
			 //10. Open or Close
			switch(iTrade[TradeSpec.STATE.key]) {
			case "O": trade.put(TradeSpec.STATE, State.OPEN);  break;
			case "C": trade.put(TradeSpec.STATE, State.CLOSE); break;
			default: throw new IllegalArgumentException("A trade must be either open or close");
			}
			
			// 11. Multiplier
			trade.put(TradeSpec.MULTIPLIER, Integer.parseInt(iTrade[TradeSpec.MULTIPLIER.key]));
			
			// 12. Notes
			try{
				switch(iTrade[TradeSpec.NOTES.key]) {
				case "Ep;": trade.put(TradeSpec.NOTES, Notes.EXPIRED);           break;
				case "A;":  trade.put(TradeSpec.NOTES, Notes.ASSIGNED);          break;
				case "Ex;": trade.put(TradeSpec.NOTES, Notes.EXERCISED);         break;
				case "P;":  trade.put(TradeSpec.NOTES, Notes.PARTIAL_EXECUTION); break;
				default:    trade.put(TradeSpec.NOTES, iTrade[TradeSpec.NOTES.key]); 
				}
			}catch (Exception e) {
				//trade.put(" ");
			}
		}
		
		
		/*
		 * PUBLIC METHODS
		 */
		
		public String toString() {
			return trade.toString();
		}
		
		public boolean equals(Trade t) {
			
			if (	trade.get(TradeSpec.TRADEDATE).equals(t.get(TradeSpec.TRADEDATE))    &&
					trade.get(TradeSpec.QUANTITY).equals(t.get(TradeSpec.QUANTITY))      &&
					trade.get(TradeSpec.SYMBOL).equals(t.get(TradeSpec.SYMBOL))          &&
					trade.get(TradeSpec.PRICE).equals(t.get(TradeSpec.PRICE))            &&
					trade.get(TradeSpec.PROCEEDS).equals(t.get(TradeSpec.PROCEEDS))      &&
					trade.get(TradeSpec.COMMISSION).equals(t.get(TradeSpec.COMMISSION))  &&
					trade.get(TradeSpec.NETCASH).equals(t.get(TradeSpec.NETCASH))        &&
					trade.get(TradeSpec.STATE).equals(t.get(TradeSpec.STATE))&&
					trade.get(TradeSpec.MULTIPLIER).equals(t.get(TradeSpec.MULTIPLIER))  &&
				 //(trade.containsKey(TradeSpec.NOTES) && t.contains(TradeSpec.NOTES)    &&
				 // trade.get(TradeSpec.NOTES).equals(t.get(TradeSpec.NOTES)))           &&
				  ((trade.get(TradeSpec.ASSET).equals(Asset.STOCK) && t.get(TradeSpec.ASSET).equals(Asset.STOCK)) ||
				   (trade.get(TradeSpec.ASSET).equals(t.get(TradeSpec.ASSET))   &&
					trade.get(TradeSpec.EXPIRY).equals(t.get(TradeSpec.EXPIRY)) &&
					trade.get(TradeSpec.STRIKE).equals(t.get(TradeSpec.STRIKE))))) 
				return true;
			else
				return false;
		}
		
		public boolean contains(TradeSpec spec) {
			return trade.containsKey(spec);
		}
			
		
		/*
		 * GETTERS AND SETTERS
		 */

		public Object get(TradeSpec spec) {
			return trade.get(spec);
		}
		
		public Asset getAsset() {
			return (Asset)trade.get(TradeSpec.ASSET.key);
		}
		
		public String getSymbol() {
			return (String)trade.get(TradeSpec.SYMBOL);
		}
		
		public String getStock() {
			return (String)trade.get(TradeSpec.STOCK);
		}
		
		public Integer getQuantity() {
			return (Integer)trade.get(TradeSpec.QUANTITY);
		}
		
		public Integer getMultiplier() {
			return (Integer)trade.get(TradeSpec.MULTIPLIER);
		}
		
		/*
		 * PRIVATE METHODS
		 */
		private String calcSymbol(String symbol) {
			if (symbol.contains(" "))
				if (symbol.indexOf(' ') == 5)
					return symbol.substring(0, symbol.indexOf(' ')-1);
				else
					return symbol.substring(0, symbol.indexOf(' '));
			else
				return symbol;
		}
}
