package ej.Generic;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLOperations 
{
	public DocumentBuilderFactory objectDocumentBuilderFactory;
	public DocumentBuilder objectDocumentBuilder;
	public XPath objectXpath = null;
	public Document obejctdocument  = null;
	
	public XMLOperations(String filePath)throws ParserConfigurationException,SAXException,IOException
	{
		objectDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		objectDocumentBuilder = objectDocumentBuilderFactory.newDocumentBuilder();
		obejctdocument = objectDocumentBuilder.parse(filePath);
		objectXpath = XPathFactory.newInstance().newXPath();	
	}
	
	public int GetNumberOfChildElements(String xPath)throws SAXException,ParserConfigurationException,IOException,XPathExpressionException
	{
		System.out.println("*******  GET NUMBER OF CHILD ELEMENT Information******");

		NodeList nodes = (NodeList) ((XPath) objectXpath).compile(xPath).evaluate(obejctdocument, XPathConstants.NODESET);

		int childnodes = nodes.getLength();
		return childnodes;
	}
	
	public String GetText(String xPath) throws SAXException,ParserConfigurationException,IOException,XPathExpressionException
	{		
		System.out.println("\n"+"******* GetText Single value  Information******");
		
	    NodeList nodes = (NodeList) objectXpath.compile(xPath).evaluate(obejctdocument, XPathConstants.NODESET);	
		
		return nodes.item(0).getTextContent();
	}


}
