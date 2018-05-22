package de.dhbw.fowler;

public 	enum PriceCode {
	
	CHILDRENS(){
		@Override
		public double getAmount() {
			return super.getAmount();
		}
	},
	
	REGULAR() {
		@Override
		public double getAmount() {
			return super.getAmount();
		}
	},
	
	NEW_RELEASE() {
		@Override
		public double getAmount() {
			return super.getAmount();
		}
	};
	
	PriceCode() {}
	
	public double getAmount() {
		return 0;
	}
}
