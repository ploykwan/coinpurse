package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	private Valuable money;

	@Override
	public Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) {
			money = new Coin(value, "Sen");
		} else if (value == 1 || value == 2 || value == 5 || value == 10
				|| value == 20 || value == 50 || value == 100) {
			money = new BankNote(value, " Ringgit ");
		} else {
			throw new IllegalArgumentException();
		}
		return money;
	}

}
