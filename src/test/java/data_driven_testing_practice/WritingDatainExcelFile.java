package data_driven_testing_practice;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDatainExcelFile {

	public static void main(String[] args) throws IOException {
	    //Creating the file path
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\Test_data\\myfile.xlsx");
		//create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//create sheet and sheet name 
		XSSFSheet sheet =workbook.createSheet("data");
		//create rows and enter the data into the cells 
		XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("java");
		row1.createCell(1).setCellValue(1);
		row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("python");
		row2.createCell(1).setCellValue(2);
		row2.createCell(2).setCellValue("Automation");
		
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("C#");
		row3.createCell(1).setCellValue(3);
		row3.createCell(2).setCellValue("Automation");
       // write the data into the workbook
		workbook.write(file);
		workbook.close();
	}

}
