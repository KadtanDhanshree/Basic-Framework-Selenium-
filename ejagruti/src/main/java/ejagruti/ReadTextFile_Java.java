package ejagruti;
import java.io.*; 

public class ReadTextFile_Java 
{
		public static void main(String[] args)throws Exception 
		  { 
		  // We need to provide file path as the parameter: 
		  // double backquote is to avoid compiler interpret words 
		  // like \test as \t (ie. as a escape sequence) 
		  
			File file = new File("E:\\Automation testing\\ORIFLAME\\OP_GENERATED\\D\\dk.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) 
		    System.out.println(st); 
	   
	} 

}
