package Data;

public class Token extends Informtion 
{
	String Name;
	String Token; 
	String Lastcourselistupdated; 
	

	public Token() 
	{
		Header ="Name,Token,Last Course Update"; 
	}
	
	public String getheaders()
	{
		return Header; 
	}


	public void setname(String namer)
	{
		Name=namer; 
	}
	
	public String getname()
	{

		return Name; 
	}
	
	public void settoken(String Tokener)
	{
		Token=Tokener; 
	}
	
	public String gettoken()
	{

		return Token; 
	}
	
	public void setlastupdated(String last)
	{
		Lastcourselistupdated=last; 
	}
	
	public String getlastupdated()
	{

		return Lastcourselistupdated; 
	}






}
