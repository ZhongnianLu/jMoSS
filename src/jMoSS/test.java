package jMoSS;

import java.util.ArrayList;

public class test {
	
	ArrayList<Theatre> theatres;


	public  void importData()  {

		theatres = new ArrayList<Theatre>();
		Theatre t1 = new Theatre("St Kilda");
		Theatre t2 = new Theatre("Fitzroy");
		Theatre t3 = new Theatre("Melbourne CBD");
		Theatre t4 = new Theatre("Sunshine");
		Theatre t5 = new Theatre("Lilydale");
		
		theatres.add(t1);
		theatres.add(t2);
		theatres.add(t3);
		theatres.add(t4);
		theatres.add(t5);

		MovieSession m1 = new MovieSession("SpiderMan", "2018/04/21", "2:00pm", 20, t1);
		MovieSession m2 = new MovieSession("Oz", "2018/04/23", "5:00pm", 20, t1);
		MovieSession m3 = new MovieSession("Avengers", "2018/04/25", "2:00pm", 20, t1);
		MovieSession m4 = new MovieSession("Lion King", "2018/05/01", "2:00pm", 20, t2);



	}
	
	public ArrayList<Theatre> getTList(){
		return theatres; 
	}
}