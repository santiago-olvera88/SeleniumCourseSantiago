package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel(){

		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\SeleniumJava\\CourseNaveen\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++) {
			
				String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
				String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
				String address1 = reader.getCellData("RegTestData", "address1", rowNum);
				String address2 = reader.getCellData("RegTestData", "address2", rowNum);
				String city = reader.getCellData("RegTestData", "city", rowNum);
				String state = reader.getCellData("RegTestData", "state", rowNum);
				String zipcode = reader.getCellData("RegTestData", "zipcode", rowNum);
				String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
				int rowNumResult = rowNum;

				Object ob[] = {firstName, lastName, address1, address2, city, state, zipcode, emailaddress, rowNumResult};
				myData.add(ob);
				
		}
		return myData;
	
	}
	
	public static void resultTest(int rowNumResult) {
		int colStatusPresent =  reader.getCellRowNum("RegTestData", "Status", "pass");
		if(colStatusPresent == -1) {
			reader.addColumn("RegTestData", "Status");
			reader.setCellData("RegTestData", "Status", rowNumResult, "Pass");
		}else {
			reader.setCellData("RegTestData", "Status", rowNumResult, "Pass");
		}
	}
	

}
