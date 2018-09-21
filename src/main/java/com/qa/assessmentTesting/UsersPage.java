package com.qa.assessmentTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UsersPage {
	
	public boolean checkForUser(WebDriver driver, ExtentTest test, String username) {

		test.log(LogStatus.INFO, "Checking for user existance");

		WebElement user = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText(username)));
		
		if (user.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void clickUsername(WebDriver driver, ExtentTest test, String username) {
		Actions action = new Actions(driver);
		test.log(LogStatus.INFO, "Clicking user");

//		List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"people\"]/tbody"));
//		
//		for (WebElement i : allElements) {
//			System.out.println(i.getText()); 
//		}
		
		WebElement user = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText(username)));
		
		action.moveToElement(user).click().perform();
		
	}
	
	public void configuration(WebDriver driver, ExtentTest test, String username) {
		
	}
}
