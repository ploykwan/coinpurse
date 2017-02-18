package coinpurse;

public class BankNote implements Valuable {
	private static long nextSerialNumber = 1000000;
	private String currency = "Baht";
	private long serialNumber;
	private double value;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 */
	public BankNote(double value) {
		this.value = value;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(String currency, double value) {
		this.currency = currency;
		this.value = value;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}

	/**
	 * 
	 * @return the value of the banknote.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * 
	 * @return the currancy of the banknote.
	 */
	public String getCurrency() {

		return this.currency;
	}

	/**
	 * 
	 * @return the serialnumber of the banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Chack that two banknotes are the same currency or not.
	 * 
	 * @param obj
	 *            is the object of the banknote.
	 * @return true if the two banknotes are the same currency, false for other
	 *         way.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (other.value == this.value
				&& other.currency.equalsIgnoreCase(this.currency))
			return true;
		return false;
	}

	/**
	 * Return a String describing what is in the purse.
	 */
	public String toString() {
		return this.value + "-currency note [" + this.serialNumber + "]";
	}
}
