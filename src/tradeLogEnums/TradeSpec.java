package tradeLogEnums;

public enum TradeSpec {
	TRADEDATE   (0),
	QUANTITY    (1),
	SYMBOL      (2),
	EXPIRY      (3),
	STRIKE      (4),
	ASSET       (5),
	PRICE       (6),
	PROCEEDS    (7),
	COMMISSION  (8),
	NETCASH     (9),
	STATE      (10),  //Open or Close
	MULTIPLIER (11),
	NOTES      (12),
	STOCK      (13);
	
	public int key;
	
	TradeSpec(int key){
		this.key = key;
	}
	
	public int key() {
		return key;
	}
}
