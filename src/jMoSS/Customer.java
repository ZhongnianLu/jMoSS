package jMoSS;

public class Customer {
	
	private String cName;
	private String email;
	private String suburb;
	
	
	public Customer(String cName, String email, String suburb) {
		
		this.cName = cName;
		this.email = email;
		this.suburb = suburb;
	}
	
	public String getName() {
		
		return cName;
	}
	
	public String email() {
		
		return email;
	}
	
	public String suburb() {
		
		return suburb;
	}
	

}
