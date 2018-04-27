package jMoSS;

import java.util.ArrayList;

public class Theatre {

	
	private String location;
	
	private ArrayList<MovieSession> sessionList = new ArrayList<MovieSession>();
	
	private ArrayList<MovieSession> targetSessions;

	
	public Theatre(String location) {
		
		this.location = location;
	}
	
	public MovieSession searchSession(String date, String movieName)  {
		
		MovieSession targetSession =null;
		for(MovieSession moviesession : sessionList) {
			if(moviesession.getDate().equals(date) & moviesession.getMovieName().equals(movieName)) {
				targetSession = moviesession;
			}
		}
		
		
		return targetSession;

	}

	public ArrayList<MovieSession> searchByMName(String movieName2) {
		
		targetSessions = new ArrayList<MovieSession>();
		
		for(MovieSession session : sessionList) {
			if(session.getMovieName().equals(movieName2)){
				
				targetSessions.add(session);
			}
			
		return targetSessions;
		}

		
		return null;
	}
	
	public boolean addMovieSession(MovieSession newsession) {
		
		boolean success = false;
		
		sessionList.add(newsession);

		return success;
	}
	
	public ArrayList<MovieSession> sessionListByDate(String date){
		
		targetSessions = new ArrayList<MovieSession>();
		
		if(sessionList!=null) {
		for(MovieSession targetSession : sessionList) {
			
			if(targetSession.getDate().equals(date)) {
				targetSessions.add(targetSession);
			}
		}
		
		
	}
		return targetSessions;

	}
	
	public String getLocation() {
		
		return location;
	}
	
	public ArrayList<MovieSession> getSessionList(){
		
		return sessionList;
	}

		
		
	} 



