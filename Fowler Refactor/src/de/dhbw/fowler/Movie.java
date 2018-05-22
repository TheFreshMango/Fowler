package de.dhbw.fowler;
public class Movie {

	private PriceCode priceCode;

	private String title;

	public Movie(String newtitle, PriceCode newpriceCode) {
		title = newtitle;
		priceCode = newpriceCode;
	}

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public double getAmount(int daysRented) {
		return priceCode.getAmount(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return priceCode.getFrequentRenterPoints(daysRented);
	}

	
}