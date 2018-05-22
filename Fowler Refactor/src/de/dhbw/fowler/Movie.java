package de.dhbw.fowler;
public class Movie {

	PriceCode priceCode;

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
}