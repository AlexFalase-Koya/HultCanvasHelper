package webstuff;

import javax.swing.JOptionPane;

import com.jaunt.JNode;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import Data.Token;

public class Authenticator 
{
	Token TheToken; 
	String Token; 

	public Authenticator()
	{
		
	}
	
	public void Getcode ()
	{
		 try {
		        
	         String url = "http://mycourses.hult.edu/login/oauth2/auth?client_id=10000000000447&response_type=code&redirect_uri=https://mycourses.hult.edu&state=YYY";
	         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	       }
	       catch (java.io.IOException e) 
		 {
	           System.out.println(e.getMessage());
	       }
	}
	
	
	public Token tokensetter (String code, Token UserToken)
	{
			
		  UserAgent userAgent = new UserAgent();
		  

		  System.out.println("SENDING POST REQUEST...\n");
		  try {
			userAgent.sendPOST("https://mycourses.hult.edu/login/oauth2/token",
			    "grant_type=authorization_code&client_id=10000000000447&"
			    + "client_secret=uL0Tzt5vghR75AQtexStmWg2JjOunXmRLbnqNiDT2JyQ1WjEvj3775kovydxokct&redirect_uri=https://mycourses.hult.edu&code="
			    +code);
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                               //send HTTP POST Request with queryString
		  System.out.println("DOCUMENT:\n" +userAgent.json);  
		 
		  UserToken.settoken(findoneofjson(userAgent, "access_token") );
		  UserToken.setname(findoneofjson(userAgent, "name") );
		  
		  return UserToken; 
	}
	
	
	public String tokengetter (String code)
	{
			return Token; 
		  
		  
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
