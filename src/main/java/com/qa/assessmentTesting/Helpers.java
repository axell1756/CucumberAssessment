package com.qa.assessmentTesting;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Helpers {

	public static String takeScreenshot(WebDriver webdriver, String path) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot screenshot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File source = screenshot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File destination = new File(path);

		// Copy file at destination

		Files.copy(source, destination);
		
		return path;

	}
	
	

}
