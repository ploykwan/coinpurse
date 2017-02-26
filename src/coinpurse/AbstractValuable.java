package coinpurse;

public abstract class AbstractValuable implements Valuable {
	private double value;
	private String currency;

	public AbstractValuable(double value) {
		this.value = value;
	}

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public int compareTo(Valuable value) {
		if (value == null)
			return -1;
		return (int) Math.signum(value.getValue() - this.getValue());
	}

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

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.currency;
	}
}
