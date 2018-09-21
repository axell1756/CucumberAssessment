package com.qa.assessmentTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Hello world!
 *
 */
public class MainPage {
	
	@FindBy(id = "j_username")
	private WebElement usernameField;

	@FindBy(xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordField;

	@FindBy(id = "yui-gen1-button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkins;
	
	@FindBy(xpath = "")
	private WebElement createNewUser;

 	public void login(WebDriver driver, ExtentTest test, String username, String password) {
		test.log(LogStatus.INFO, "Logging in");
		Actions action = new Actions(driver);

		action.moveToElement(usernameField).click().sendKeys(username).perform();

		action.moveToElement(passwordField).click().sendKeys(password).perform();

		action.moveToElement(submitButton).click().perform();
		
		action.moveToElement(submitButton).click().perform();

	}

	public void navigateCreateUser(WebDriver driver, ExtentTest test) {
		Actions action = new Actions(driver);
		test.log(LogStatus.INFO, "Navigating to Create User");
		
		action.moveToElement(manageJenkins).click().perform();
		
		WebElement manageUsers = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")));
		action.moveToElement(manageUsers).click().perform();
		
		WebElement createUser = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tasks\"]/div[3]/a[2]")));
		action.moveToElement(createUser).click().perform();
		
	}

	public void navigateUsers(WebDriver driver, ExtentTest test) {
		Actions action = new Actions(driver);
		test.log(LogStatus.INFO, "Navigating to Users");
		
		action.moveToElement(manageJenkins).click().perform();
		
		WebElement manageUsers = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")));
		action.moveToElement(manageUsers).click().perform();
		
	}
}
