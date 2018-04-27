package jMoSS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class date_try {

	public static void main(String[] args) throws ParseException {
		DateFormat dateFormat  = new SimpleDateFormat("yyyy/MM/dd");

		Calendar c = Calendar.getInstance();;
		
		c.add(Calendar.DATE, 7);
		
		System.out.println("Calendar£º " + dateFormat.format(c.getTime()));
		Date date2 = dateFormat.parse("2018/04/23");

		System.out.println(dateFormat.format(date2));

		if(date2.before(c.getTime())) {
			System.out.println("date 2 is valid");
		}else {
			System.out.println("Nothing");
		}
		
	}

}
