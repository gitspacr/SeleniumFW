package com.FW.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.FW.testbase.TestBase;

public class CommonUtils extends TestBase {
	
	public static String ScreenshotName;
	
	
	public static void screenshotCapture() throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d=new Date();
		
		ScreenshotName=d.toString().replace(":", " ").replace(" ", "_")+".jpg";
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+ScreenshotName));
		
		
		
		
	}
	
	
	

}
