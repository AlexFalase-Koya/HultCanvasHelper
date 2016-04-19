package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import Data.Token;
import csvcreator.Csvcreator;
import gui.Gui;

public class Guider 
{

	Token user = new Token(); 
	Gui popupcreator = new Gui(); 
	String choice; 
	Assignmentuploader upload; 
	Courselister lister; 
	Date date;
	Csvcreator writertodisk=new Csvcreator(); 
	
	public Guider(Token usertoken) 
	{
		user=usertoken; 
		initguide(); 
	}
	
	public void initguide()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int courselistresetchoice = popupcreator.courselistupdatescreen(user.getlastupdated()); 
		
		if (courselistresetchoice==1)
		{
			lister=new Courselister(user); 
			date = Calendar.getInstance().getTime(); 
			user.setlastupdated(dateFormat.format(date));
			writertodisk.writeToken(user);
			upload=new Assignmentuploader(user);
		
		}
		
		else if (courselistresetchoice==0)
		{
			upload=new Assignmentuploader(user);
		}
		
		
		//choice=popupcreator.guiderpopup(); 
		
		
	}

}
