package gui;

import javax.swing.JFrame;

public class ScannerGUI 
{
	JFrame scanner; 

	public ScannerGUI() 
	{
		   scanner=new JFrame(); 
		   scanner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String Correctanswer(String testsubject, int type)
	{
		if(type==1)
		{
			datechecker(testsubject); 
		}
		
		
		else if(type==2)
		{
			
		}
		
		return ""; 
	}
	
	public String datechecker(String tester)
	{
		boolean checkformat;
		
		if (tester.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
		    checkformat=true;
		else
		   checkformat=false;
		
		return ""; 
	}

}
