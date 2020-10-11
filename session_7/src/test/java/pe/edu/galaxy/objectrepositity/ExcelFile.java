package pe.edu.galaxy.objectrepositity;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	public static String path = System.getProperty("user.dir");
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public static void main(String[] args) {
		getRowCount();
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			workbook = new XSSFWorkbook(path + "/data/excel/data.xlsx");
			sheet = workbook.getSheet("Hoja1");
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows" + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
		return rowCount;
	}
}
