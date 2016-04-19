package main;



import Data.Assignment;
import Data.Course;
import Data.Token;
import csvcreator.Cvsreaders;
import gui.Gui;
import utility.TextExtractor;
import webstuff.Assignmentwebwork;
import webstuff.Courseinformation;

public class Assignmentuploader 
{

	private Gui popupcreator;
	public Course newcourse=new Course();
	private TextExtractor text; 
	public Assignment [] array; 
	public Assignment [] finishedarray; 
	public Course [] mycourselist;
	Token User = new Token();
	Assignmentwebwork uploader; 
	Courseinformation courseinfo; 
	Cvsreaders getcourselist=new Cvsreaders(); 
	
	public Assignmentuploader(Token user) 
	{
		popupcreator= new Gui();
		User=user;
		mycourselist=getcourselist.coursereader(mycourselist);
		
		
		newcourse.setsis(popupcreator.courselist(mycourselist));
		
		courseinfo=new Courseinformation( newcourse.getsis(),user); 
		
		newcourse.setname(courseinfo.retrievecoursename()); 
		 
		popupcreator.Coursenamepopup(newcourse.getname()); 
		
		text = new TextExtractor(popupcreator.getpath());
		
          try 
          {
        	  text.process();
		  } 
          
          catch 
          (Exception e) 
          {
           e.printStackTrace();
		  }
          
          finishedarray= text.getString(newcourse);
          
          newcourse.setarray(finishedarray); 
          
          uploader=new Assignmentwebwork(newcourse,User); 
          uploader.postassignment(); 
          popupcreator.finishedassignmentupload(newcourse.getname());
      	  System.exit(0); 
		
	}

	

}
