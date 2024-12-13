package com.FW.Listerners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.FW.testbase.TestBase;
import com.FW.utilities.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TestListeners extends TestBase implements ITestListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getName().toUpperCase());		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");

		report.endTest(test);
		report.flush();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			CommonUtils.screenshotCapture();
			Reporter.log("Capturing Screenshot");
			Reporter.log("<a target=\"_blank\" href="+CommonUtils.ScreenshotName+">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href="+CommonUtils.ScreenshotName+"><img src="+CommonUtils.ScreenshotName+" height=200 width=200></img></a>");
			

		} catch (IOException e) {
			
			
		}
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" FAIL: "+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(CommonUtils.ScreenshotName));

		report.endTest(test);
		report.flush();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			CommonUtils.screenshotCapture();
			Reporter.log("Capturing Screenshot");
			Reporter.log("<a target=\"_blank\" href="+CommonUtils.ScreenshotName+">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href="+CommonUtils.ScreenshotName+"><img src="+CommonUtils.ScreenshotName+" height=200 width=200></img></a>");
			
			

		} catch (IOException e) {
			
			
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
