package Excel_Data;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {
	
	
	public static String[][] getexceldata() throws IOException {
		
		String fileLocation = "./test_data/Login_Test.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int lastRownum = sheet.getLastRowNum();
		System.out.println("The last Row is " + lastRownum );
		
		int physicalnum = sheet.getPhysicalNumberOfRows();
		System.out.println("The Physical Number Of Rows is " + physicalnum );
		
		
		short lastCellNum = sheet.getRow(1).getLastCellNum();
		System.out.println("The Last Cell No is "+ lastCellNum) ;
		
		
		  String[][] data = new String[lastRownum][lastCellNum];
		
		for (int i = 1; i <=lastRownum; i++) {
			XSSFRow Row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = Row.getCell(j);
				
				DataFormatter dft = new DataFormatter();
				String Value = dft.formatCellValue(cell);
				System.out.println(Value);
				
				data[i-1][j] = Value;
				
			} 
		}
		
		workbook.close(); 
		return data;

	}
}