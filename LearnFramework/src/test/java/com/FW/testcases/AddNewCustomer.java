package com.FW.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FW.testbase.TestBase;

public class AddNewCustomer extends TestBase{

	@Test(dataProvider="supplyData")
	public void addCustomer(String FirstName, String LastName, String PostalCode) throws Exception {
		click("AddCustomer_btn");
		Thread.sleep(2000);
		type("AddCustFirstName_txt", FirstName);
		type("AddCustLastName_txt", LastName);
		type("AddCustPostCode_txt", PostalCode);
		Thread.sleep(2000);
		click("AddCust_btn");
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("Customer added successfully"));
		alert.accept();
//		Assert.fail("Test case is fail");
		Thread.sleep(3000);
	}
	
	@DataProvider(name="supplyData")
	public Object[][] getData() throws IOException {
		 
		
		int totalRows=excel.getRowCount("AddCustomer");
		int totalCols=excel.getCellCount("AddCustomer",1);
		
		Object data[][]=new Object[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) {
			
			for(int j=0;j<totalCols;j++) {
				data[i-1][j]=excel.getCellData("AddCustomer", i, j);
				
			}
		}
		
		
		return data;
		
	}
	
	

}
