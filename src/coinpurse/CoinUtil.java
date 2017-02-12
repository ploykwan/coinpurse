package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This methods for flitered the coins that have the same currency , sort the
 * coins by currency and sum the coins that have the same currency.
 * 
 * @author Kwankaew Uttama
 *
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Coin> filterByCurrency(final List<Coin> coinlist,
			String currency) {
		List<Coin> filtered = new ArrayList<>();
		for (Coin coin : coinlist) {
			if (coin.getCurrency().equalsIgnoreCase(currency))
				filtered.add(coin);
		}
		return filtered; // return a list of coin references copied from
							// coinlist
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 */
	public static void sortByCurrency(List<Coin> coins) {
		coins.sort(new CompareByCurrency());
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sum.
	 */
	public static void sumByCurrency(List<Coin> coins) {
		sortByCurrency(coins);
		double sum = 0.0;
		for (int i = 0; i < coins.size() - 1; i++) {
			if ((coins.get(i).getCurrency().equalsIgnoreCase(coins.get(i + 1)
					.getCurrency()))) {
				sum += coins.get(i).getValue();
			} else {
				sum += coins.get(i).getValue();
				System.out.println(sum + " " + coins.get(i).getCurrency());
				sum = 0.0;
			}
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Coin> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Coin> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Coin> makeInternationalCoins() {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Coin> makeCoins(String currency, double... values) {
		List<Coin> list = new ArrayList<Coin>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}

class CompareByCurrency implements Comparator<Coin> {
	/**
	 * @param o1
	 *            is the first coin to compare.
	 * @param o2
	 *            is the second coin to compare.
	 * @return -1 if the first coin's currency is come first, 0 if they are
	 *         equal, 1 if the second coin's currency is come first.
	 */
	@Override
	public int compare(Coin o1, Coin o2) {
		return o1.getCurrency().compareTo(o2.getCurrency());
	}
}
