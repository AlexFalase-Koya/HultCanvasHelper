package csvcreator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Data.Course;
import Data.Token;

public class Cvsreaders 
{
	
	Token storer; 
	String[] s;
	String[] c;
	int iterate=0; 
	int itemCount; 
	Token [] storerr; 
	
	String currentgroup; 
	//List<Infosorted> sortedinfo = new ArrayList<>();
	
	JFrame oldframe ;
	String path="Error"; 

	
		public void tokenreader(Token user)
		{
		
			storetoken(fileread(System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp"+"/"+"TokenHolder.csv"), user); 
			
		}
		
		public Course [] coursereader(Course [] user)
		{
		
			return storecourse(fileread(System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp"+"/"+"Courses.csv"), user); 
			
		}
		

		
		public void storetoken(List<String> lines,Token users)
		{
	
			iterate=0; 
			 itemCount = lines.size();
			//storer =new SourceStorage [itemCount];
		    
			for (int i = 0; i < itemCount-1; i++)
			{
				String holder= lines.get(1+i);
				
				s = holder.split(",");
				   
				if(holder.length() > 3)
				   { 
					
					//storerr[iterate] = new Token();
					users.setname(s[0]);
					users.settoken(s[1]);
					users.setlastupdated(s[2]);
				    iterate++; 
				    
				   }
				
				else
				{
					 
				}
				
				
		      }
		}
		
		public Course[] storecourse(List<String> lines, Course [] coursee)
		{
			
	        String previousSISID="null"; 
			int iterater=0; 
			int itemCounter = lines.size();
			Course [] mycourses =new Course [itemCounter];
		    
			for (int i = 0; i < itemCounter-1; i++)
			{
				String holder= lines.get(1+i);
				
                 c  = holder.split(",");
                 
                 
				   
				if(holder.length() > 2)
				   { 
				
					mycourses[i] = new Course();
					
					mycourses[i].setname(c[0]);
					mycourses[i].setsis(c[1]);
				
					mycourses[i].setterm(c[2]);
					
					previousSISID=c[1]; 
				   }
				
				else
				{
					 
				}
				
				
		      }
			
			return mycourses;
		}
		
		public List<String> fileread(String path)
		{
			BufferedReader reader = null;
			try 
			{
				reader = new BufferedReader(new FileReader(path));
			
			} 
			
			catch (FileNotFoundException e) 
			{
				System.out.println("File not found");
				e.printStackTrace();
			}
			
			List<String> lines = new ArrayList<>();
			
			String line = null;
			
			try 
			{
				while ((line =reader.readLine()) != null) 
				{
					
				    lines.add(line);
				}
			} 
			
			catch (IOException e) 
			{
			e   .printStackTrace();
			}
			
			
		   return lines; 
		}
	

}
