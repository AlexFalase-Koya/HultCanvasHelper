package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.tika.sax.xpath.Matcher;

import Data.Assignment;
import Data.Course;
import Data.Token;
import csvcreator.Csvcreator;
import utility.Extractor;
import webstuff.Courselistweb;

public class Courselister 
{
	Courselistweb course; 

	Course [] coursearray; 
	Course [] realcoursearray; 
	String Courselist; 
	Extractor extract; 
	Extractor termextract; 
	Extractor assignextract; 
	Csvcreator creater; 

	public Courselister(Token USer) 
	{
		course=new Courselistweb(USer); 
		Courselist=course.jsondocs(); 
		extract=new Extractor(Courselist);
		coursearray=new Course[extract.count("sis_course_id")];
		realcoursearray=coursearray; 
		creater=new Csvcreator(); 
		
		  for(int i=0;i<coursearray.length;i++)
		   {
			  coursearray[i] = new Course();
		   }
		  coursetermgetter();
		  coursenamegetter();
		  courseidgetter();
		
		assignmentcontroller();
		creater.writeAssignments(coursearray); 
		creater.writeCourses(realcoursearray);
		
	}
	
	
	public void coursenamegetter()
	{

		
		Courselist=replaceMatching(Courselist,",\"apply_assignment_group_weights\"" , "\"term\":"); 

		extract.Stringreplacement(Courselist); 
	
		
		System.out.println(Courselist);
		String  [] Coursenames=new String[coursearray.length]; 
		Coursenames=extract.getter("\"name\":\"", "\",\"account_id\":");
		
		   for(int i=0;i<coursearray.length;i++)
		   {
			//   String stuff; 
			   //stuff=replaceMatching2(Coursenames[i], "\",\"account_id\":", "\"name\":\"");
              
			   coursearray[i].setname(Coursenames[i]);  
		   }
	}
	
	public void courseidgetter()
	{
		String  [] Courseid=new String[coursearray.length]; 
		Courseid=extract.getter("\"sis_course_id\":\"", "\",\"integration_id\"");
		
		   for(int i=0;i<coursearray.length;i++)
		   {

			//   System.out.println(Courseid[i]);
			   coursearray[i].setsis(Courseid[i]);  
		   }
	}
	
	public void coursetermgetter()
	{
		String  [] Courseterm=new String[coursearray.length]; 
		Courseterm=extract.getter("\"term\":{\"", ",\"apply_assignment_group_weights\"");
		
		extract.Stringreplacement(Arrays.deepToString(Courseterm));
		
		String  [] Coursetermmer=new String[coursearray.length]; 
		
		Coursetermmer=extract.getter("\"name\":\"","\",\"start_at\"");
		
		System.out.println(coursearray.length);
		
		   for(int i=0;i<coursearray.length;i++)
		   {

			
			   coursearray[i].setterm(Coursetermmer[i]);  
		
		   }
		
	//	Courselist=replaceMatching2(Courselist,",\"apply_assignment_group_weights\"" , "\"term\":\\{\""); 
		
		
	}
	
	public void assignmentcontroller()
	{
		String AssignmentString; 
		
		 for(int i=0;i<coursearray.length;i++)
		   {
			 AssignmentString=course.Assignmenntgetter(coursearray[i].getsis());  
			 Extractor assignextract=new Extractor(AssignmentString);
			 if(AssignmentString.equals("[]"))
			 {
				 
			 }
			 
			 else
			 {
			// System.out.println(AssignmentString);
			 
			 coursearray[i].setassignmentarray(assignextract.count("\"name\"")); 
			
			 String  [] assignmentname=new String[coursearray[i].getassignments().length]; 
			
			 assignmentname=assignextract.getter("\"name\":\"", "\",\"submission_types\"");
		
		

			 for(int j=0;j<assignmentname.length;j++)
			   {
				
				 coursearray[i].setdirectarray(j,assignmentname[j]);
				
			//	 System.out.println(coursearray[i].getdirectarrayname(j));
			   }
			 
			
			 }
		   }
	}
	
	 public static String replaceMatching(String input, String lowerBound, String upperBound)
			 {
		 int start= input.indexOf(upperBound); 
	     int startIndex = input.indexOf(upperBound);
		
	     while (start > -1)
	     {
	    	 
	        int endIndex = input.indexOf(lowerBound, startIndex);
	        String endPart = "";

	        if ((endIndex + lowerBound.length()) < input.length())
	        {  
	        	endPart = input.substring(endIndex + lowerBound.length());
	        }
	      
	        
	        input = input.substring(0, start) + "" + endPart;
	        start = input.indexOf(upperBound);
	       
	     }
	     System.out.println(input);
	     return input;
	     
		}
	

}
