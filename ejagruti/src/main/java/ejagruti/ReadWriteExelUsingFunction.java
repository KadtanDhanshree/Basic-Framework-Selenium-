package ejagruti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExelUsingFunction
{
	public static int GetTotalRowCount(String filename,int sheetno ) throws IOException
	{
		FileInputStream file=new FileInputStream(new File("E:\\Automation testing\\ReadExelData.xlsx")); 
		XSSFWorkbook workbook=new XSSFWorkbook(file); 
		XSSFSheet sheet=workbook.getSheetAt(sheetno);
		int rowCount=sheet.getLastRowNum();
		return rowCount+1;
	}
	
	public static int GetRowCount(String filename, String sheetname) throws IOException
	{
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		int rowcount= worksheet.getLastRowNum();
		return rowcount+1;
	}
	
	public static int GetColumnCount(String filename, int sheetno, int rowno) throws IOException 
	{
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		int colcount= worksheet.getRow(rowno).getLastCellNum();
		return colcount;
	}
	
	public static int GetColumnCount(String filename, String sheetname, int rowno) throws IOException 
	{
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		int colcount= worksheet.getRow(rowno).getLastCellNum();
		return colcount;
	}
	
	public static String GetCellData(String filename,int sheetno, int colno, int rowno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		String cellstring= worksheet.getRow(rowno).getCell(colno).getStringCellValue();
		return cellstring;
	}
	
	public static String GetCellData(String filename, String sheetname, int colno, int rowno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		String cellstring= worksheet.getRow(rowno).getCell(colno).getStringCellValue();
		return cellstring;		
	}
	
	 public static void SetCellData(String filename, int sheetno,int colno,int rowno,String datastring) throws IOException
	{
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		
		XSSFRow row= worksheet.createRow(rowno);
		XSSFCell cell = row.createCell(colno);
		cell.setCellValue(datastring);
		FileOutputStream fileout= new FileOutputStream(filename);
		workbook.write(fileout);		
	}
	
	public static void SetCellData(String filename, String sheetname,int colno,int rowno,String datastring) throws IOException
	{	
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		XSSFRow row= worksheet.createRow(rowno);
		XSSFCell cell = row.createCell(colno);
		cell.setCellValue(datastring);
		FileOutputStream fileout= new FileOutputStream(filename);
		workbook.write(fileout);
		//cell.getCellComment();
	}
	
/*Do it Later
 * 	public static Hashtable<Integer, String[]> ReadAllExcelFile(String filename, int sheetno) throws IOException{
		 Hashtable<Integer,String[]> readexcel=new Hashtable<Integer,String[]>();
		 
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		int usedrows= worksheet.getLastRowNum();
		
		for(int i=0;i<=usedrows;i++)
			{
			int usedcolnum= worksheet.getRow(i).getLastCellNum();//getCell(colno).getStringCellValue();
			String[] rowarr=new String[usedcolnum];	
			for(int j=0;j<usedcolnum;j++)
				{
				XSSFCell cellstring1 =worksheet.getRow(i).getCell(j);
				if(cellstring1!=null)
				{
				String cellstring=cellstring1.toString();
				rowarr[j]=cellstring;
				//readexcel.put(j,cellstring);
				} else
					{
					String cellstring="";
					rowarr[j]=cellstring;
					} 
				}
				readexcel.put(i,rowarr);	
				//System.out.println(Arrays.toString(rowarr));		
			//System.out.println(readexcel);
			System.out.println(Arrays.toString(readexcel.get(i)));
		}	
	
	}*/
}