package webstuff;

import com.jaunt.JNode;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import Data.Course;
import Data.Token;

public class Courseinformation 
{
	UserAgent useragent; 
	String SIS; 
	Token MyToken; 

	public Courseinformation(String ID, Token thetoken) 
	{
		SIS=ID; 
		MyToken=thetoken; 
	}
	
	
	public String retrievecoursename()
	{
		useragent=new UserAgent(); 
		
				try 
				{
					useragent.sendGET("https://mycourses.hult.edu/api/v1/courses/sis_course_id:"+SIS+"?access_token="+MyToken.gettoken());
					
				} 
				catch (ResponseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return findoneofjson(useragent, "name"); 
	}
	
	public String findoneofjson(UserAgent user, String Heading)
	{
		try 
		{
			JNode access_token = user.json.findFirst(Heading);
			String found=access_token.toString(); 
			return found; 
			
			
		} 
		
		catch (NotFound e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failed"; 

	}

}
