package jMoSS;

import java.util.ArrayList;

public class Clerk {

	private String clerkID;
	private String password;
	private ArrayList<Clerk> clerks;

	public Clerk(String clerkID, String password) {
		this.clerkID = clerkID;
		this.password = password;	
	}
	
	public boolean checkID(String inputID) {
		
		return false;
	}
	
    public boolean checkPassword(String inputPassword) {
		
		return false;
	}

	public ArrayList<Clerk> getClerks() {
		
		return clerks;
	}
	
	public String getClerkID() {
		
		return clerkID;	
	}
	
    public String getClerkPassword() {
		
		return password;	
	}
	
	
	

}
