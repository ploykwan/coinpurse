package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Kwankaew Uttama
 */

public class Coin extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		super(value);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	/**
	 * Return a String describing what is in the purse.
	 */
	public String toString() {
		String currency = super.getCurrency();
		double value = super.getValue();
		if( super.getCurrency().equals("Bath") && super.getValue() < 1){
			currency = "Satang";
			value = value * 100 ;
		}
		if( super.getCurrency().equals("Ringgit") && super.getValue() < 1){
			currency = "Sen";
			value = value * 100 ;
		}
		return value + "-" + currency+" note";
	}
}
