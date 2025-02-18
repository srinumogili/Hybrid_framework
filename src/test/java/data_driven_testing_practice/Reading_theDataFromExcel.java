package data_driven_testing_practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_theDataFromExcel {

	//Excel File ->workbook->sheets->rows->cells
	public static void main(String[] args) throws IOException {
		
		//To get the file
		FileInputStream File = new FileInputStream(System.getProperty("user.dir")+"\\Test_data\\Test_data.xlsx");
		//to get the workbook
		XSSFWorkbook workbook= new XSSFWorkbook(File);
		//To search the file 
		 XSSFSheet sheet=workbook.getSheet("Sheet1");
		 //count the rows 
		int totalrows= sheet.getLastRowNum();
		//count the cells 
		int totalcells= sheet.getRow(1).getLastCellNum();
		
		System.out.println(totalrows);
		System.out.println(totalcells);
		
		for(int r=0;r<=totalrows;r++) {
		XSSFRow currentrows = sheet.getRow(r);

	
		for(int c=0;c<totalcells;c++) {
			XSSFCell cells=currentrows.getCell(c);
			System.out.print(cells.toString()+"\t");
		}
		System.out.println();
		
	}
File.close();
workbook.close();
}

}