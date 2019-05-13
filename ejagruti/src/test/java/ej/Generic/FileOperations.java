package ej.Generic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JFileChooser;

import org.apache.xmlbeans.impl.store.Path;

import com.google.common.io.Files;

public class FileOperations 
{
	public void CreateChildFolders(String parentfoldername,String childfoldername) throws IOException   //parentfoldername-path of parent folder,childfoldername-name of child folder
	{
		File dir = new File(parentfoldername);
		dir.mkdirs();
		File file = new File(dir, childfoldername);
		file.mkdir();
	}

	public void CreateTextFile( String fullFilepathWithName)  //fullFilepathWithName-file path with file name
	{
		try
		{
            // Create new file
             File file = new File(fullFilepathWithName);
             // If file doesn't exists, then create it
            if (!file.exists()) 
            {
                file.createNewFile();
                System.out.println("File Created");
            }
            else
            {
                System.out.println("File already exists ");            	
            }
    }
        catch(Exception e)
		{
            System.out.println(e);
        }
	}

	public void CreateTextFile(String fpath, String appendText)  //fpath-file path with filename,appendText-text tobe written in file
	{
		try
		{
		    String filename= fpath;
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(appendText);//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}

	public String GetCurrentDateAsperGivenFormat(String dateformat)  //dateformat-date timestamp format ex.yyyy-MM-dd HH:mm:ss
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateformat);
		LocalDateTime now = LocalDateTime.now();
		String cdate=dtf.format(now);
		//System.out.println(dtf.format(now)); //2016/11/16 12:08:43

		return cdate;
	}
}
	



	

