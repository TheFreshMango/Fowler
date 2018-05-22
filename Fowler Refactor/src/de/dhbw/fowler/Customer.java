package de.dhbw.fowler;

import java.util.ArrayList;

public class Customer {

	private String name;
	private ArrayList<Rental> rentals = new ArrayList<>();
	private StringBuilder builder;

	public Customer(String newname) {
		name = newname;
		
		builder = new StringBuilder();
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
		
		double totalRentalAmount = 0;
		int frequentRenterPoints = 0;
		
		builder.setLength(0); // resets the builder
		
		builder.append("Rental Record for " + this.getName() + "\n");
		builder.append("\tTitle\t\tDays\tAmount\n");

		double thisAmount = 0;
		
		for (Rental rental : rentals) {
			
			// determine amounts for each line
			thisAmount = rental.getAmount();
			
			// add frequent renter points
			frequentRenterPoints += rental.getFrequentRenterPoints();
			
			// show figures for this rental
			builder.append(String.format("\t%s\t\t%d\t%s\n", 
					rental.getMovie().getTitle(), rental.getDaysRented(), String.valueOf(thisAmount)));
			
			totalRentalAmount += thisAmount;
		}
		
		// add footer lines
		builder.append("Amount owed is " + String.valueOf(totalRentalAmount) + "\n");
		builder.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		
		return builder.toString();
	}

}