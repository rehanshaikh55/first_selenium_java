package day8;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingExcelfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		 FileInputStream file = new FileInputStream("C:\\Users\\shaik\\eclipse-workspace\\seleniumwebdriver\\testdata\\testdata.xlsx");
		 
		 XSSFWorkbook workBook1 = new XSSFWorkbook(file);
		 XSSFSheet sheet = workBook1.getSheet("Sheet1");
		 
		 int totalRow = sheet.getLastRowNum();
		 int totalCol = sheet.getRow(1).getLastCellNum();
		 
		 
		 System.out.println("total num rows are "+ totalRow);
		 System.out.println("total num colomns are "+ totalCol);

		 
		 for(int r=0;r<=totalRow;r++) {
			 
			 XSSFRow currentRow = sheet.getRow(r);
			 for(int c=0;c<totalCol;c++) {
				 System.out.print( currentRow.getCell(c).toString()+"\t\t");
				
				 
			 }
			 System.out.println();
		 }
		 	
	}

}
