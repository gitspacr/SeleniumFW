package com.FW.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.FW.testbase.TestBase;

public class BankManagerLogin extends TestBase{
	
	
	
	@Test
	public void loginAsBankManager() throws Exception {
		
		try {
			click("bankManager_btn");
//		Assert.fail("Test case is fail");
		Reporter.log("Login successfull");
		}catch(Exception e) {
			
		}
	
	}

	

}
