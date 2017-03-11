package coinpurse;
/**
 * 
 * @author Kwankaew Uttama
 */
public abstract class AbstractValuable implements Valuable {
	/** Value of the money. */
	private double value;
	/** The currency of the money. */
	private String currency;
	
	/**
	 * Initialize the constructor.
	 * @param value of the money.
	 */
	public AbstractValuable(double value) {
		this.value = value;
	}
	
	/**
	 * nitialize the constructor.
	 * @param value of the money.
	 * @param currency of the money.
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	/**
	 * Compare the value of money.
	 * 
	 * @param value
	 *            is object of moneys.
	 * @return -1 if the first money's currency is come first, 0 if they are
	 *         equal, 1 if the second money's currency is come first.
	 */
	public int compareTo(Valuable value) {
		if (value == null)
			return -1;
		return (int) Math.signum(value.getValue() - this.getValue());
	}
	
	/**
	 * Chack that two moneys are the same currency or not.
	 * 
	 * @param obj
	 *            is the object of the money.
	 * @return true if the two moneys are the same currency, false for other way.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		AbstractValuable other = (AbstractValuable) obj;
		if (this.value == other.value && this.currency == other.currency)
			return true;
		return false;
	}
	
	/**
	 * @return the value of money.
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * @return the currency of money.
	 */
	public String getCurrency() {
		return this.currency;
	}
}
