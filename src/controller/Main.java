package controller;

import java.util.Set;

import tradeLog.Trade;
import tradeLog.TradeLog;
import tradeLog.Trades;

public class Main {

	public static void main(String[] args) {
		TradeLog log = new TradeLog();
		Trades trades = new Trades("test.csv");
		
		
		System.out.println("HERE ARE THE TRADES WE'RE IMPORTING");
		System.out.println("-----------------------------------");
		int i = 0;
		for (Trade trade: trades){
			System.out.println(trade);
			i++;
		}
		System.out.println(i + " trades\n");
		
		
		System.out.println("HERE ARE THE TRADES WE'RE ADDING OR ARE DUPLICATES");
		System.out.println("--------------------------------------------------");
		int in=0, out = 0;
		for (Trade trade: trades) {
			if (log.add(trade)) {
				System.out.println("ADDED: " + trade);
				in += 1;
			}
			else {
				System.out.println("DUPLI: " + trade);
				out += 1;
			}
		}
		System.out.println(in + " added\t" + out + " are duplicates.\n");
		
		System.out.println("HERE ARE THE STOCKS WE'RE TRADING");
		System.out.println("---------------------------------");

		System.out.println(log.getStocks().toString() + "\n");
		
		System.out.println("HERE ARE THE POSITIONS WE'RE HOLDING");
		System.out.println("------------------------------------");
		
		for (Set<String> positions: log.getPositions()) {
			System.out.println(positions);
		}
		
		System.out.println();
		System.out.println("HERE ARE THE TRADES AGAIN");
		System.out.println("-------------------------");

		System.out.println(log.getTrades());
		
		int i1=0;
		for (Trade trade: log.getTrades()){
			System.out.println(trade);
			i1++;
		}
		System.out.println(i1 + " trades" + "\n");
		
		System.out.println("HERE'S THE BIG BREAKDOWN");
		System.out.println("------------------------");
		
		for (String stock: log.getStocks()) {
			System.out.println("Here are the positions for " + stock);
			for (String position: log.getPositions(stock)) {
				System.out.println("Here are the trades for " + position);
				for (Trade trade: log.getTrades(position)) {
					System.out.println(trade);
				}
			}
		}
	}
}
