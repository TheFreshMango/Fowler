package de.dhbw.fowler;

import java.lang.*;
import java.util.*;

public class Customer {

	private String name;
	private ArrayList<Rental> rentals = new ArrayList<>();

	public Customer(String newname) {
		name = newname;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}
	
	public void removeRental(Rental rental) {
		rentals.remove(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		for (Rental rental : rentals) {
			
			double thisAmount = 0;
			
			// determine amounts for each line
			thisAmount = amountFor(rental);
			
			// add frequent renter points
			frequentRenterPoints += rental.getMovie().getPriceCode().getFrequentRenterPoints(rental.getDaysRented());
			
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private double amountFor(Rental rental) {
		return rental.getMovie()
				.getPriceCode()
				.getAmount(rental.getDaysRented());
	}

}