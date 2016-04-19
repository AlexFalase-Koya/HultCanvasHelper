package main;

import java.io.File;

import javax.swing.JOptionPane;

import Data.Token;
import csvcreator.Csvcreator;
import csvcreator.Cvsreaders;
import gui.Gui;
import webstuff.Authenticator;

public class Mainauthenticate 
{
	Authenticator Authenticate = new Authenticator(); 
	Gui popupcreator = new Gui(); 
	Token usertoken= new Token(); 
	Csvcreator writetodisk=new Csvcreator(); 
	Cvsreaders reader=new Cvsreaders(); 

	public Mainauthenticate(Token usertoken2) 
	{
		usertoken=usertoken2;
	}
	
	public void authenticateuser()
	{
		if(new File(System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp"+"/"+"TokenHolder.csv").isFile())
		{
			setauthentication();
		//	System.out.println(usertoken.getname()); 
		//	System.out.println(usertoken.gettoken()); 
		}
		
		else
		{
			getauthentication(); 
		}
		
		
		
		popupcreator.loggedinintro(usertoken.getname());
	}
	
	public void setauthentication()
	{
		reader.tokenreader(usertoken);

		
	}
	
	public void getauthentication()
	{
		int selection=popupcreator.Intropopup(); 
		Authenticate.Getcode();
		
		if (selection == JOptionPane.OK_OPTION)
		  {
			
			
			writetodisk.writeToken(Authenticate.tokensetter(popupcreator.codereciever(), usertoken)); 
			
		  }
		
		  else if (selection == JOptionPane.CANCEL_OPTION)
		  {
		     
		      System.out.println("Selected Option Is CANCEL : " + selection);
		  }
	}

}
