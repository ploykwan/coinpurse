package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {
	private Valuable money;

	@Override
	public Valuable createMoney(double value) {
		if (value == 20 || value == 50 || value == 100 || value == 500
				|| value == 1000) {
			money = new BankNote(value, "Bath");

		} else if (value == 1 || value == 2 || value == 5 || value == 10) {
			money = new Coin(value, "Bath");
		} else {
			throw new IllegalArgumentException();
		}
		return money;
	}
}
