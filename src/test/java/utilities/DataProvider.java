//package utilities;
//
//import java.io.IOException;
//
//public class DataProvider {
//
//	@org.testng.annotations.DataProvider(name = "LoginData")
//
//	public String[][] getData() throws IOException {
//
//		String path = System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx";// taking xl file from
//																								// testdata
//
//		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for Xlutility
//
//		int totalrows = xlutil.getRowCount("Sheet1");
//		int totalcols = xlutil.getCellCount("Sheet1", 1);
//
////	String logindata[][]=new String[totalrows] [totalcols]; //created for two dimensional array which can store
////	for(int i=1;i<=totalrows; i++) //1 //read the data from xl storing
////	
////	{
////	for(int j=0;j<totalcols;j++) //0 i is rows jis col
////	{
////		logindata[i-1][j]= xlutil.getCellData ("Sheet1", i, j ); //1,0
////
////	}
////	
////	
////	}
//
//		int datarows = totalrows - 1; // ✓ Exclude header row
//		String logindata[][] = new String[datarows][totalcols];
//		for (int i = 2; i <= totalrows; i++) // ✓ Start from row 2 (skip header in row 1)
//		{
//			for (int j = 0; j < totalcols; j++) {
//				logindata[i - 2][j] = xlutil.getCellData("Sheet1", i, j); // i-2 because we start from i=2
//			}
//		}
//		return logindata;// returning two dimension array
//
//	}
//
//}








package utilities;

import java.io.IOException;

public class DataProvider {

	@org.testng.annotations.DataProvider(name = "LoginData")

	public String[][] getData() throws IOException {
	    String path = System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx";
	    ExcelUtility xlutil = new ExcelUtility(path);

	    int totalrows = xlutil.getRowCount("OpenCart");
//	    int totalcols = xlutil.getCellCount("OpenCart", 0); 
	    int totalcols = 3;
	    int datarows = totalrows - 1;
	    String[][] logindata = new String[datarows][totalcols];
	    for (int i = 1; i <= totalrows - 1; i++) {            // start at row index 1 (first data row)
	        for (int j = 0; j < totalcols; j++) {
	            logindata[i - 1][j] = xlutil.getCellData("OpenCart", i, j);
	        }
	    }
	    return logindata;
	}
}
