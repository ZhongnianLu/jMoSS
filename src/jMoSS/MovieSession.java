package jMoSS;

import java.util.ArrayList;

public class MovieSession {
	
	private String movieName;
	private String date;
	private String time;
	private int seats;
	private int maximumSeats;
	private ArrayList<Customer> customers;

	public MovieSession(String name, String date, String time,
			            int maximumSeats, Theatre location) {
		
		movieName = name;
		this.date = date;
		this.time = time;
		this.maximumSeats = maximumSeats;
		location.addMovieSession(this);
	}

	
	public void addBooking(Customer customer) throws SessionMaxException, CustomerRepeatException{
		
		boolean enoughSeats = false;
		
		if((seats + 1) < maximumSeats) {
			enoughSeats = true;
		}else {
			throw new SessionMaxException("Seats are full. Booking failed.");
		}
		
		if(customerRepeat(customer) == false && enoughSeats == true) {
			customers.add(customer);
			seats++;
		}else {
			throw new CustomerRepeatException("Customer can't booking two tickets. Booking failed.");
		}
		
		
	}
	
	
	
	
	private boolean customerRepeat(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}


	public String getMovieName() {

		return movieName;
	}
	
	public String getTime() {

		return time;
	}

	public String getDate() {
		
		return date;
	}

	public int getSeats() {

		return seats;
	}
	
	public int getMax() {
		
		return maximumSeats;
	}
	
	public ArrayList<Customer> getBookingRecords(){
		
		return customers;
	}
	
	
}
