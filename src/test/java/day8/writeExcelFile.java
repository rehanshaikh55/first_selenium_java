package day8;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeExcelFile {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	     FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\newfile.xlsx");
	     XSSFWorkbook workbook=new XSSFWorkbook();
	     XSSFSheet sheet= workbook.createSheet("data");
	     

	     XSSFRow row1=sheet.createRow(0);
	     row1.createCell(0).setCellValue("java");
	     row1.createCell(1).setCellValue(377375);
	     row1.createCell(2).setCellValue("automation");
	     
	     XSSFRow row2=sheet.createRow(1);
	     row2.createCell(0).setCellValue("python");
	     row2.createCell(1).setCellValue(377341575);
	     row2.createCell(2).setCellValue("automationpy");
	     
	     XSSFRow row3=sheet.createRow(2);
	     row3.createCell(0).setCellValue("javascript");
	     row3.createCell(1).setCellValue(3375);
	     row3.createCell(2).setCellValue("playweigth");
	     
	     workbook.write(file);
	     workbook.close();
	     file.close();
	     System.out.println("file is created");
	}
	
	
}
