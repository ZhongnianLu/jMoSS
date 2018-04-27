package jMoSS;
import java.util.ArrayList;
import java.util.Scanner;


public class BookingSystem {
	
	ArrayList<BookingRecord> records = new ArrayList<BookingRecord>();

	public void addBooking(MovieSession specificSession) {

		Scanner sc =new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		String cName = sc.nextLine();
		System.out.println("Please enter your email: ");
		String email = sc.nextLine();
		System.out.println("Please enter your suburb: ");
		String suburb = sc.nextLine();
		
		try {
			Customer newCustomer = new Customer(cName, email, suburb);
			specificSession.addBooking(newCustomer);
			records.add(new BookingRecord(specificSession, newCustomer));
			
		} catch (SessionMaxException e) {
			System.out.println(e.getMessage());
		
		} catch (CustomerRepeatException e2) {
			System.out.println(e2.getMessage());
		}
		
	}
	
	public ArrayList<BookingRecord> getRecords(){
		
		return records;
	}

}
