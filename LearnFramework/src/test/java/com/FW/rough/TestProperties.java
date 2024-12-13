package com.FW.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	
	public TestProperties() {
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Properties prop=new Properties();		
		Properties prop_or=new Properties();	
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		prop.load(fis);	
		
		System.out.println(prop.getProperty("browser"));
		FileInputStream fisOR=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
		prop_or.load(fisOR);
		System.out.println(prop_or.getProperty("bankManager_btn"));

		
		
	}
	

}
