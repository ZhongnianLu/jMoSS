package jMoSS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Menu {
	
	Clerk admin;
	
	//ArrayList<Clerk> clerks = admin.getClerks();
	
	Scanner sc = new Scanner(System.in);
	
	int choice;
	
	String yschoice;

	ArrayList<Theatre> theatreList;
	
	BookingSystem bsystem = new BookingSystem();
	
	test server = new test();
	
	
	
	public void run() {
		
		server.importData();
		theatreList = server.getTList();
		System.out.println(theatreList.get(0).getSessionList().get(0).getMovieName());

		//login();
		mainMenu();
		
	}
	
	
	public void login() {
		
        System.out.println("\n\n\n\n\n===============================================");
		System.out.println("              Welcome to jMoSS! ");
		System.out.println("===============================================");
		boolean foundClerk = false;
		
		boolean passwordCorrect = false;
			
		System.out.println("\n\n\n\nPlease log in");
		
		System.out.println("\nEnter Your User ID:");
		sc.nextLine();
		//admin.checkID(sc.nextLine());
		foundClerk = true;
		
		System.out.println("\nEnter Your Password:");
		sc.nextLine();
		//admin.checkPassword(sc.nextLine());
		passwordCorrect = true;
		
		while(foundClerk == false || passwordCorrect == false) {
		
			System.out.println("Clerk ID or Password wrong, please try again.");
			
			System.out.println("\n\n\n\nPlease log in");
			foundClerk = admin.checkID(sc.nextLine());
			
			System.out.println("\nEnter Your User ID:");
			foundClerk = admin.checkPassword(sc.nextLine());
		
		};
		
		System.out.println("Log in Successed! ");

    }
	
	public void mainMenu() {
				
		System.out.println("\n===============================");
		System.out.println("             MENU");
		System.out.println("===============================");
		System.out.println("\n\n\n1. Search Movie Session");
		System.out.println("\n2. Search Booking Records");
		System.out.println("\n0. Log out");
		System.out.println("\nPlease enter your option: ");

		try{
			choice = sc.nextInt();
	
	
		switch(choice) {
		
		case 1: searchSession();
		break;
		
		case 2: searchBooking();
		break;
		
		case 0: System.exit(0);
		break;
		
		default: 
			System.out.println("Please enter a valid choice.");
			mainMenu();

		
		
		break;
		}
		}catch(Exception e) {
			System.out.println("Please enter a valid choice");
			sc.nextLine();
			mainMenu();

		}
		
		
	}
	
	public void searchSession() {
		
        System.out.println("\n\n===============================");
		System.out.println("         MOVIE SESSION");
		System.out.println("================================");
		System.out.println("\n\n\n1. Search Specific Movie Session (Movie name, Date, Theatre)");
		System.out.println("\n2. List Movie Sessions by Movie Name");
		System.out.println("\n3. List Movie Sessions by Date");
		System.out.println("\n4. List Movie Sessions by Cinema (within a week) ");
		System.out.println("\n0. Back to main menu  ");
		System.out.println("\n\nPlease enter your option: ");
		
		try{
			choice = sc.nextInt();
		
			switch(choice) {
		
    		case 1: 
		
    		System.out.println("Please enter the Theatre location: ");
	    	sc.nextLine();
    		String theatre = sc.nextLine();
    		System.out.println("Please enter the Date: ");
    		String date = sc.nextLine();
    		System.out.println("Please enter the Movie Name: ");
    		String movieName = sc.nextLine();
    		searchSpecificSession(theatre, date, movieName);
			boolean validInput = false;
    		do{
    			System.out.println("\n\nDo you want to make a booking for this movie session? (y/n) ");    		
    			yschoice = sc.nextLine();
    	        if(yschoice.equals("y") == false && yschoice.equals("n") == false) {
    	        	System.out.println("Invalid input.");
    	        }else {
    	        	if(yschoice.equals("y")) {
    	        		bsystem.addBooking(getSpecificSession(theatre, date, movieName));
    	        	
    	        	}else {
    	        		searchSession();
    	        	}
    	        }
    		}while(validInput == false);
    		
    		
    		searchSession();
		
    		break;
	
	    	case 2:
			
	    	System.out.println("Please enter the Movie Name: ");
    		sc.nextLine();
	    	String movieName2 = sc.nextLine();	
    		System.out.println("Your research result is : ");
    		for(Theatre targetTheatre : theatreList) {
    			if(targetTheatre.searchByMName(movieName2)!=null) {
    				for(MovieSession targetSession : targetTheatre.searchByMName(movieName2)) {
    					System.out.println("\n\t"+targetTheatre.getLocation()+ " "+
	    						       targetSession.getMovieName() + "  " + 
		    		                   targetSession.getTime() + "  " +
			    			           targetSession.getDate() + "   (" + 
				                       targetSession.getSeats() + "/" + 
					    	           targetSession.getMax() + ")");
    			    };   
	    	    }
    	    }
    		searchSession();
    		break;
		
    		case 3:
			
    			System.out.println("Please enter the Date (yyyy/MM/dd): ");
	    		sc.nextLine();
    			String date2 = sc.nextLine();	
	    		System.out.println("Your research result is : ");
    			for(Theatre targetTheatre : theatreList) {
	    			if(targetTheatre.sessionListByDate(date2)!=null) {
		    			for(MovieSession targetSession : targetTheatre.sessionListByDate(date2)) {
	    					System.out.println("\n\t"+targetTheatre.getLocation()+ " "+
		    						       targetSession.getMovieName() + "  " + 
			    		                   targetSession.getTime() + "  " +
				    			           targetSession.getDate() + "   (" + 
					                       targetSession.getSeats() + "/" + 
						    	           targetSession.getMax() + ")");
    				    };
	    		    }
		        }

	    		searchSession();
				break;
			
    		case 4:
			
    			System.out.println("Please enter the Cinema: ");
	    		sc.nextLine();
	    		String cinema = sc.nextLine();	
	    		System.out.println("Your research result is : ");
    			for(Theatre targetTheatre : theatreList) {
    				if(targetTheatre.getLocation().equals(cinema)) {
	    				for(MovieSession targetSession : targetTheatre.getSessionList()) {				
	    					if(comparingDatesInWeek(targetSession.getDate())==false){
								System.out.println("\n\t"+targetTheatre.getLocation()+ " "+
		    						       targetSession.getMovieName() + "  " + 
			    		                   targetSession.getTime() + "  " +
				    			           targetSession.getDate() + "   (" + 
					                       targetSession.getSeats() + "/" + 
					    		           targetSession.getMax() + ")");
				            };
			            }
		            }
    			}
			
		    	searchSession();
			
	    		break;
			
    		case 0:
			
	    		mainMenu();
			
	    		break;
			
    		default: 
			
    			System.out.println("Please enter a valid option.");
	    		searchSession();
		    	break;

    		}
	    }catch(Exception e) {
		    System.out.println("Please enter a valid choice");
			sc.nextLine();
			searchSession();
		}
		
			
	}
	


	public void searchBooking() {
		
	}

	
		
	public void searchSpecificSession(String location, String date, String movieName) {

		MovieSession target = null;

		for(Theatre theatre : theatreList) {
			
			if (theatre.getLocation().equals(location)){
					target = theatre.searchSession(date, movieName);
					System.out.println("Your research result is : ");
					System.out.println("\n\t"+theatre.getLocation() + 
							           target.getMovieName() + "  " + 
					                   target.getTime() + "  " +
							           target.getDate() + "   (" + 
					                   target.getSeats() + "/" + 
							           target.getMax() + ")");
			}
		}	
	}
	
	public MovieSession getSpecificSession(String location, String date, String movieName) {
		MovieSession target = null;

		for(Theatre theatre : theatreList) {
			
			if (theatre.getLocation().equals(location)){
					target = theatre.searchSession(date, movieName);
			}
		}
		return target;
	}
	

	
	public boolean comparingDatesInWeek(String movieDate) {
		boolean overdue = true;

		DateFormat dateFormat  = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();;		
		
		Date date2 = null;
		try {
			date2 = dateFormat.parse(movieDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		boolean pass =date2.after(c.getTime());
		
		c.add(Calendar.DATE, 7);

		if(date2.before(c.getTime()) && pass == true) {
			overdue = false;
		}
		
		return overdue;

		
	}

		
		
		
		
}



