package utility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Data.Assignment;
import Data.Course;

public class courselistformer 
{
    String str;
    String findStr = "sis_course_id";
    int lastIndex = 0;
    int count = 0;
    
    int numberofassignements; 
    ArrayList<Course> thecoursearray = new ArrayList<Course>();
    Course mycourse; 
    

	public courselistformer() 
	{
		// TODO Auto-generated constructor stub
	}
	
	 public ArrayList<Course> extractusefuldata(String extractedText, Course arrayer, String strformer )
	    {
		    mycourse=arrayer; 
		    str=strformer;

	    	//mycourse.setassignmentarray(count(str, "Assignment Breakdown"));
	    //	assignments=mycourse.getassignments();
	    
	    	Assignmentscreator();
	        
	    	return thecoursearray; 
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
	 
	 public void Assignmentscreator()
	    {
		
		
		
			// setname(str); 
			// setweight(str); 
			// setduedate(str);
			// setdescription(str);
			// setlearningoutcomes(str);
			// setGroup(str);
			 
		
			 
			 for(int i=0;i<count;i++)
			 {
				// System.out.println("fhgfhchg");
			//	 System.out.println(assignments[i].getname());
			//	 System.out.println(assignments[i].getweight());
			//	 System.out.println(assignments[i].getduedate());
			//	 System.out.println(assignments[i].getdescription());
			//	 System.out.println(assignments[i].getlearningoutcomes());
		//		 System.out.println(assignments[i].getGroup());
			 }
		 
		 
	    }

}
