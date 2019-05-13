package ej.Startup;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ej.Generic.FileOperations;
import ej.Generic.XMLOperations;
import ej.configuration.Config;
import ejagruti.CreateFolderInJava;
import ejagruti.ReadWriteExelUsingFunction;
import ejagruti.XML_Op;

public class Engine 
{
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException
	{
		Config.Init();
		System.out.println("TestSuitPath:"+Config.TEST_SUITE_FOLDER);

	 //	System.out.println(Config.ROOT_FOLDER);
	 	/* 
		//---Unit Testing---
	
	 	System.out.println(Config.IS_LOG_ENABLED);
		System.out.println(Config.IS_RESULT_ENABLED);
		System.out.println(Config.IS_SCREENSHOT_ENABLED);
		System.out.println(Config.EXPLICIT_WAIT_TIMEOUT);
	
		System.out.println(Config.RESULT_FOLDER);
		System.out.println(Config.LOG_FOLDER);
		System.out.println(Config.TEST_SUITE_FOLDER);
		System.out.println(Config.TEST_CASE_FOLDER);
		System.out.println(Config.TESTDATA_LOCATION);
		System.out.println(Config.OP_GENERATED);
		System.out.println(Config.DB_NAME);
		System.out.println(Config.PORT_NUMBER);
		System.out.println(Config.DB_USERNAME);
		System.out.println(Config.DB_PASSWARD);
		*/
		
	/*	
	 * ---Check(Print) inputs from Client(Written in Settings.properties)---
	 
	    String log=	Config.getParameterValue("IS_LOG_ENABLED");
		
		System.out.println(log);
	
		String res=	Config.getParameterValue("IS_RESULT_ENABLED");
		System.out.println(res);
		IS_LOG_ENABLED=Config.getParameterValue("IS_LOG_ENABLED"));
		
		String screenshot=	Config.getParameterValue("IS_SCREENSHOT_ENABLED");
		System.out.println(screenshot);
		
		String tout= Config.getParameterValue("EXPLICIT_WAIT_TIMEOUT");
		System.out.println(tout);
		
		String path= Config.getParameterValue("ROOT_FOLDER");
		System.out.println(path);		
		*/		
		
		/*
		int rcount=ReadWriteExelUsingFunction.GetTotalRowCount("E:\\Automation testing\\ReadExelData.xlsx", 0);
		System.out.println("TotalRowCount: "+rcount);
		
		int rcount1=ReadWriteExelUsingFunction.GetRowCount("E:\\Automation testing\\ReadExelData.xlsx", "Sheet1");
		System.out.println("TotalRowCount: "+rcount1);
		
		int colcount=ReadWriteExelUsingFunction.GetColumnCount("E:\\Automation testing\\ReadExelData.xlsx",0,1);
		System.out.println("Total ColumnCount: "+colcount);
		
		int colcount1=ReadWriteExelUsingFunction.GetColumnCount("E:\\Automation testing\\ReadExelData.xlsx", "Sheet1", 1);
		System.out.println("Total ColumnCount: "+colcount1);
		
		String celldata=ReadWriteExelUsingFunction.GetCellData("E:\\Automation testing\\ReadExelData.xlsx", 0,3,0);
		System.out.println("Cell Data: "+celldata);
		
		String celldata1=ReadWriteExelUsingFunction.GetCellData("E:\\Automation testing\\ReadExelData.xlsx", "Sheet1", 3,1);
		System.out.println("Cell Data: "+celldata1);
		
		ReadWriteExelUsingFunction.SetCellData("E:\\Automation testing\\ReadExelData.xlsx", 0, 3, 2, "Automation");
		
		ReadWriteExelUsingFunction.SetCellData("E:\\Automation testing\\ReadExelData.xlsx", "Sheet1", 3, 3, "Testing");
				
		
		XML_Op xmlobj=new XML_Op("C:\\Users\\SUNNY COMP\\Desktop\\Testing\\XML\\DemoLogin.xml");
		
		String t=xmlobj.GetText("TESTCASE/STEPS/STEP/METHOD/text()");
		System.out.println(t);
		
		String t1=xmlobj.GetText("TESTCASE/STEPS/STEP[2]/METHOD/text()");
		System.out.println(t1);
				
		System.out.println(xmlobj.GetNumberOfChildElements("TESTCASE/STEPS/STEP/METHOD/text()"));
		*/
		
		//CreateFolderInJava.writeRequestAndResponse();  //creating folder using java
		
		// *** File Operations ***
		
		FileOperations fop=new FileOperations();
		fop.CreateChildFolders("E:\\Automation testing\\ORIFLAME\\OP_GENERATED\\D","NewFolder");
		
		fop.CreateTextFile("E:\\Automation testing\\ORIFLAME\\OP_GENERATED\\D\\createNewFile.txt");
		fop.CreateTextFile("E:\\Automation testing\\ORIFLAME\\OP_GENERATED\\D\\createNewFile.txt", " Dhanshree...");
		//String k=fop.GetCurrentDateAsperGivenFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println("date"+k);
		
		//*** xml operations ***
		XMLOperations xmlop=new XMLOperations("C:\\Users\\SUNNY COMP\\Desktop\\Testing\\XML\\DemoLogin.xml");
		System.out.println(xmlop.GetNumberOfChildElements("TESTCASE/STEPS/STEP/METHOD/text()"));		
		String t1=xmlop.GetText("TESTCASE/STEPS/STEP[2]/METHOD/text()");
		System.out.println(t1);
		
		
		
		}
	}

