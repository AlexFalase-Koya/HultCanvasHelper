package Data;

public class Course 
{
	
	String Name;
	String SISID; 
	Assignment [] Courseassignments;
	String Term; 

	public Course() 
	{
		
	}
	
	public Course(String name, String SISId) 
	{
		Name=name; 
		SISID=SISId; 
	
	}
	

	public void setname(String namer)
	{
		Name=namer; 
	}
	
	public String getname()
	{

		return Name; 
	}
	
	public void setterm(String Termer)
	{
		Term=Termer; 
	}
	
	public String getterm()
	{

		return Term; 
	}
	
	public void setsis(String string)
	{
		SISID=string; 
	}
	
	public String getsis()
	{

		return SISID; 
		
	}
	
	public void setassignmentarray(int amountofassignments)
	{
		Courseassignments=new Assignment [amountofassignments]; 
		
		for (int i=0; i < Courseassignments.length; i++) 
		{
			Courseassignments[i] = new Assignment();
	    }
		
	}
	
	public void setarray(Assignment [] assignments)
	{
		Courseassignments=assignments; 
		

		
	}
	
	public void setdirectarray(int where, String what)
	{
		Courseassignments[where].othersetname(what); 
		

		
	}
	
	public String getdirectarrayname(int where)
	{
		return Courseassignments[where].getname(); 
		
	}
	
	public Assignment [] getassignments()
	{

		return Courseassignments; 
		
	}


}
