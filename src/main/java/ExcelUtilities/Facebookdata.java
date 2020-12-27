package ExcelUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Facebookdata {
	
	static String sheetName="Login";
	static String path ="";
	static String path2 ="";
	
	@DataProvider(name="FBcredentials")
	public static Object[][] FBdata() throws IOException {

		path =System.getProperty("user.dir")+"\\resources\\Facebook.xlsx";
		
		File file = new File(path);   //creating a new file instance  

	//	File file = new File("C:\\\\Users\\\\Remo\\\\Desktop\\\\Facebook.xlsx");   //creating a new file instance  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheet(sheetName);  
		XSSFRow row = sheet.getRow(0);   
		
		int rowcount = sheet.getLastRowNum();
		int columncount = row.getLastCellNum();
		
		System.out.println(rowcount+"rowcount");
		System.out.println(columncount+"columncount");
		
		Object[][] coulmnData = new Object[rowcount][columncount];
		
		for(int i=1;i<rowcount+1;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				coulmnData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return coulmnData;
	}
	
	@DataProvider(name="FBsignupcredentials")
	public static Object[][] FBsignupdata() throws IOException {
		
		path2 =System.getProperty("user.dir")+"\\resources\\Facebook.xlsx";
		File file1 = new File(path2);   //creating a new file instance  
		FileInputStream fis2 = new FileInputStream(file1);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis2);   
		XSSFSheet sheet = wb.getSheet("Signup");  
		XSSFRow row = sheet.getRow(0);   
		
		int rowcount = sheet.getLastRowNum();
		int columncount = row.getLastCellNum();
		
		System.out.println(rowcount+"rowcount");
		System.out.println(columncount+"columncount");
		
		Object[][] coulmnData = new Object[rowcount][columncount];
		
		for(int i=1;i<rowcount+1;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				coulmnData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return coulmnData;
	}
	

}
