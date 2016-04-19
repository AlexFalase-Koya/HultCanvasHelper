package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Data.Assignment;
import Data.Course;

public class Assignmentformer 
{
    String str;
    String findStr = "Assignment Breakdown";
    int lastIndex = 0;
    int count = 0;
    
    int numberofassignements; 
    Assignment[]assignments;
    Course mycourse; 
    
	public Assignmentformer() 
	{

	}
	
	 public Assignment[] extractusefuldata(String extractedText, Course arrayer )
	    {
		    mycourse=arrayer; 
	    	String pattern1 = "means of assessment:";
	    	String pattern2 = "HULT Class Participation Rubric ";
	    

	    	Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
	    	Matcher m = p.matcher(extractedText);
	    	while (m.find()) 
	    	{
	    	//  System.out.println(m.group(1));
	    	  str=m.group(1);
	    	}
	    	mycourse.setassignmentarray(count(str, "Assignment Breakdown"));
	    	assignments=mycourse.getassignments();
	    
	    	Assignmentscreator();
	        
	    	return assignments; 
	    }
	 
	 public static int count(String str, String find) 
	 {
	        int index = 0, count = 0;
	        do {
	                index  = str.indexOf(find, index);
	                if ( index == -1 ) {
	                        return count;
	                }
	                index += find.length();
	                count++;
	        } while( true );
	  }
	 
	 public void Findassignmentcount()
	    {
		  while (lastIndex != -1) 
	{
	          lastIndex = str.indexOf(findStr,lastIndex);

	           if( lastIndex != -1)
	                count++;

	           lastIndex += findStr.length();
	    }

	    System.out.println(count);
	    numberofassignements=count; 
	    
	    }
	 
	 public void Assignmentscreator()
	    {
		
		
		
			 setname(str); 
			 setweight(str); 
			 setduedate(str);
			 setdescription(str);
			 setlearningoutcomes(str);
			 setGroup(str);
			 
		
			 
			 for(int i=0;i<count;i++)
			 {
				// System.out.println("fhgfhchg");
				 System.out.println(assignments[i].getname());
				 System.out.println(assignments[i].getweight());
				 System.out.println(assignments[i].getduedate());
				 System.out.println(assignments[i].getdescription());
				 System.out.println(assignments[i].getlearningoutcomes());
				 System.out.println(assignments[i].getGroup());
			 }
		 
		 
	    }
	 
	 public void setname(String stringer)
	 {
		 int ind=0;
		 int start = 0;
		 int end=0;
		  while (true) 
		  {
		    int found = stringer.indexOf("Assignment:", start)+11;
		    int foundend = stringer.indexOf("Description of Assignment:", end);
		    if (found != -1&&foundend!=-1)
		    {
		    	
		    	assignments[ind].setname(stringer.substring(found,foundend)); 
		    	ind++;
		    }
		    if (found == -1||foundend==-1) 
		        {
		    	break;
		    	}
		  
		    start = found + 40;
		    end=foundend+40; 
		  
		  }

	 }
	 
	 public void setweight(String stringer)
	 {
		 int ind=0;
		 int start = 0;
		 int end=0;
		  while (true) 
		  {
		    int found = stringer.indexOf("Percentage:", start)+11;
		    int foundend = stringer.indexOf("Due Date", end);
		    if (found != -1&&foundend!=-1)
		    {
		    	
		    	
		    	assignments[ind].setweight(stringer.substring(found,foundend)); 
		    	ind++;
		    }
		    if (found == -1||foundend==-1) break;
		    start = found + 40;
		    end=foundend+40; // move start up for next iteration
		  }

	 }
	 
	 public void setduedate(String stringer)
	 {
		 int ind=0;
		 int start = 0;
		 int end=0;
		  while (true) 
		  {
		    int found = stringer.indexOf("Due Date:", start)+9;
		    int foundend = stringer.indexOf("Learning Outcomes Targeted:", end);
		    if (found != -1&&foundend!=-1)
		    {
		    	
		    	
		    	assignments[ind].setduedate(stringer.substring(found,foundend)); 
		    	ind++;
		    }
		    if (found == -1||foundend==-1) break;
		    start = found + 40;
		    end=foundend+40; 
		   // move start up for next iteration
		  }

	 }
	 
	 public void setdescription(String stringer)
	 {
		 int ind=0;
		 int start = 0;
		 int end=0;
		  while (true) 
		  {
		    int found = stringer.indexOf("Description of Assignment:", start)+26;
		    int foundend = stringer.indexOf("Percentage:", end);
		    if (found != -1&&foundend!=-1)
		    {
		    	
		    	
		    	assignments[ind].setdescription(stringer.substring(found,foundend)); 
		    	ind++;
		    }
		    if (found == -1||foundend==-1) break;
		    start = found + 40;
		    end=foundend+40;  // move start up for next iteration
		  }

	 }
	 
	 public void setlearningoutcomes(String stringer)
	 {
		 int ind=0;
		 int start = 0;
		 int end=0;
		  while (true) 
		  {
		    int found = stringer.indexOf("Learning Outcomes Targeted:", start)+27;
		    int foundend = stringer.indexOf("Type:", end);
		    if (found != -1&&foundend!=-1)
		    {
		    	
		    	
		    	assignments[ind].setlearningoutcomes(stringer.substring(found,foundend)); 
		    	ind++;
		    }
		    if (found == -1||foundend==-1) break;
		    start = found + 40;
		    end=foundend+40;  // move start up for next iteration
		  }

	 }
	 
	 public void setGroup(String stringer)
	 {
		 int ind=0;
		 int start = 0;
		 int end=0;
		  while (true) 
		  {
		    int found = stringer.indexOf("Type:", start)+5;
		    int foundend = stringer.indexOf("Rubric:", end);
		    if (found != -1&&foundend!=-1)
		    {
		    	
		    
		    	 
		    	assignments[ind].setGroup(stringer.substring(found,foundend)); 
		    	ind++;
		    }
		    if (found == -1||foundend==-1) break;
		    start = found + 40;
		    end=foundend+40;  // move start up for next iteration
		  }

	 }
	 
	
	 

}
