package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Data.Course;

@SuppressWarnings("serial")
public class Gui 
{
	
	String path;
	JFrame otherwindows; 

	
   public Gui ()
   {
	   otherwindows=new JFrame(); 
	   otherwindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public int Intropopup()
   {
	   int selection = JOptionPane.showConfirmDialog(
			   otherwindows
       , "A chrome browser will open, login and authenticate, press OK to continue"
       , "Selection : "
       , JOptionPane.OK_CANCEL_OPTION
       , JOptionPane.INFORMATION_MESSAGE);
	   
	   return selection; 

   }
   
   public String guiderpopup()
   { 
	   String[] choices = { "Assignment Uploader", "Course Lister"};
       String input = (String) JOptionPane.showInputDialog(null, "Choose now",
	         "Function", JOptionPane.QUESTION_MESSAGE, null, // Use
	                                                                         // default
	                                                                         // icon
	         choices, // Array of choices
	         choices[0]);
       
       return input; 


   }
   
   
   
   public String codereciever()
   {
		  String temp=JOptionPane.showInputDialog("Enter url of page you get redirected to after you authenticate"); 
		    
		  String requiredString = temp.substring(temp.indexOf("=") + 1, temp.indexOf("&"));
		  
		//  System.out.println(requiredString);
		  
		  return requiredString; 
   }
   
   public void loggedinintro(String name)
   {

	  // JOptionPane pane = new JOptionPane("Hello, "+name+".You are now logged in. Press 'okay' to continue", JOptionPane.INFORMATION_MESSAGE);
	 //  JDialog dialog = pane.createDialog(otherwindows, "Title");
	  // dialog.setVisible(true);
	   
	   JOptionPane.showMessageDialog(otherwindows, "Hello, "+name+". You are now logged in. Press 'okay' to continue"); 
	   otherwindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
   
   public void Coursenamepopup(String name)
   {
	   JOptionPane pane = new JOptionPane("You have selected, "+name+".", JOptionPane.INFORMATION_MESSAGE);
	   JDialog dialog = pane.createDialog(otherwindows, "Title");
	   dialog.setVisible(true);
	   
	   

   }
   
   public String getcourseid()
   {
	   String ID=JOptionPane.showInputDialog(otherwindows,"Enter the course SID ID"); 
	  
	   return ID; 
   }
   
   public void finishedassignmentupload(String name)
   {
	   JOptionPane pane = new JOptionPane("You have uploaded the assignments for "+name+".", JOptionPane.INFORMATION_MESSAGE);
	   JDialog dialog = pane.createDialog(otherwindows, "Title");
	   dialog.setVisible(true);
	   
	  
	  
   }
   
   public void finishedcoursedownload()
   {
	   JOptionPane pane = new JOptionPane("You have selected, ", JOptionPane.INFORMATION_MESSAGE);
	   JDialog dialog = pane.createDialog(otherwindows, "Title");
	   dialog.setVisible(true);
	   
	  
	 
   }
   
   
   public int courselistupdatescreen(String Lastupdateddate)
   {
	  if(JOptionPane.showConfirmDialog(
			   otherwindows,
			    "Courselist last updated on "+Lastupdateddate+", do you want to update it now?",
			    "Course-List update",
			    JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) 
	  {
		//  System.out.println("maybeworks"); 
		 return 1; 
	  }
	  
	  else
	  {
	//	  System.out.println("works"); 
		  return 0; 
	  }
	  
	  
	  
   }
   
   public String courselist(Course [] courselist)
   {
	   String [] coursenamelist= new String [courselist.length]; 
	   String [] termlist = new String [courselist.length]; 
	   
	   String SISID="false";
	   
	   for(int i=0; i<courselist.length-1; i++)
	   {
		   //coursenamelist[i]=courselist[i].getname(); 
		   termlist[i]=courselist[i].getterm(); 
	   }
	   
	   Set<String> uniqueterm = new HashSet<String>(Arrays.asList(termlist));
	   termlist = new String[uniqueterm.size()];
	   termlist=uniqueterm.toArray(termlist); 
	   
	   String terminput = (String) JOptionPane.showInputDialog(null, "Choose now",
		         "Function", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                         // default
		                                                                         // icon
		         termlist, // Array of choices
		         termlist[0]);
	   
	   for(int i=0; i<courselist.length-1; i++)
	   {
		   if(terminput.equals(courselist[i].getterm()))
		   {
		     coursenamelist[i]=courselist[i].getname(); 
		   }
	   }
	   
	   coursenamelist=clean(coursenamelist);
  
   String courseinput = (String) JOptionPane.showInputDialog(null, "Choose now",
         "Function", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                         // default
                                                                         // icon
         coursenamelist, // Array of choices
         coursenamelist[0]);
   
   

   
   for(int i=0; i<courselist.length-1; i++)
   {
	   if (courseinput.equals(courselist[i].getname()))
	   {
		   SISID=courselist[i].getsis(); 
	   }
	   
	   else{}
	  
   }
   

   
   return SISID; 

  
     }
   
   
   
   public int getnumberofassignments()
   {
	   String ID=JOptionPane.showInputDialog(otherwindows,"How many Assignments are there?"); 
	   int i = Integer.parseInt(ID);
	   return i; 
   }
   
   public String getpath()
   {
	   System.out.println("SENDING POST REQUEST...\n");
	       
			  
				  JFrame frame=new JFrame(); 
			//	System.oou2System.getProperty("user.home")
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = 
		        new FileNameExtensionFilter( "Word files only", "docx");
					
				chooser.setFileFilter(filter);
			   	 frame.setVisible(true);
					int returnVal = chooser.showOpenDialog(frame);
					
					if(returnVal == JFileChooser.APPROVE_OPTION) 	
				    {
						 path = (chooser.getSelectedFile().getPath()); 
					   System.out.println("You chose to open this file: " +
					        chooser.getSelectedFile().getPath());
					} 

 
					  
	   return path; 
   }
   

   public static String[] clean(final String[] v) {
	    List<String> list = new ArrayList<String>(Arrays.asList(v));
	    list.removeAll(Collections.singleton(null));
	    return list.toArray(new String[list.size()]);
	}
}
