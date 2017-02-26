package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Kwankaew Uttama
 */
public class Purse {
	/** Collection of objects in the purse. */

	List<Valuable> money = new ArrayList<Valuable>();
	/**
	 * Capacity is maximum number of valuable the purse can hold. Capacity is
	 * set when the purse is created and cannot be changed.
	 */
	private int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuable you can put in purse.
	 */
	public Purse(int capacity) {

		this.capacity = capacity;
	}

	/**
	 * Count and return the number of valuable in the purse. This is the number
	 * of coins and banknotes, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (int i = 0; i < count(); i++) {
			sum = sum + money.get(i).getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */

	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {

		if (count() >= getCapacity())
			return true;
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable valua) {
		// if the purse is already full then can't insert anything.
		if (isFull())
			return false;
		if (valua.getValue() <= 0)
			return false;
		else {
			money.add(valua);
		}
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount <= 0 && amount > getBalance()) {
			return null;
		}
		List<Valuable> withdraws = new ArrayList<Valuable>();
		Collections.sort(money, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable arg0, Valuable arg1) {
				return (int) Math.signum(arg1.getValue() - arg0.getValue());
			}
		});

		for (int i = 0; i < money.size(); i++) {
			if (money.get(i).getValue() <= amount) {
				amount = amount - money.get(i).getValue();
				withdraws.add(money.get(i));
				money.remove(i);
				i--;
			}
		}
		if (amount > 0) {
			money.addAll(withdraws);
			return null;
		}
		Valuable[] out = new Valuable[withdraws.size()];
		withdraws.toArray(out);
		return out;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return count() + " money with value " + getBalance();
	}

}
