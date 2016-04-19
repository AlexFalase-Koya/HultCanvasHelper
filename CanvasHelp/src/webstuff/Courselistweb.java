package webstuff;

import java.util.ArrayList;

import com.jaunt.JNode;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import Data.Course;
import Data.Token;

public class Courselistweb 
{
	Token Self; 
	ArrayList<Course> coursear;
	UserAgent userrr;
	int pagecount=1;
	String linker;
	String noder="";
	String pagewords; 

	public Courselistweb(Token user)
	{
		Self=user; 
		//coursearray=coursear;
		 userrr=new UserAgent();
		
	}
	
	public String jsondocs ()
	{
		
		 String previous; 
		 String current; 
		 pagewords=""; 
	

		 
		
				try 
				{
					  
					
					do
					{
				    previous=userrr.getSource();
				  
				    if(pagecount>1)
				    {
				    	userrr.sendGET("https://mycourses.hult.edu/api/v1/accounts/sis_account_id:PG-2015_16-LON/courses?include[]=term&page="+pagecount+"&per_page=100&access_token="+Self.gettoken()+"&rel=next");
				    }
				    
				    else if(pagecount<=1)
				    {
				    	userrr.sendGET("https://mycourses.hult.edu/api/v1/accounts/sis_account_id:PG-2015_16-LON/courses?include[]=term&per_page=100&access_token="+Self.gettoken());
				    }
				
					linker=userrr.response.getHeader("link"); 
					
					current=userrr.getSource();
				    noder=noder+userrr.getSource(); 
				    
				
			
				
				    pagecount++; 
					
					}
					while(!(current.equals(previous)));
					
				
				}
				
				catch (ResponseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 return noder;

	}
	
	public String Assignmenntgetter (String Courseid)
	{
		UserAgent myuseer=new UserAgent();

		try 
		{
			myuseer.sendGET("https://mycourses.hult.edu/api/v1/courses/sis_course_id:"+Courseid+"/assignments?access_token=1~zvqgz4Wyc6CFZmX3hTifWqQNVZp6uwU7hvfO0VSuaBAfIjCVo1WRtjs6IBiGH92j");
		} 
		catch (ResponseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return myuseer.getSource();

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
