package coinpurse;

import java.util.Arrays;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kwankaew Uttama
 */
public class Main {
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		consoleDialog.run();
	}
}
