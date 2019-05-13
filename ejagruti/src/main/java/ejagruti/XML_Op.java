package ejagruti;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
//import javax.xml.xpath.XPathExpression;

//import java.io.File;
import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Date;
//import java.text.SimpleDateFormat;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.apache.xerces.impl.xpath.XPath;
//import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;

//import com.gargoylesoftware.htmlunit.javascript.host.XPathExpression;

public class XML_Op 
{

	public DocumentBuilderFactory objectDocumentBuilderFactory;
	public DocumentBuilder objectDocumentBuilder;
	public XPath objectXpath = null;
	public Document obejctdocument  = null;

	public XML_Op(String xmlPath)throws ParserConfigurationException,SAXException,IOException
	{
		objectDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		objectDocumentBuilder = objectDocumentBuilderFactory.newDocumentBuilder();
		obejctdocument = objectDocumentBuilder.parse(xmlPath);
		objectXpath = XPathFactory.newInstance().newXPath();	
	}
	
	public String GetText(String xPath) throws SAXException,ParserConfigurationException,IOException,XPathExpressionException
	{		
		System.out.println("******* GetTextSingle value  Information******");
		
	    NodeList nodes = (NodeList) (objectXpath).compile(xPath).evaluate(obejctdocument, XPathConstants.NODESET);	
		
		return nodes.item(0).getTextContent();
	}

	public int GetNumberOfChildElements(String xPath)throws SAXException,ParserConfigurationException,IOException,XPathExpressionException
	{
		System.out.println("*******  GET NUMBER OF CHILD ELEMENT Information******");

		NodeList nodes = (NodeList) ((XPath) objectXpath).compile(xPath).evaluate(obejctdocument, XPathConstants.NODESET);

		int childnodes = nodes.getLength();
		return childnodes;
	}
	


	
	
}
