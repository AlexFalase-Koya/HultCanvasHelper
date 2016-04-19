package webstuff;

import com.jaunt.JNode;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import Data.Assignment;
import Data.Course;
import Data.Token;

public class Assignmentwebwork 
{

	Course information;
	Token mytoken; 
	Assignment [] subject;
	UserAgent userAgent;
	String [] submission_types;
	String [] allowed_extensions;
	boolean	turnitin_enabled; 
	float points_possible; 
	int id;
	
	public Assignmentwebwork(Course course,Token passedtoken) 
	{
		
		information=course; 
		mytoken=passedtoken;
		subject=information.getassignments();
		userAgent = new UserAgent();
		submission_types = new String [1] ; 
		submission_types[0]="online_upload";
		
		
		allowed_extensions = new String [8] ; 
		allowed_extensions[0]="doc";
		allowed_extensions[1]="xls";
		allowed_extensions[2]="xlsx";
		allowed_extensions[3]="docx";
		allowed_extensions[4]="ppt";
		allowed_extensions[5]="pptx";
		allowed_extensions[6]="txt";
		allowed_extensions[7]="pdf";
		
		turnitin_enabled=true; 
		
		 points_possible=3; 
		
	//assignment[points_possible]
		
	}
	
	public void postassignment()
	{
		
		
		 
		  System.out.println("SENDING POST REQUEST...\n");
		 
			
				for (int i=0; i < subject.length; i++) 
				{
					postgroup(i); 
					 System.out.println("DOCUMENT:\n" +userAgent.json);  
					 id=findoneofjson(userAgent, "id"); 
					
					postassign(i,id);
					System.out.println("DOCUMENT:\n" +userAgent.json); 
			    }
		
	
			
		
		  
	}
	
	public void postgroup(int j)
	{
		try {
			
			
		userAgent.sendPOST("https://mycourses.hult.edu/api/v1/courses/sis_course_id:"
	            +information.getsis()
				+"/assignment_groups"
				+ "?access_token="+mytoken.gettoken()
				,
				"name="+subject[j].getname()
		        +"&group_weight="+subject[j].getweight()
		        +"&position=1" );
		}
		catch (ResponseException e) 
		  
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                               //send HTTP POST Request with queryString
		 
	}
	
	public void postassign(int j, int groupID)
	{
		
		try {
			
			if(subject[j].isduedateactive())
			{
		
			userAgent.sendPOST("https://mycourses.hult.edu/api/v1/courses/sis_course_id:"
		            +information.getsis()
					+"/assignments"
					+ "?access_token="+mytoken.gettoken()
					,
					"assignment[name]="+subject[j].getname()
				     +"&assignment[submission_types][]="+"online_upload"
			         +"&assignment[allowed_extensions][]="+"pdf,docx,xls,xlsx,docx,ppt,pptx,txt"
				     +"&assignment[turnitin_enabled]="+turnitin_enabled
			         +"&assignment[points_possible]="+points_possible
				     +"&assignment[grading_type]="+"letter_grade"
				     +"&assignment[published]="+false
				     +"&assignment[due_at]="+subject[j].getduedate()
				     +"&assignment[lock_at]="+subject[j].getduedate()
				     +"&assignment[assignment_group_id]="+groupID
			         +"&assignment[description]="+ subject[j].getformatteddescription())
			         ;
		    }
			if(subject[j].isduedateactive()==false)
			{
				userAgent.sendPOST("https://mycourses.hult.edu/api/v1/courses/sis_course_id:"
			            +information.getsis()
						+"/assignments"
						+ "?access_token="+mytoken.gettoken()
						,
						"assignment[name]="+subject[j].getname()
					     +"&assignment[submission_types][]="+"online_upload"
				         +"&assignment[allowed_extensions][]="+"pdf,docx,xls,xlsx,docx,ppt,pptx,txt"
					     +"&assignment[turnitin_enabled]="+turnitin_enabled
				         +"&assignment[points_possible]="+points_possible
					     +"&assignment[grading_type]="+"letter_grade"
					     +"&assignment[published]="+false
					     +"&assignment[assignment_group_id]="+groupID
				         +"&assignment[description]="+ subject[j].getformatteddescription())
				         ;
			}
			
			}
			catch (ResponseException e) 
			  
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         
	}
	
	
	public int findoneofjson(UserAgent user, String Heading)
	{
		try 
		{
			JNode access_token = user.json.findFirst(Heading);
			String found=access_token.toString(); 
			int foo = Integer.parseInt(found);
			return foo; 
			
			
		} 
		
		catch (NotFound e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0; 

	}
	
	

}
