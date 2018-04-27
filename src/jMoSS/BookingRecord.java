package jMoSS;

public class BookingRecord {
	
	private MovieSession session;
	private Customer customer;
	
	public BookingRecord(MovieSession session, Customer customer) {
		
		this.session = session;
		this.customer = customer;
		
	}

}
