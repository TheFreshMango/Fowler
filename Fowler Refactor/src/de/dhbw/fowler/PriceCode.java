package de.dhbw.fowler;

public 	enum PriceCode {
	
	CHILDRENS(){
		@Override
		public double getAmount(int daysRented) {
			
			double amount = 1.5;
			if (daysRented > 3) {
				amount += (daysRented - 3) * 1.5;
			}
			
			return amount;
		}
	},
	
	REGULAR() {
		@Override
		public double getAmount(int daysRented) {
			
			double amount = 2;
			if (daysRented > 2) {
				amount += (daysRented - 2) * 1.5;
			}
			
			return amount;
		}
	},
	
	NEW_RELEASE() {
		@Override
		public double getAmount(int daysRented) {
			double amount = 3;
			
			return amount;
		}
		
		@Override
		public int getFrequentRenterPoints(int daysRented) {

			if(daysRented > 1) {
				return 2;
			}
			return super.getFrequentRenterPoints(daysRented);
		}
	};
	
	PriceCode() {}
	
	public double getAmount(int daysRented) {
		return 0;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
	
}
