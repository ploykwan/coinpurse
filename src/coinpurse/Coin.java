package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Kwankaew Uttama
 */

public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency = "Baht";

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * 
	 * @return the value of the coin.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * 
	 * @return the currancy of the coin.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Chack that two coins are the same currency or not.
	 * 
	 * @param obj
	 *            is the object of the coin.
	 * @return true if the two coins are the same currency, false for other way.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		if (other.value == this.value
				&& other.currency.equalsIgnoreCase(this.currency)) {
			return true;
		}
		return false;
	}

	/**
	 * Compare the value of coins.
	 * 
	 * @param c
	 *            is object of coins.
	 * @return -1 if the first coin's currency is come first, 0 if they are
	 *         equal, 1 if the second coin's currency is come first.
	 */
	public int compareTo(Coin c) {
		if (c == null)
			return -1;
		return (int) Math.signum(c.getValue() - this.getValue());
	}

	/**
	 * Return a String describing what is in the purse.
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}
}
