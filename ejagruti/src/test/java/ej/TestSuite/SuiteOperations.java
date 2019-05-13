package ej.TestSuite;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;
import ej.Generic.XMLOperations;
import ej.configuration.Config;

public class SuiteOperations 
{
	public static String[] GetAllTestCases(String TestSuiteName,String isMarkedForExecution) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
	{
		String[] str = null;
		String str1=null;
		String str2=null;
		//String name=TestSuiteName;
		String cocncat  = Config.TEST_SUITE_FOLDER  +TestSuiteName;
		XMLOperations xmlop=new XMLOperations( cocncat);
		int cnode=xmlop.GetNumberOfChildElements("/SUIT");
		
		System.out.println("Child Elements are:"+cnode);
		str=new String[] {};
		int j=0;

		for(int i=0;i<cnode;i++)
		
			str1=xmlop.GetText("/SUIT/TESTCASE["+(i+1)+"]/@EXECUTE");
			if(str1.equalsIgnoreCase(isMarkedForExecution))
			{
				int i = 0;
				str=Arrays.copyOf(str,str.length+1);
				str2=xmlop.GetText("/SUIT/TESTCASE["+(i+1)+"]");
				str[j]=str2;
				j=j+1;
			}
		
		return str;
	}
}
