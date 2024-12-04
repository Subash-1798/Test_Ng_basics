package utilis;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import Excel_Data.Read_Excel;

public class DataUtilis {


	@DataProvider(name = "getdata")
    public String[][] getdata() throws IOException {
    	

		String[][] exceldata = Read_Excel.getexceldata();
		
		return exceldata;
    }
}
