package com.FW.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.FW.testbase.TestBase;

public class OpenAccount extends TestBase{

	@Test(dataProvider="supplyData")
	public void openAccountforNewCustomer(String customer,String currency) throws Exception {
//		click("bankManager_btn");
		click("openAcct_btn");
		Thread.sleep(2000);
		
		select("cust_drpdwn", customer);
		select("currency_drpdwn", currency);
		click("process_btn");
		Alert alert=driver.switchTo().alert();
		alert.accept();
				
//		Assert.fail("Test case is fail");
		Thread.sleep(3000);
	}
	
	@DataProvider(name="supplyData")
	public String[][] getData() throws IOException {
		 
		
	
		int totalRows=excel.getRowCount("OpenAccount");
		int totalCols=excel.getCellCount("OpenAccount",1);
		
		String data[][]=new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) {
			
			for(int j=0;j<totalCols;j++) {
				data[i-1][j]=excel.getCellData("OpenAccount", i, j);
				
			}
		}
		
		
		return data;
		
	}
	

}
