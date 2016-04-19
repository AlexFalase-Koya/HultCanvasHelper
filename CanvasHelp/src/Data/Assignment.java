package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment 
{
	String Name; 
	String Weight; 
	String DueDate; 
	String Description; 
	String LearningOutcomes; 
	String Group; 
	String HTMLdescription; 
	final String OLD_FORMAT = "HH:mm d MMM yyyy";
	final String NEW_FORMAT = "yyyy-MM-dd'T'HH:mm:00'Z'";

	public Assignment() 
	{
		
	}
	
	public Assignment(String name, String weight, String duedate, String description, String learning, String grouping ) 
	{
		 Name=name; 
		 Weight=weight; 
		 DueDate=duedate; 
		 Description=description; 
		 LearningOutcomes=learning; 
		 Group=grouping; 
	}
	

	public void setname(String namer)
	{
		Name=namer.trim(); 
	}
	
	public void othersetname(String namer)
	{
		Name=namer; 
	}
	
	public String getname()
	{

		return Name; 
	}
	
	public void setweight(String weighter)
	{
		Weight=weighter.trim(); 
		Weight=removeLastChar(Weight);
	}
	
	public String getweight()
	{

		return Weight; 
	}
	
	public void setduedate(String date)
	{
		DueDate=date.trim(); 
		
		if(DueDate.equals("N/A"))
		{
		
		}
		else
		{
			DueDate=removeCharAt(DueDate, 11); 
			DueDate=removeCharAt(DueDate, 11); 
			
			DueDate=removeCharAt(DueDate, 5); 
			DueDate=removeCharAt(DueDate, 5); 
			DueDate=removeCharAt(DueDate, 5); 

			
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d;
			try 
			{
				d = sdf.parse(DueDate);
				sdf.applyPattern(NEW_FORMAT);
				DueDate = sdf.format(d);
			} 
			catch (ParseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		 }
		
		
	}
	
	public String getduedate()
	{

		return DueDate; 
	}
	
	public void setdescription(String desc)
	{
		Description=desc.trim(); 
	}
	
	public String getdescription()
	{

		return Description; 
	}
	
	public void setlearningoutcomes(String learn)
	{
		LearningOutcomes=learn.trim(); 
	}
	
	public String getlearningoutcomes()
	{

		return LearningOutcomes; 
	}
	
	public void setGroup(String grou)
	{
		Group=grou.trim(); 
	}
	
	public String getGroup()
	{

		return Group; 
	}
	
	public String getformatteddescription()
	{
		HTMLdescription=
        "<p><b>Weighting (Percent of final grade):</b> <br>"+Weight+"Percent"+"</p>"
	    +"<p><b>Description of Assignment:</b> <br>"+Description+"</p>"
        +"<p><b>Learning Outcomes Targeted:</b><br>"+LearningOutcomes+"</p>";
	    
        return HTMLdescription; 
	}
	
	public String removeLastChar(String s) 
	{
	    if (s == null || s.length() == 0) {
	        return s;
	    }
	    return s.substring(0, s.length()-1);
	}
	
	public static String removeCharAt(String s, int pos) 
	    {
		   return s.substring(0,pos)+s.substring(pos+1);
		}
	
	public boolean isduedateactive()
	{
		if (DueDate.equals("N/A"))
		{
			return false; 
		}
		else
		{
			return true; 
		}
		
	}

}
