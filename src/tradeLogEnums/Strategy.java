package tradeLogEnums;

public enum Strategy {
	NAKED_PUT         ("Naked Put"),
	NAKED_CALL        ("Naked Call"),
	COVERED_PUT       ("Covered Putt"),
	COVERED_CALL      ("Covered Call"),
	CALL_SPREAD       ("Call Spread"),
	PUT_SPREAD        ("Put Spread"),
	SYNTHETIC_LONG    ("Synthetic Long"),
	SYNTHETIC_SHORT   ("Synthetic Short"),
	STRADDLE          ("Straddle"),
	STRANGLE          ("Strangle"),
	LONG_STOCK        ("Long Stock"),
	SHORT_STOCK       ("Short Stock"),
	LONG_PUT          ("Long Put"),
	SHORT_PUT         ("Short Put"),
	LONG_CALL         ("Long Call"),
	SHORT_CALL        ("Short Call"),
	CALENDAR_SPREAD   ("Calendar Spread");
	
	String string;
	
	Strategy(String string) {
		this.string = string;
	}
	
	@Override
	  public String toString() {
		return string;
	}
}
