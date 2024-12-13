package com.FW.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.FW.TestData.ExcelUtility;
import com.FW.utilities.ExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {
	
	/*Webdriver
	 *Properties
	 *Logs
	 *Excel
	 *Extent Reports
	 *DB
	 *ReportNG
	 */
	
	public static WebDriver driver;
	public static Properties prop=new Properties();		
	public static Properties prop_or=new Properties();	
	public static FileInputStream fis;
	public static Logger log=LogManager.getLogger(TestBase.class);
	public static ExtentReports report=ExtentReport.getInstance();
	public static ExtentTest test;
	public static ExcelUtility excel=new ExcelUtility(".\\TestData\\TestDataSheet.xlsx");
	
	@BeforeSuite
	public void browserLaunch() throws IOException {
		
		if(driver==null) {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
			prop.load(fis);	
			log.debug("loads properties file");
			System.out.println(prop.getProperty("browser"));
			FileInputStream fisOR=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
			prop_or.load(fisOR);
			log.debug("loads OR properties file");
		}
		
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
			log.debug("Chrome browser launched successfully");
			
		}else if(prop.getProperty("ffBrowser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			log.debug("Firefox browser launched successfully");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		log.debug("Navigaye to: "+prop.getProperty("url"));
		
	}
	
	public boolean elementIsPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public static void click(String locator) {
		
		driver.findElement(By.xpath(prop_or.getProperty(locator))).click();
		test.log(LogStatus.INFO, "clicked on locator: "+locator);
		
	}
	
	public static void type(String locator, String value) {
		
		driver.findElement(By.xpath(prop_or.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "typing in: "+locator+" enter value as: "+value);
		
	}
	
	static WebElement dropdown;
	
	public void select(String locator, String value) {
		dropdown =driver.findElement(By.xpath(prop_or.getProperty(locator)));
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
		test.log(LogStatus.INFO, "Select from dropdown: "+locator+" enter value as: "+value);

	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
		log.debug("Execution is completed");
	}
	
	

}
