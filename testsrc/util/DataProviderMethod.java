package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderMethod {


	public static Object[][] testData(String filePath,String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][colCount];
		
		for(int i=0;i<rowCount-1;i++) // for traversing array
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<colCount;j++)
			{
				XSSFCell element = row.getCell(j);
				if(element==null)
					data[i][j] = ""; // if cell is blank
				else
				{
					element.setCellType(CellType.STRING);
					data[i][j] = element.getStringCellValue();
				}
				
			}
		}
		return data;
		
	}

}
