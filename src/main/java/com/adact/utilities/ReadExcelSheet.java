 package com.adact.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet 
{
	public static FileInputStream fis=null;
	public static XSSFWorkbook workbook;
	public static Object[][] obj=null;
	public static String cellvalue;
	
	public static Object[][] readExcelSheet(String path)
	{
		
		try 
		{
			fis=new FileInputStream(new File(path));
			workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("testdata");
			obj=new Object[sheet.getLastRowNum()-2][sheet.getRow(0).getLastCellNum()];
			for (int i = 1; i < sheet.getLastRowNum(); i++) 
			{
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) 
				{
					XSSFCell cell = row.getCell(j);
//					String stringCellValue = cell.getStringCellValue();
					if(cell.getCellType()==CellType.STRING)
					{
						cellvalue=cell.getStringCellValue();
					}
					else if(cell.getCellType()==CellType.NUMERIC)
					{
						long num=(long)cell.getNumericCellValue();
						cellvalue=String.valueOf(num);
					}
					obj[i-1][j]=cellvalue;
					System.out.println(cellvalue);
				}	
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return obj;
	}
	
//	public static void main(String[] args)
//	{
//		ReadExcelSheet.readExcelSheet(System.getProperty("user.dir")+"\\src\\main\\java\\com\\adact\\excel\\testdata.xlsx");
//	}
}
