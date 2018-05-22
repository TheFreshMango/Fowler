package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.dhbw.fowler.Customer;
import de.dhbw.fowler.Movie;
import de.dhbw.fowler.Rental;

@RunWith(JUnit4.class)
public class TestFowler {
	
	@Test
	public void testSomeRentals() {
		
		String customerName = "New Customer Name";
		Customer customer = new Customer(customerName);
		
		assertEquals(customerName, customer.getName());	
		
		
		Movie movie1 = new Movie("Movie 1", Movie.NEW_RELEASE);
		Movie movie2 = new Movie("Movie 2", Movie.REGULAR);
		Movie movie3 = new Movie("Movie 3", Movie.CHILDRENS);
		
		
		Rental rental1 = new Rental(movie1, 7);
		Rental rental2 = new Rental(movie2, 3);
		Rental rental3 = new Rental(movie3, 12);
		
		
		customer.addRental(rental1);
		
		assertEquals("Rental Record for New Customer Name\n" + 
				"	Title		Days	Amount\n" + 
				"	Movie 1		7	21.0\n" + 
				"Amount owed is 21.0\n" + 
				"You earned 2 frequent renter points", customer.statement());
		
		
		
		customer.addRental(rental3);
		
		assertEquals("Rental Record for New Customer Name\n" + 
				"	Title		Days	Amount\n" + 
				"	Movie 1		7	21.0\n" + 
				"	Movie 3		12	15.0\n" +
				"Amount owed is 36.0\n" + 
				"You earned 3 frequent renter points", customer.statement());
		
		
		assertEquals(3, rental2.getDaysRented());
		assertEquals(movie2, rental2.getMovie());
		
		assertEquals(Movie.REGULAR, movie2.getPriceCode());
		assertEquals("Movie 2", movie2.getTitle());
		
		movie2.setPriceCode(5);
		assertEquals(5, movie2.getPriceCode());
				
	}
	
	
	@Test
	public void testAmount() {
		
		Movie movie1 = new Movie("Movie 1", Movie.NEW_RELEASE);
		Movie movie2 = new Movie("Movie 2", Movie.REGULAR);
		Movie movie3 = new Movie("Movie 3", Movie.CHILDRENS);
		
		Rental rental1 = new Rental(movie1, 1);
		Rental rental2 = new Rental(movie2, 1);
		Rental rental3 = new Rental(movie3, 1);
		
		Customer customer1 = new Customer("The one with rental1");
		Customer customer2 = new Customer("The one with rental2");
		Customer customer3 = new Customer("The one with rental3");
		
		customer1.addRental(rental1);
		customer2.addRental(rental2);
		customer3.addRental(rental3);
		
		System.out.println(customer1.statement());
		System.out.println(customer2.statement());
		System.out.println(customer3.statement());
		
		assertEquals("Rental Record for The one with rental1\n" + 
				"	Title		Days	Amount\n" + 
				"	Movie 1		1	3.0\n" + 
				"Amount owed is 3.0\n" + 
				"You earned 1 frequent renter points", customer1.statement());
		
		assertEquals("Rental Record for The one with rental2\n" + 
				"	Title		Days	Amount\n" + 
				"	Movie 2		1	2.0\n" + 
				"Amount owed is 2.0\n" + 
				"You earned 1 frequent renter points", customer2.statement());
		
		assertEquals("Rental Record for The one with rental3\n" + 
				"	Title		Days	Amount\n" + 
				"	Movie 3		1	1.5\n" + 
				"Amount owed is 1.5\n" + 
				"You earned 1 frequent renter points", customer3.statement());
		
		
	}
	
	
	
	
	

}
