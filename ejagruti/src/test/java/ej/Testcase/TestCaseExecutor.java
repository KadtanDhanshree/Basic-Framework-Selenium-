package ej.Testcase;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import ej.Generic.XMLOperations;

public class TestCaseExecutor
{
	private static String GetBackgroundTestCaseName(String TestCaseFilePath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		XMLOperations xmlobj=new XMLOperations(TestCaseFilePath);
		String value=xmlobj.GetText("//TESTCASE//BACKGROUND//text()");
		return value;
	}
	
	private static String GetFilePathWhereFilenameStartsWith(final String StartingWord,String SourceFolderPath)
	{
		String output="";
	    File f=new File(SourceFolderPath);
	    File[] matchingFiles = f.listFiles(new FilenameFilter() 
	    {
	    	public boolean accept(File dir, String name) 
	    	{
	            return name.startsWith(StartingWord);
	        }
	    });

	    for (int i = 0; i < matchingFiles.length; i++)
	    {
	        output+=matchingFiles[i]+"\n";
	    }
	    return output;	
	}
	
	private static boolean IsThisADataDrivenTestCase(String TestCaseFilePath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		boolean isdatadrivenTC = false;
		XMLOperations xmlop= new XMLOperations(TestCaseFilePath);
		String TestData = xmlop.GetText("//TESTCASE/ITERATION/@TESTDATA");
		
		if(TestData.equalsIgnoreCase("NA"))
		{
			 isdatadrivenTC = false;
		}
		else
		{
			isdatadrivenTC = true;
		}
		return isdatadrivenTC;
	}
	
	private static String[] GetTestCaseDetails(String TestCaseFilePath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		System.out.println("*** GetTestCaseDetails ***" );
		
		String[] tcDetails=new String[6];
		XMLOperations xmlop= new XMLOperations(TestCaseFilePath);
		
		tcDetails[0]=xmlop.GetText("TESTCASE/DETAILS/MANUAL_TEST_CASE_ID/text()");
		String tc1=tcDetails[0];
		System.out.println("MANUAL_TEST_CASE_ID: "+tc1);
		
		tcDetails[1]=xmlop.GetText("TESTCASE/DETAILS/MODULE/text()");
		String tc2=tcDetails[1];
		System.out.println("MODULE: "+tc2);
		
		tcDetails[2]=xmlop.GetText("TESTCASE/DETAILS/OWNER/text()");
		String tc3=tcDetails[2];
		System.out.println("OWNER: "+tc3);
		
		tcDetails[3]=xmlop.GetText("TESTCASE/DETAILS/CREATION_DATE/text()");
		String tc4=tcDetails[3];
		System.out.println("CREATION_DATE: "+tc4);
		
		tcDetails[4]=xmlop.GetText("TESTCASE/DETAILS/SUMMARY/text()");
		String tc5=tcDetails[4];
		System.out.println("SUMMARY: "+tc5);

		return tcDetails;
	}
	
	private static int GetTotalNoOfSteps(String TestCaseFilePath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		System.out.println("*** Total No Of Steps ***"+"\n");

		int totalnoofsteps=0;
		XMLOperations xmlop= new XMLOperations(TestCaseFilePath);
		totalnoofsteps=xmlop.GetNumberOfChildElements("TESTCASE/ITERATION/STEPS/ITERATION/STEP" );
		System.out.println("TotalNoOfSteps:"+totalnoofsteps);

		return totalnoofsteps;
	}
	
	public static void main(String[]args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		String bkTestcaseName=GetBackgroundTestCaseName("C:\\Users\\SUNNY COMP\\Desktop\\Testing\\TestCases-XML\\TC003_CreateCompany_SUMMARY.xml");
		System.out.println("bkTestcaseName: "+bkTestcaseName+"\n");
		
		String filepath=GetFilePathWhereFilenameStartsWith("TC","C:\\Users\\SUNNY COMP\\Desktop\\Testing\\TestCases-XML");
		System.out.println("path:" +filepath+"\n");
		
		boolean isdatadriven=IsThisADataDrivenTestCase("C:\\Users\\SUNNY COMP\\Desktop\\Testing\\TestCases-XML\\TC003_CreateCompany_SUMMARY.xml");
		System.out.println("IsDataDriven:"+isdatadriven+"\n");
		
		GetTestCaseDetails("C:\\Users\\SUNNY COMP\\Desktop\\Testing\\TestCases-XML\\TC003_CreateCompany_SUMMARY.xml");
		//System.out.println(tcDetails);
		
		GetTotalNoOfSteps("C:\\Users\\SUNNY COMP\\Desktop\\Testing\\TestCases-XML\\TC003_CreateCompany_SUMMARY.xml");

	}

}
