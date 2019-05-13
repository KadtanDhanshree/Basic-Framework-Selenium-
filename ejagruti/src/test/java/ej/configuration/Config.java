 package ej.configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.util.SystemOutLogger;
import org.apache.xmlbeans.impl.store.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import ej.Generic.FileOperations;
import ej.Startup.Engine;
import ej.TestSuite.SuiteOperations;
import ej.Testcase.TestCaseExecutor;

public class Config
{
	public static WebDriver driver=null;	

	public static WebDriver driverchrome=null;
	public static WebElement element=null;
	public static int tabnumber=1;
	
	
	public static WebDriverWait wait=null;
	
	//------------------------
	public static String ROOT_FOLDER=null;
	public static String IS_LOG_ENABLED =  null;
	public static String IS_RESULT_ENABLED = null;
	public static  String IS_SCREENSHOT_ENABLED = null;
	public  static int EXPLICIT_WAIT_TIMEOUT=0;
	//-------------------------
	public static String RESULT_FOLDER=null;
	public static String LOG_FOLDER=null;
	public static String TEST_SUITE_FOLDER=null;
	public static String TEST_CASE_FOLDER=null;
	public static String TESTDATA_LOCATION=null;
	public static String OP_GENERATED=null;
	public static String DB_NAME=null;
	public  static int PORT_NUMBER=0;
	public static String DB_USERNAME=null;
	public static String DB_PASSWARD=null;
	
	public static void Init() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{		
		ROOT_FOLDER =getParameterValue("ROOT_FOLDER");
		//System.out.println(ROOT_FOLDER);
					
		IS_LOG_ENABLED=getParameterValue("IS_LOG_ENABLED"); 
		IS_RESULT_ENABLED=getParameterValue("IS_RESULT_ENABLED");
		IS_SCREENSHOT_ENABLED=	getParameterValue("IS_SCREENSHOT_ENABLED");		
		EXPLICIT_WAIT_TIMEOUT=Integer.valueOf(getParameterValue("EXPLICIT_WAIT_TIMEOUT"));
		
		RESULT_FOLDER =getParameterValue("RESULT_FOLDER");
		LOG_FOLDER =getParameterValue("LOG_FOLDER");
		TEST_SUITE_FOLDER =getParameterValue("TEST_SUITE_FOLDER");
		TEST_CASE_FOLDER =getParameterValue("TEST_CASE_FOLDER");
		TESTDATA_LOCATION =getParameterValue("TESTDATA_LOCATION");
		OP_GENERATED =getParameterValue("OP_GENERATED");
		DB_NAME =getParameterValue("DB_NAME");
		PORT_NUMBER=Integer.valueOf(getParameterValue("PORT_NUMBER"));
		DB_USERNAME =getParameterValue("DB_USERNAME");
		DB_PASSWARD =getParameterValue("DB_PASSWARD");
		
		
		FileOperations fo=new FileOperations();
		
		String dt1=fo.GetCurrentDateAsperGivenFormat("yyyy-MM-dd HH.mm.ss");
				
		fo.CreateChildFolders(ROOT_FOLDER,dt1);
		
		fo.CreateChildFolders(ROOT_FOLDER+"\\"+ dt1, "Logs");
		fo.CreateChildFolders(ROOT_FOLDER+"\\"+ dt1, "Screenshot");
		fo.CreateChildFolders(ROOT_FOLDER+"\\"+ dt1, "Result");
		
		//SuiteOperations sutop=new SuiteOperations();
		
		SuiteOperations.GetAllTestCases("/TestSuit.xml", "Y");
	}
		
	private String getParameterValue_child(String parametername) throws IOException
	{
		InputStream input=null;
		Properties prop=new Properties();
		
		input=getClass().getClassLoader().getResourceAsStream("Settings.properties");
		prop.load(input);		
		String parameterValue=prop.getProperty(parametername);
		return parameterValue;
	}
	
	public static String getParameterValue(String parametername) throws IOException
	{
		Config pf = new Config();
		
		return pf.getParameterValue_child(parametername);
	}	
}
