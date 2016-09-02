package edu.hzu.github;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepoDay {
	public static long day(String time){
		String newtime=time.replace("T", " ");
		String time1=newtime.replace("Z", "");
	
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  long day=0;
	    try {
			Date date = df.parse(time1);
			Date now = new Date(); 
			   long diff = now.getTime() - date.getTime();
			 day = diff / (1000 * 60 * 60 * 24);
	
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return day;
		
		
	}

}
