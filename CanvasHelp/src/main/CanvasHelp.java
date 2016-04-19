package main;

import Data.Token;

public class CanvasHelp 
{
	public CanvasHelp() {
	}


	
	
	public static void main(String[] args) 
	{
		
		
		 
		Token usertoken= new Token(); 
		
		Mainauthenticate authen = new Mainauthenticate(usertoken); 
		
		authen.authenticateuser(); 

		Guider guide=new Guider(usertoken); 
	     
	}

}
