package csvcreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Data.Assignment;
import Data.Course;
import Data.Informtion;
import Data.Token;

public class Csvcreator 
{


		//Delimiter used in CSV file
		private static final String COMMA_DELIMITER = ",";
		private static final String NEW_LINE_SEPARATOR = "\n";
		//information 
		//CSV file header
		 public String FILE_HEADER = "FirstName,LastName,EvaluatorEmail,SubjectEmail";
		 public String Assignments_FILE_HEADER = "CourseName,CourseSIS,CourseTerm,AssignmentName";
		 public String course_FILE_HEADER = "CourseName,CourseSIS,CourseTerm";
		
		public void writeToken(Token info) 
		{
			new File(System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp").mkdir();
			
			String fileName=System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp"+"/"+"TokenHolder.csv";
			
			FILE_HEADER=info.getheaders(); 
			
			FileWriter fileWriter = null;
					
			try 
			{
				fileWriter = new FileWriter(fileName);

				//Write the CSV file header
				fileWriter.append(FILE_HEADER.toString());
				
				//Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				//Write a new student object list to the CSV file
			
				
					fileWriter.append(info.getname());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(info.gettoken());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(info.getlastupdated());
					fileWriter.append(COMMA_DELIMITER);

				System.out.println("CSV file was created successfully !!!");
				
			} 
			
			catch (Exception e) 
			{
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} 
			
			finally 
			{
				
				try 
				{
					fileWriter.flush();
					fileWriter.close();
				} 
				
				catch (IOException e) 
				{
					System.out.println("Error while flushing/closing fileWriter !!!");
	                e.printStackTrace();
				}
				}
				
			}
		public void writeCourses(Course [] info) 
		{
			String fileName=System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp"+"/"+"Courses.csv";
			
		
			
			FileWriter fileWriter = null;
					
			try 
			{
				fileWriter = new FileWriter(fileName);

				//Write the CSV file header
				fileWriter.append(course_FILE_HEADER.toString());
				
				//Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				//Write a new student object list to the CSV file
				for (int j = 0; j < info.length; j++) 
				{
				
					
						
					fileWriter.append(info[j].getname());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(info[j].getsis());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(info[j].getterm());

					fileWriter.append(NEW_LINE_SEPARATOR);
					
					
					
					
				}
				System.out.println("CSV file was created successfully !!!");
				
			} 
			
			catch (Exception e) 
			{
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} 
			
			finally 
			{
				
				try 
				{
					fileWriter.flush();
					fileWriter.close();
				} 
				
				catch (IOException e) 
				{
					System.out.println("Error while flushing/closing fileWriter !!!");
	                e.printStackTrace();
				}
				}
		}
		
		
		public void writeAssignments(Course [] info) 
		{
			
			
			
			String fileName=System.getProperty("user.home")+ "/Desktop" +"/"+"Canvashelp"+"/"+"assignments.csv";
			
			Assignment [] theassignments; 
			
			FileWriter fileWriter = null;
					
			try 
			{
				fileWriter = new FileWriter(fileName);

				//Write the CSV file header
				fileWriter.append(Assignments_FILE_HEADER.toString());
				
				//Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				//Write a new student object list to the CSV file
				for (int j = 0; j < info.length; j++) 
				{
					theassignments=info[j].getassignments();
					if(theassignments!=null)
					{
					for (int i = 0; i < theassignments.length; i++) 
					{
						
					fileWriter.append(info[j].getname());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(info[j].getsis());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(info[j].getterm());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(theassignments[i].getname());
					fileWriter.append(NEW_LINE_SEPARATOR);
					
					}
					}
					else{}
				}
				System.out.println("CSV file was created successfully !!!");
				
			} 
			
			catch (Exception e) 
			{
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} 
			
			finally 
			{
				
				try 
				{
					fileWriter.flush();
					fileWriter.close();
				} 
				
				catch (IOException e) 
				{
					System.out.println("Error while flushing/closing fileWriter !!!");
	                e.printStackTrace();
				}
				}
				
			}
		
		
	

	
		
	

		
	

	}


