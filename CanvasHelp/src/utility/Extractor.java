package utility;

public class Extractor 
{
	String FullString; 
	int count=0; 
	String [] holder; 

	public Extractor(String str) 
	{
		FullString=str; 
	}
	
	public void Stringreplacement(String str) 
	{
		FullString=str; 
		
	}
	
	public int count(String find)
	{
	      int index = 0;
	        do {
	                index  = FullString.indexOf(find, index);
	                if ( index == -1 ) 
	                {
	                	holder=new String[count]; 
	                        return count;
	                }
	                index += find.length();
	                count++;
	        } while( true );
	}
	
	public String [] getter(String Starter, String Ender)
	{
		 int ind=0;
		 int start = 0;
		 int end=0;
		 
		  while (true) 
		  {
		    int found = FullString.indexOf(Starter, start)+Starter.length();
		    int foundend = FullString.indexOf(Ender, end);
		    if (found != -1&&foundend!=-1)
		    {
		    	             
		    			    	holder[ind]=FullString.substring(found,foundend); 
		    			    	System.out.println(holder[ind]);

		    	ind++;
		    }
		    if (found == -1||foundend==-1) 
		        {
		    	break;
		    	}
		  
		    start = found+40 ;
		    end=foundend+40; 
		  
		  }
		  
		  return holder;
	}

}
