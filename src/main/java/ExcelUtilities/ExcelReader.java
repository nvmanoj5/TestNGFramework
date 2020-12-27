package ExcelUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public XSSFWorkbook workbook;
	
	public XSSFSheet sheet;
	
	public ExcelReader(String excelpath) throws IOException{
	
		File filename= new File(excelpath);
		FileInputStream fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);
	}
	
	public String getTestData(String sheetname,int row,int column) {
		
		sheet = workbook.getSheet(sheetname);
		String returnData = sheet.getRow(row).getCell(column).getStringCellValue();
		return returnData;
	}
	
	public int fetchRowcount(String sheetname) {
		int rows = workbook.getSheet(sheetname).getLastRowNum();
		rows = rows+1;
		return rows;
	}
	
	public int fetchColumncount(String sheetname) {
		int coulmns = workbook.getSheet(sheetname).getColumnWidth(0);
		coulmns = coulmns+1;
		return coulmns;
	}

}
