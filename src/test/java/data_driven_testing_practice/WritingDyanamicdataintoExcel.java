package data_driven_testing_practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDyanamicdataintoExcel {

    public static void main(String[] args) {
        // Try-with-resources to ensure proper resource management
        try (Scanner sc = new Scanner(System.in);
             XSSFWorkbook workbook = new XSSFWorkbook()) {

            // Define file path dynamically
            String filePath = System.getProperty("user.dir") + "\\Test_data\\Dynamic_datafile.xlsx";
            FileOutputStream file = new FileOutputStream(filePath);

            // Create a new sheet
            XSSFSheet sheet = workbook.createSheet("DynamicData");

            System.out.println("Enter how many rows?");
            int noOfRows = sc.nextInt();

            System.out.println("Enter how many cells?");
            int noOfCells = sc.nextInt();

            System.out.println("Enter the data...");

            for (int r = 0; r < noOfRows; r++) { // Use 0-based indexing for rows
                XSSFRow currentRow = sheet.createRow(r);

                for (int c = 0; c < noOfCells; c++) { // Use 0-based indexing for cells
                    XSSFCell cell = currentRow.createCell(c);
                    System.out.print("Enter data for Row " + (r + 1) + ", Cell " + (c + 1) + ": ");
                    cell.setCellValue(sc.next());
                }
            }

            // Write data to the file
            workbook.write(file);
            System.out.println("Excel file created successfully at: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
