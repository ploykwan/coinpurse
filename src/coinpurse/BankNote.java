package coinpurse;

public class BankNote extends AbstractValuable {
	private String currency;
	private double value;
	private long serialNumber;
	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 */
	public BankNote(double value) {
		super(value);
	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value,String currency) {
		super(value,currency);
	}
	public long getSerialNumber(){
//		this.serialNumber = ThaiMoneyFactory.serialNumber;
		return this.serialNumber;
	}
	/**
	 * Return a String describing what is in the purse.
	 */
	public String toString() {
		return super.getValue() + "-"+super.getCurrency()+" note";
	}
}
