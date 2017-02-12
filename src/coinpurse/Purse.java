package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	List<Coin> money = new ArrayList<Coin>();
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {

		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
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
	 * Return the capacity of the coin purse.
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
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		if (isFull())
			return false;
		if (coin.getValue() <= 0)
			return false;
		else {
			money.add(coin);
		}
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		if (amount <= 0 && amount > getBalance()) {
			return null;
		}
		/*
		 * See lab sheet for outline of a solution, or devise your own solution.
		 */
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		List<Coin> withdraws = new ArrayList<Coin>();
		// failed. Don't change the contents of the purse.
		Collections.sort(money);
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
		Coin[] out = new Coin[withdraws.size()];
		withdraws.toArray(out);
		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return out;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return getCapacity() + "coins with value " + getBalance();
	}

}
