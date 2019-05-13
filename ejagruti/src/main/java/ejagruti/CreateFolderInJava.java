 package ejagruti;
import java.io.File;

public class CreateFolderInJava 
{
	public static void writeRequestAndResponse() 
	{			        
	        String folderPath = "E:\\Automation testing\\ORIFLAME\\OP_GENERATED\\S";
	        File theDir = new File(folderPath);

	        // if the directory does not exist, create it
	        if (!theDir.exists()) 
	        {	        	
	            System.out.println("creating directory: " + theDir.getName());
	            boolean result = false;

	            try
	            {
	                theDir.mkdirs();
	                result = true;
	            }
	            
	            catch (SecurityException se) 
	            {      // handle it
	                System.out.println(se.getMessage());
	            }
	            
	            if (result) 
	            {
	                System.out.println("Folder created");
	            }
	        } 
	        else if (theDir.exists()) 
	        {
	            System.out.println("Folder exist");
	        }
	}
	public static void main(String[]args)
	{
		CreateFolderInJava.writeRequestAndResponse();
		
	}
}
