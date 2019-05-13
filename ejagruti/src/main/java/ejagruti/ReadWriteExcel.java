package ejagruti;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadWriteExcel
{
	public static void main(String[] args) throws IOException
	{
		
		FileInputStream file=new FileInputStream(new File("E:\\Automation testing\\ReadExelData.xlsx")); 
		XSSFWorkbook workbook=new XSSFWorkbook(file); 
		XSSFSheet sheet=workbook.getSheetAt(0);
				
		//Read Operations
		
		String cellval=sheet.getRow(0).getCell(2).toString();
		System.out.println("cellvalue @(0)(2) : "+cellval);
		
		int lastrowNo=sheet.getLastRowNum();
		System.out.println("Last row No: "+lastrowNo);

		int val=sheet.getRow(1).getLastCellNum();
		System.out.println("Last Cell No: "+val);
		
		int val1=sheet.getLastRowNum();
		System.out.println("Last row No: "+val1);
		
		String cellval1=sheet.getRow(0).getCell(3).toString();
		System.out.println("cellvalue @(0)(4): "+cellval1);
		
		//Write(replace cell value)
		sheet.getRow(1).getCell(1).setCellValue("ejagruti");
		
		try(FileOutputStream outputStream= new FileOutputStream("E:\\Automation testing\\ReadExelData.xlsx"))
		{
			workbook.write(outputStream);
			
		}		
		
		
	}
}
