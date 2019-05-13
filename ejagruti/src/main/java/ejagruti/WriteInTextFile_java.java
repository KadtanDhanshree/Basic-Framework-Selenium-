package ejagruti;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInTextFile_java 
{
	private static final String FILENAME = "E:\\\\Automation testing\\\\ORIFLAME\\\\OP_GENERATED\\\\D\\\\dk.txt";

	public static void main(String[] args) 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) 
		{
			String content = "This is the content to write into file\n";
			bw.write(content);
			// no need to close it.
			// bw.close();
			
			System.out.println("Done");
	} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
