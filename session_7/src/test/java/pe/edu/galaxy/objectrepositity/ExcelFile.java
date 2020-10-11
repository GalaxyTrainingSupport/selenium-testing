package pe.edu.galaxy.objectrepositity;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	public static String path = System.getProperty("user.dir");
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public static void main(String[] args) {
		getRowCount();
		getColCount();
		getCellDataNumber(1,1);
		getCellDataString(3,0);
	}

	public ExcelFile(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
			}
	} 
	
	
	public static int getRowCount() {
		int rowCount = 0;
		try {
			//HSSFWorkbook .xls (office 97 - 2003)
			workbook = new XSSFWorkbook("/Users/lruiz/Desktop/selenium-testng/session_7/data/data.xlsx");
			sheet = workbook.getSheet("Hoja1");
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows -->" + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getColCount() {
		int colCount = 0;
		try {
			workbook = new XSSFWorkbook("/Users/lruiz/Desktop/selenium-testng/session_7/data/data.xlsx");
			sheet = workbook.getSheet("Hoja1");
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of Cols -->" + colCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static double getCellDataNumber(int rownum, int colnum) {
		double cellData=0;
		try {
		workbook = new XSSFWorkbook(path + "/data/data.xlsx");
		sheet = workbook.getSheet("Hoja1");
		cellData = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		System.out.println("Number double Rows: " + cellData);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
		return cellData;
	}
	
	public static String getCellDataString(int rownum, int colnum) {
		String cellData = null;
		try {
		workbook = new XSSFWorkbook(path + "/data/data.xlsx");
		sheet = workbook.getSheet("Hoja1");
		cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		System.out.println("Number String Rows: " + cellData);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
		return cellData;
	}
}
