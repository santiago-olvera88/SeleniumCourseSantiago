package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\SeleniumJava\\CourseNaveen\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		
		//reader.addSheet("HomePage");
		
		if(!reader.isSheetExist("HomePage")) {
			reader.addSheet("HomePage");
		}
		

		int rowCount = reader.getRowCount("RegTestData");
		System.out.println("Total of numer of rows are: " + rowCount);
		System.out.println(reader.getCellRowNum("RegTestData", "Status", "pass"));
		
		
		int colmnCount = reader.getColumnCount("RegTestData");
		System.out.println("Total of numer of columns are: " + colmnCount);
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Amreen"));

	}
}
